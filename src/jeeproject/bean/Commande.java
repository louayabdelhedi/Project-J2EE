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
@Table(name = "commande")
public class Commande implements Serializable{

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "numCommande")
	private int numCommande;
	
	@Column(name = "dateCommande")
	private Date dateCommande;
	
	@Column(name = "dateLivraison")
	private Date dateLivraison;
	
	@ManyToOne
    @JoinColumn(name="idClient")
	private int idClient;

	public Commande() {

	}

	public Commande(int numCommande, Date dateCommande, Date dateLivraison,
			int idClient) {
		super();
		this.numCommande = numCommande;
		this.dateCommande = dateCommande;
		this.dateLivraison = dateLivraison;
		this.idClient = idClient;
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

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

}
