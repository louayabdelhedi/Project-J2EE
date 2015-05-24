package jeeproject.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "facture")
public class Facture implements Serializable, Bean {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "numFacture")
	private int numFacture;

	@Column(name = "dateFacture")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateFacture;

	@Column(name = "montant")
	private float montant;

	@OneToOne
	@JoinColumn(name = "numCommande")
	private Commande commande;

	public Facture() {

	}

	public Facture(int numFacture, Date dateFacture, float montant,
			Commande commande) {
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

	public Commande getNumCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

}
