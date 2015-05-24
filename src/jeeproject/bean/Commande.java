package jeeproject.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "commande")
public class Commande implements Serializable,Bean {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "numCommande")
	private int numCommande;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dateCommande")
	private Date dateCommande;

	@Column(name = "dateLivraison")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateLivraison;

	@ManyToOne
	@JoinColumn(name = "idClient")
	private Client client;

	@OneToMany(mappedBy = "commande")
	private List<LigneCommande> ligneCommandes;

	
	@OneToOne(mappedBy = "commande")
	private Facture facture;

	public Commande() {

	}

	public Commande(int numCommande, Date dateCommande, Date dateLivraison,
			Client client) {
		super();
		this.numCommande = numCommande;
		this.dateCommande = dateCommande;
		this.dateLivraison = dateLivraison;
		this.client = client;
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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}
