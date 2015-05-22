package jeeproject.bean;

import java.awt.geom.Arc2D;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "article")
public class Article implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idArticle")
	private int idArticle;

	@Column(name = "libelleArticle")
	private String libelleArticle;

	@Column(name = "referenceArticle")
	private int referenceArticle;

	@Column(name = "prixHtArticle")
	private float prixHtArticle;

	@Column(name = "tvaArticle")
	private float tvaArticle;

	@Column(name = "quantiteArticle")
	private int quantiteArticle;

	@ManyToOne
    @JoinColumn(name="idFamille")
	private int idFamille;

	public Article() {

	}

	public Article(int idArticle, String libelleArticle, int referenceArticle,
			float prixHtArticle, float tvaArticle, int quantiteArticle,
			int idFamille) {
		super();
		this.idArticle = idArticle;
		this.libelleArticle = libelleArticle;
		this.referenceArticle = referenceArticle;
		this.prixHtArticle = prixHtArticle;
		this.tvaArticle = tvaArticle;
		this.quantiteArticle = quantiteArticle;
		this.idFamille = idFamille;
	}

	public int getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}

	public String getLibelleArticle() {
		return libelleArticle;
	}

	public void setLibelleArticle(String libelleArticle) {
		this.libelleArticle = libelleArticle;
	}

	public int getReferenceArticle() {
		return referenceArticle;
	}

	public void setReferenceArticle(int referenceArticle) {
		this.referenceArticle = referenceArticle;
	}

	public float getPrixHtArticle() {
		return prixHtArticle;
	}

	public void setPrixHtArticle(float prixHtArticle) {
		this.prixHtArticle = prixHtArticle;
	}

	public float getTvaArticle() {
		return tvaArticle;
	}

	public void setTvaArticle(float tvaArticle) {
		this.tvaArticle = tvaArticle;
	}

	public int getQuantiteArticle() {
		return quantiteArticle;
	}

	public void setQuantiteArticle(int quantiteArticle) {
		this.quantiteArticle = quantiteArticle;
	}

	public int getIdFamille() {
		return idFamille;
	}

	public void setIdFamille(int idFamille) {
		this.idFamille = idFamille;
	}

}
