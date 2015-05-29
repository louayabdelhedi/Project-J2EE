package jeeproject.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import jeeproject.bean.Bean;
import jeeproject.bean.Commande;
import jeeproject.bean.Facture;
import jeeproject.hibernate.dao.HibernateConnexion;

public class FactureDao extends Dao {

	public FactureDao(Session session) {

		this.session=session;

	}

	@Override
	public boolean update(Bean bean) {
		Facture facture = (Facture) bean;
		Query query = session
				.createQuery(" from Facture where numFacture=:ref");
		query.setInteger("ref", facture.getNumFacture());
		Iterator factures = query.iterate();

		Facture factureToUpdate = (Facture) factures.next();

		factureToUpdate = (Facture) session.get(Facture.class,
				factureToUpdate.getNumFacture());
		System.out.println("Num Facture=>>>>>" + factureToUpdate.getMontant());

		factureToUpdate.setCommande(facture.getCommande());
		factureToUpdate.setDateFacture(facture.getDateFacture());
		factureToUpdate.setMontant(facture.getMontant());

		try {
			transaction = session.beginTransaction();
			session.update(factureToUpdate);
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

		Facture facture = (Facture) bean;
		Query query = session
				.createQuery(" from Facture where numFacture=:ref");
		query.setInteger("ref", facture.getNumFacture());
		Iterator factures = query.iterate();
		Facture factureToDelete = (Facture) factures.next();
		factureToDelete = (Facture) session.get(Facture.class,
				factureToDelete.getNumFacture());

		try {
			transaction = session.beginTransaction();
			session.delete(factureToDelete);
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
		Query req = session.createQuery("from Facture");

		List<Bean> factures = (List<Bean>) req.list();

		return factures;
	}

	@Override
	public Bean search(int id) {
		Query query = session.createQuery("from Facture where numFacture=:ref");
		query.setInteger("ref", id);
		Bean facture = (Bean) query.list().get(0);

		return facture;
	}

}
