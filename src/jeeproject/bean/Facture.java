package jeeproject.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ligneCommande")
public class Facture implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "numFacture")
	private int numFacture;
	
	@Column(name = "dateFacture")
	private Date dateFacture;
	
	@Column(name = "montant")
	private float montant;
	
	@ManyToOne
    @JoinColumn(name="numCommande")
	private int numCommande;

	public Facture() {

	}

	public Facture(int numFacture, Date dateFacture, float montant,
			int numCommande) {
		super();
		this.numFacture = numFacture;
		this.dateFacture = dateFacture;
		this.montant = montant;
		this.numCommande = numCommande;
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

	public int getNumCommande() {
		return numCommande;
	}

	public void setNumCommande(int numCommande) {
		this.numCommande = numCommande;
	}

}
