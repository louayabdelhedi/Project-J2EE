package test;

import jeeproject.bean.*;
import jeeproject.dao.ArticleDao;
import jeeproject.dao.ClientDao;
import jeeproject.dao.CommandeDao;
import jeeproject.dao.Dao;
import jeeproject.dao.EmployeDao;
import jeeproject.dao.FactureDao;
import jeeproject.dao.FamilleArticleDao;
import jeeproject.dao.LigneCommandeDao;
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

		HibernateConnexion connexion = new HibernateConnexion();
		connexion.openHibernateConnexion();
		
		Employe emp= new Employe();
		emp.setAdresseEmploye("sfax");
		emp.setCinEmploye(145);
		emp.setLoginEmploye("bradai");
		emp.setMpEmploye("louay");
		emp.setNomEmploye("louay");
		emp.setPrenomEmploye("abd");
		
	Client client= new Client();
		client.setAdresseClient("sfax");
	client.setCinClient(01555);
	client.setNomClient("louaaaa");
	client.setIdClient(22);
		
		Dao empDao= new EmployeDao(connexion.getSession());
		//Employe emp1=(Employe) ((EmployeDao)empDao).search("bradai","louay");
		Employe emp1=(Employe) ((EmployeDao)empDao).search("louay");
		System.out.println(emp1.getLoginEmploye());
		
		Commande commande= new Commande();
		commande.setClient(client);
		commande.setDateCommande(new Date());
		commande.setDateLivraison(new Date());
		
		
		CommandeDao commandeDao= new CommandeDao(connexion.getSession());
		commande.setNumCommande(17);
	//	commandeDao.update(commande);
		
		//empDao.create(emp);

//		Dao articleDao = new ArticleDao(connexion);
//		// employeDao.delete(emp);
//		articleDao.update(article);
//		List<Bean> articles = articleDao.listAll();
//		
//		for (Bean object : articles) {
//			System.out.println(((Article) object).getLibelleArticle());
//		}
		Article article= new Article();
		article.setIdArticle(2);
		LigneCommande ligneCommande= new LigneCommande();
		ligneCommande.setNumLigne(4);
//		ligneCommande.setArticle(article);
//		ligneCommande.setCommande(commande);
//		ligneCommande.setQuantiteCommande(50);
		LigneCommandeDao ligneCommandeDao= new LigneCommandeDao(connexion.getSession());
		//ligneCommandeDao.create(ligneCommande);
		//ligneCommandeDao.update(ligneCommande);
		//ligneCommandeDao.delete(ligneCommande);
		
		Facture facture=new Facture();
		//facture.setCommande(commande.getNumCommande());
		//facture.setDateFacture(new Date());
		//facture.setMontant((float)20.5);
		
		FactureDao factureDao= new FactureDao(connexion.getSession());
		
		facture.setNumFacture(5);
//		facture.setCommande(commande);
//		facture.setMontant((float)40.5);
//		facture.setDateFacture(new Date());
//		//factureDao.create(facture);
		//factureDao.delete(facture);
//		
		FamilleArticle familleArticle= new FamilleArticle();
		familleArticle.setNomFamille("jdidaaa");
		FamilleArticleDao familleArticleDao= new FamilleArticleDao(connexion.getSession());
	//familleArticle.setIdFamille(20);
		//familleArticleDao.create(familleArticle);
		familleArticleDao.create(familleArticle);

		
		connexion.closeHibernateConnexion();
		
	}

}
