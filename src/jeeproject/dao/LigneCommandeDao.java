package jeeproject.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import jeeproject.bean.Article;
import jeeproject.bean.Bean;
import jeeproject.bean.LigneCommande;
import jeeproject.hibernate.dao.HibernateConnexion;

public class LigneCommandeDao extends Dao {

	public LigneCommandeDao(Session session) {

		this.session=session;

	}

	@Override
	public boolean update(Bean bean) {

		LigneCommande ligneCommande = (LigneCommande) bean;
		Query query = session
				.createQuery(" from LigneCommande where numLigne=:ref");
		query.setInteger("ref", ligneCommande.getNumLigne());
		Iterator ligneCommandes = query.iterate();

		LigneCommande ligneCommandeToUpdate = (LigneCommande) ligneCommandes
				.next();

		ligneCommandeToUpdate = (LigneCommande) session.get(LigneCommande.class,
				ligneCommandeToUpdate.getNumLigne());
//		System.out.println("Article du ligne de commande=>>>>>"
//				+ ligneCommandeToUpdate.getArticle());

		ligneCommandeToUpdate.setArticle(ligneCommande.getArticle());
		ligneCommandeToUpdate.setCommande(ligneCommande.getCommande());
		ligneCommandeToUpdate.setQuantiteCommande(ligneCommande
				.getQuantiteCommande());

		try {
			transaction = session.beginTransaction();
			session.update(ligneCommandeToUpdate);
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

		LigneCommande ligneCommande = (LigneCommande) bean;
		Query query = session
				.createQuery(" from LigneCommande where numLigne=:ref");
		query.setInteger("ref", ligneCommande.getNumLigne());
		Iterator ligneCommandes = query.iterate();
		LigneCommande ligneCommandeToDelete = (LigneCommande) ligneCommandes.next();
		ligneCommandeToDelete = (LigneCommande) session.get(LigneCommande.class,
				ligneCommandeToDelete.getNumLigne());

		try {
			transaction = session.beginTransaction();
			session.delete(ligneCommandeToDelete);
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
		
		Query req = session.createQuery("from LigneCommande");

		List<Bean> ligneCommandes = (List<Bean>) req.list();

		return ligneCommandes;

	}

	@Override
	public Bean search(int id) {
		Query query = session
				.createQuery("from LigneCommande where numCommande=:ref");
		query.setInteger("ref", id);
		Bean article = (Bean) query.list().get(0);

		return article;
	}

}
