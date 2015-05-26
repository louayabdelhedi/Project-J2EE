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

	public boolean create(Article article) {
		
		try {
			transaction = session.beginTransaction();
			session.save(article);

			transaction.commit();
			
		} catch (RuntimeException exc) {
			
			exc.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(String libelleArticle, int referenceArticle,
			float prixHtArticle, float tvaArticle, int quantiteArticle,
			FamilleArticle familleArticle) {

		Query query = session
				.createQuery(" from Article where referenceArticle=:ref");
		query.setInteger("ref", referenceArticle);
		Iterator articles = query.iterate();

		Article article = (Article) articles.next();
		article = (Article) session.get(Article.class, article.getIdArticle());
		System.out
				.println("Nom articleeee=>>>>>" + article.getLibelleArticle());

		article.setLibelleArticle(libelleArticle);
		article.setReferenceArticle(referenceArticle);
		article.setPrixHtArticle(prixHtArticle);
		article.setTvaArticle(tvaArticle);
		article.setQuantiteArticle(quantiteArticle);
		article.setFamilleArticle(familleArticle);
		try {
			transaction = session.beginTransaction();
			session.update(article);
			transaction.commit();
		} catch (RuntimeException exc) {

			exc.printStackTrace();
			return false;
		}
		return true;

	}

	public boolean delete(int referenceArticle) {

		Query query = session
				.createQuery(" from Article where referenceArticle=:ref");
		query.setInteger("ref", referenceArticle);
		Iterator articles = query.iterate();
		Article article = (Article) articles.next();
		article = (Article) session.get(Article.class, article.getIdArticle());

		try {
			transaction = session.beginTransaction();
			session.delete(article);
			transaction.commit();
		} catch (RuntimeException exc) {

			exc.printStackTrace();
			return false;
		}
		return true;

	}

	public List<Article> listAll() {

		Query req = session.createQuery("from Article");

		// req.setInteger(0, 7);
		List<Article> articles = (List<Article>) req.list();
//		for (Article article : articles) {
//			System.out.println(article.getLibelleArticle());
//		}
		return articles;
	}

	public Bean read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
