package jeeproject.dao;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import jeeproject.bean.Article;
import jeeproject.bean.Bean;
import jeeproject.bean.Employe;
import jeeproject.hibernate.dao.HibernateConnexion;

public class EmployeDao extends Dao {

	HibernateConnexion connexion;
	Transaction transaction;
	Session session;

	public EmployeDao(HibernateConnexion connexion) {

		this.connexion = connexion;
		session = connexion.getSession();

	}

	@Override
	public boolean create(Bean bean) {
		Employe employe=	(Employe)bean;
		employe.setMpEmploye(md5(employe.getMpEmploye()));
		try {
			transaction = session.beginTransaction();

			session.save(bean);

			transaction.commit();

		} catch (RuntimeException exc) {
			if (transaction != null)
				transaction.rollback();
			exc.printStackTrace();
			return false;
		} finally {
			session.flush();
		}
		return true;
	}

	@Override
	public boolean update(Bean bean) {
		Query query = session
				.createQuery(" from Employe where loginEmploye=:ref");
		query.setString("ref", ((Employe) bean).getLoginEmploye());
		Iterator employes = query.iterate();

		Employe employe = (Employe) employes.next();
		employe = (Employe) session.get(Employe.class,
				employe.getLoginEmploye());
		System.out.println("Nom Employee=>>>>>" + employe.getNomEmploye());

		employe.setAdresseEmploye(((Employe) bean).getAdresseEmploye());
		employe.setCinEmploye(((Employe) bean).getCinEmploye());
		employe.setLoginEmploye(((Employe) bean).getLoginEmploye());
		employe.setMpEmploye(((Employe) bean).getMpEmploye());
		employe.setNomEmploye(((Employe) bean).getNomEmploye());
		employe.setPrenomEmploye(((Employe) bean).getPrenomEmploye());
		try {
			transaction = session.beginTransaction();
			session.update(employe);
			transaction.commit();
		} catch (RuntimeException exc) {
			if (transaction != null)
				transaction.rollback();
			exc.printStackTrace();
			return false;
		} finally {
			session.flush();
		}
		return true;
	}

	@Override
	public boolean delete(Bean bean) {

		Employe employe = (Employe) bean;
		Query query = session
				.createQuery(" from Employe where loginEmploye=:ref");
		query.setString("ref", employe.getLoginEmploye());
		Iterator employes = query.iterate();
		employe = (Employe) employes.next();
		employe = (Employe) session.get(Employe.class,
				employe.getLoginEmploye());

		try {
			transaction = session.beginTransaction();
			session.delete(employe);
			transaction.commit();
		} catch (RuntimeException exc) {
			if (transaction != null)
				transaction.rollback();
			exc.printStackTrace();
			return false;
		} finally {
			session.flush();
		}
		return true;
	}

	@Override
	public List<Bean> listAll() {
		Query req = session.createQuery("from Employe");

		List<Bean> employes = (List<Bean>) req.list();

		return employes;
	}

	public Bean search(String login, String mptPasse) {
		Query query = session
				.createQuery("from Employe where loginEmploye=:ref and mpEmploye=:mp");
		query.setString("ref", login);
		query.setString("mp", md5(mptPasse));
		Bean employe = (Bean) query.list().get(0);

		return employe;

	}

	public static String md5(String input) {

		String md5 = null;

		if (null == input)
			return null;

		try {

			// Create MessageDigest object for MD5
			MessageDigest digest = MessageDigest.getInstance("MD5");

			// Update input string in message digest
			digest.update(input.getBytes(), 0, input.length());

			// Converts message digest value in base 16 (hex)
			md5 = new BigInteger(1, digest.digest()).toString(16);

		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();
		}
		return md5;
		
		
	}

}
