package jeeproject.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import jeeproject.bean.Bean;
import jeeproject.bean.Commande;
import jeeproject.bean.FamilleArticle;
import jeeproject.hibernate.dao.HibernateConnexion;

public class FamilleArticleDao extends Dao{

	
	public FamilleArticleDao(Session session) {

		this.session=session;

	}
	@Override
	public boolean update(Bean bean) {
		FamilleArticle familleArticle = (FamilleArticle) bean;
		Query query = session
				.createQuery(" from FamilleArticle where nomFamille=:ref");
		query.setString("ref", familleArticle.getNomFamille());
		Iterator familleArticles = query.iterate();

		FamilleArticle familleArticleToUpdate = (FamilleArticle) familleArticles.next();

		familleArticleToUpdate = (FamilleArticle) session.get(FamilleArticle.class,
				familleArticleToUpdate.getIdFamille());
		System.out.println("Nom famile article=>>>>>"
				+ familleArticleToUpdate.getNomFamille());

		familleArticleToUpdate.setNomFamille(familleArticle.getNomFamille());
		
		try {
			transaction = session.beginTransaction();
			session.update(familleArticleToUpdate);
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
		FamilleArticle familleArticle = (FamilleArticle) bean;
		Query query = session
				.createQuery(" from FamilleArticle where nomFamille=:ref");
		query.setString("ref", familleArticle.getNomFamille());
		Iterator familleArticles = query.iterate();
		FamilleArticle familleArticleToDelete = (FamilleArticle) familleArticles.next();
		familleArticleToDelete = (FamilleArticle) session.get(FamilleArticle.class,
				familleArticleToDelete.getIdFamille());

		try {
			transaction = session.beginTransaction();
			session.delete(familleArticleToDelete);
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
		Query req = session.createQuery("from FamilleArticle");

		List<Bean> familleArticles = (List<Bean>) req.list();

		return familleArticles;
	}

	@Override
	public Bean search(int id) {
		return null;
	}
	
	public Bean search(String id) {
		Query query = session
				.createQuery("from FamilleArticle where nomFamille=:ref");
		query.setString("ref", id);
		Bean familleArticle = (Bean) query.list().get(0);

		return familleArticle;
	}

	

}
