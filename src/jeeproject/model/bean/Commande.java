package jeeproject.model.bean;

import java.util.Date;

public class Commande {
	
	private int numCommande;
	private Date dateCommande;
	private Date dateLivraison;
	
	public Commande(){
		
	}

	public Commande(int numCommande, Date dateCommande, Date dateLivraison) {
		super();
		this.numCommande = numCommande;
		this.dateCommande = dateCommande;
		this.dateLivraison = dateLivraison;
	}

	public int getNumCommande() {
		return numCommande;
	}

	public void setNumCommande(int numCommande) {
		this.numCommande = numCommande;
	}

	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	public Date getDateLivraison() {
		return dateLivraison;
	}

	public void setDateLivraison(Date dateLivraison) {
		this.dateLivraison = dateLivraison;
	}
	
	

}
