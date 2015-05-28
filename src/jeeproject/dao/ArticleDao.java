package jeeproject.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import jeeproject.bean.Article;
import jeeproject.bean.Bean;
import jeeproject.bean.FamilleArticle;
import jeeproject.hibernate.dao.HibernateConnexion;

public class ArticleDao extends Dao {

	HibernateConnexion connexion;
	Transaction transaction;
	Session session;

	public ArticleDao(HibernateConnexion connexion) {

		this.connexion = connexion;
		session = connexion.getSession();

	}

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

		Article article = (Article) bean;
		Query query = session
				.createQuery(" from Article where referenceArticle=:ref");
		query.setInteger("ref", article.getReferenceArticle());
		Iterator articles = query.iterate();

		
		Article articleToUpdate = (Article) articles.next();
		
		articleToUpdate = (Article) session.get(Article.class,
				articleToUpdate.getIdArticle());
		System.out.println("Nom articleeee=>>>>>"
				+ articleToUpdate.getLibelleArticle());

		articleToUpdate.setLibelleArticle(article.getLibelleArticle());
		articleToUpdate.setReferenceArticle(article.getReferenceArticle());
		articleToUpdate.setPrixHtArticle(article.getPrixHtArticle());
		articleToUpdate.setTvaArticle(article.getTvaArticle());
		articleToUpdate.setQuantiteArticle(article.getQuantiteArticle());
		articleToUpdate.setFamilleArticle(article.getFamilleArticle());
		try {
			transaction = session.beginTransaction();
			session.update(articleToUpdate);
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

		Article article = (Article) bean;
		Query query = session
				.createQuery(" from Article where referenceArticle=:ref");
		query.setInteger("ref", article.getReferenceArticle());
		Iterator articles = query.iterate();
		Article articleToDelete = (Article) articles.next();
		articleToDelete = (Article) session.get(Article.class,
				articleToDelete.getIdArticle());

		try {
			transaction = session.beginTransaction();
			session.delete(articleToDelete);
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

		Query req = session.createQuery("from Article");

		List<Bean> articles = (List<Bean>) req.list();

		return articles;
	}

	@Override
	public Bean search(int id) {
		// TODO Auto-generated method stub
		return super.search(id);
	}

}
