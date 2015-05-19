package jeeproject.model.bean;

import java.awt.geom.Arc2D;

public class Article {

	private int idArticle;
	private String libelleArticle;
	private int referenceArticle;
	private float prixHtArticle;
	private float tvaArticle;
	private int quantiteArticle;

	public Article() {

	}

	public Article(int idArticle, String libelleArticle, int referenceArticle,
			float prixHtArticle, float tvaArticle, int quantiteArticle) {
		super();
		this.idArticle = idArticle;
		this.libelleArticle = libelleArticle;
		this.referenceArticle = referenceArticle;
		this.prixHtArticle = prixHtArticle;
		this.tvaArticle = tvaArticle;
		this.quantiteArticle = quantiteArticle;
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

}
