package jeeproject.bean;

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
public class LigneCommande implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "numLigne")
	private int numLigne;
	
	@Column(name = "quantiteCommande")
	private int quantiteCommande;
	
	@ManyToOne
    @JoinColumn(name="idArticle")
	private int idArticle;
	
	@ManyToOne
    @JoinColumn(name="numCommande")
	private int numCommande;

	public LigneCommande() {

	}

	public LigneCommande(int numLigne, int quantiteCommande, int idArticle,
			int numCommande) {
		super();
		this.numLigne = numLigne;
		this.quantiteCommande = quantiteCommande;
		this.idArticle = idArticle;
		this.numCommande = numCommande;
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

	public int getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}

	public int getNumCommande() {
		return numCommande;
	}

	public void setNumCommande(int numCommande) {
		this.numCommande = numCommande;
	}

}
