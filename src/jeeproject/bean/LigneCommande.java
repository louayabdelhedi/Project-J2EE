package jeeproject.bean;

import java.awt.geom.Arc2D;
import java.io.Serializable;

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
public class LigneCommande implements Serializable, Bean {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "numLigne")
	private int numLigne;

	@Column(name = "quantiteCommande")
	private int quantiteCommande;

	@ManyToOne
	@JoinColumn(name = "idArticle")
	private Article article;

	@ManyToOne
	@JoinColumn(name = "numCommande")
	private Commande commande;

	public LigneCommande() {

	}

	public LigneCommande(int numLigne, int quantiteCommande, Article article,
			Commande commande) {
		super();
		this.numLigne = numLigne;
		this.quantiteCommande = quantiteCommande;
		this.article = article;
		this.commande = commande;
	}

	public int getNumLigne() {
		return numLigne;
	}

	public void setNumLigne(int numLigne) {
		this.numLigne = numLigne;
	}

	public int getQuantiteCommande() {
		return quantiteCommande;
	}

	public void setQuantiteCommande(int quantiteCommande) {
		this.quantiteCommande = quantiteCommande;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

}
