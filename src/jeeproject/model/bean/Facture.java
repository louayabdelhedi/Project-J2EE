package jeeproject.model.bean;

import java.util.Date;

public class Facture {
	
	private int numFacture;
	private Date dateFacture;
	private float montant;
	
	public Facture(){
		
	}

	public Facture(int numFacture, Date dateFacture, float montant) {
		super();
		this.numFacture = numFacture;
		this.dateFacture = dateFacture;
		this.montant = montant;
	}

	public int getNumFacture() {
		return numFacture;
	}

	public void setNumFacture(int numFacture) {
		this.numFacture = numFacture;
	}

	public Date getDateFacture() {
		return dateFacture;
	}

	public void setDateFacture(Date dateFacture) {
		this.dateFacture = dateFacture;
	}

	public float getMontant() {
		return montant;
	}

	public void setMontant(float montant) {
		this.montant = montant;
	}

	
	
}
