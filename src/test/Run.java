package test;

import jeeproject.bean.*;
import jeeproject.dao.ArticleDao;
import jeeproject.hibernate.dao.HibernateConnexion;
import jeeproject.hibernate.dao.HibernateSessionManager;

import java.awt.geom.Arc2D;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class Run {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Session session =
		// HibernateSessionManager.getSessionFactory().openSession();
		Session session = null;

		// session.beginTransaction();
		HibernateConnexion connexion = new HibernateConnexion();
		connexion.openHibernateConnexion();

		// session=connexion.getSession();
		// session.beginTransaction();

		// Client client = new Client();
		//
		// client.setNomClient("louay");
		// client.setTelClient(222222);
		// client.setVilleClient("sfax");
		// client.setAdresseClient("route de gremda");
		//
		// session.save(client);

		FamilleArticle famille = new FamilleArticle();

		famille.setNomFamille("informatique");

		session = connexion.getSession();
		session.beginTransaction();
		session.save(famille);
		session.getTransaction().commit();
		// session.getTransaction().commit();
		Article article = new Article();
		article.setLibelleArticle("Article 1");
		article.setPrixHtArticle(15);
		article.setQuantiteArticle(3);
		article.setReferenceArticle(1516);
		article.setTvaArticle(15);
		article.setFamilleArticle(famille);

		// session.save(article);

		/*
		 * Commande commande = new Commande();
		 * 
		 * commande.setDateCommande(new Date()); commande.setDateLivraison(new
		 * Date()); commande.setClient(client);
		 * 
		 * session.save(commande);
		 * 
		 * LigneCommande ligne=new LigneCommande();
		 * 
		 * ligne.setQuantiteCommande(20); ligne.setArticle(article);
		 * ligne.setCommande(commande);
		 * 
		 * session.save(ligne);
		 * 
		 * 
		 * Employe emp= new Employe(); emp.setAdresseEmploye("Sfax");
		 * emp.setCinEmploye(8884097); emp.setLoginEmploye("louay");
		 * emp.setMpEmploye("louay"); emp.setNomEmploye("louay");
		 * emp.setPrenomEmploye("abd");
		 * 
		 * session.save(emp);
		 */
		ArticleDao articleDao = new ArticleDao(connexion);
		// System.out.println("Result ========>"+articleDao.update("louay",
		// 1515, 50, 50, 50, famille));
		// System.out.println("Result ========>"+articleDao.delete(1515));
		// System.out.println("Result ========>"+articleDao.create(article));
		List<Article> articles = articleDao.listAll();
		for (Article article1 : articles) {
			System.out.println(article.getLibelleArticle());

		}
		/*
		 * Client client = new Client();
		 * 
		 * client.setNomClient("louay"); client.setTelClient(222222);
		 * client.setVilleClient("sfax");
		 * client.setAdresseClient("route de gremda");
		 * 
		 * session.save(client);
		 * 
		 * Commande commande = new Commande();
		 * 
		 * commande.setDateCommande(new Date()); commande.setDateLivraison(new
		 * Date()); commande.setClient(client);
		 * 
		 * session.save(commande);
		 * 
		 * Facture facture= new Facture(); facture.setDateFacture(new Date());
		 * facture.setMontant(Float.parseFloat("2.5"));
		 * facture.setCommande(commande);
		 * 
		 * session.save(facture);
		 */

		Query req = session.createQuery("from FamilleArticle");

		// req.setInteger(0, 7);
		List<FamilleArticle> list = (List<FamilleArticle>) req.list();
		for (FamilleArticle famille1 : list) {
			System.out.println(famille1.getNomFamille());
		}
		// session.getTransaction().commit();
		HibernateSessionManager.shutdown();
		// connexion.closeHibernateConnexion();
	}

}
