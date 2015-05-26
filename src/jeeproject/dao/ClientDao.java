package jeeproject.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import jeeproject.bean.Bean;
import jeeproject.bean.Client;
import jeeproject.hibernate.dao.HibernateConnexion;

public class ClientDao {

	HibernateConnexion connexion;
	Transaction transaction;
	Session session;

	public ClientDao(HibernateConnexion connexion) {

		this.connexion = connexion;
		session = connexion.getSession();

	}

	public boolean create(Client client) {

		try {
			transaction = session.beginTransaction();
			session.save(client);

			transaction.commit();

		} catch (RuntimeException exc) {

			exc.printStackTrace();
			return false;
		}

		return true;
	}

	public boolean update(Bean bean) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(Bean bean) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Bean> listAll(Bean bean) {
		// TODO Auto-generated method stub
		return null;
	}

	public Bean read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
