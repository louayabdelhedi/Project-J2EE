package jeeproject.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import jeeproject.bean.Article;
import jeeproject.bean.Bean;
import jeeproject.bean.Commande;
import jeeproject.hibernate.dao.HibernateConnexion;

public class CommandeDao extends Dao {

	HibernateConnexion connexion;
	Transaction transaction;
	Session session;

	@Override
	public boolean create(Bean bean) {
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
		Commande commande = (Commande) bean;
		Query query = session
				.createQuery(" from Commande where numCommande=:ref");
		query.setInteger("ref", commande.getNumCommande());
		Iterator commandes = query.iterate();

		Commande commandeToUpdate = (Commande) commandes.next();

		commandeToUpdate = (Commande) session.get(Commande.class,
				commandeToUpdate.getNumCommande());
		System.out.println("Nom articleeee=>>>>>"
				+ commandeToUpdate.getDateCommande());

		commandeToUpdate.setClient(commande.getClient());
		commandeToUpdate.setDateCommande(commande.getDateCommande());
		commandeToUpdate.setDateLivraison(commande.getDateLivraison());
		commandeToUpdate.setNumCommande(commande.getNumCommande());
		try {
			transaction = session.beginTransaction();
			session.update(commandeToUpdate);
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
		Commande commande = (Commande) bean;
		Query query = session
				.createQuery(" from Commande where numCommande=:ref");
		query.setInteger("ref", commande.getNumCommande());
		Iterator commandes = query.iterate();
		Commande commandeToDelete = (Commande) commandes.next();
		commandeToDelete = (Commande) session.get(Commande.class,
				commandeToDelete.getNumCommande());

		try {
			transaction = session.beginTransaction();
			session.delete(commandeToDelete);
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

	public List<Bean> listAll(Bean bean) {
		Query req = session.createQuery("from Commande");

		List<Bean> commandes = (List<Bean>) req.list();

		return commandes;
	}

	@Override
	public Bean search(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
