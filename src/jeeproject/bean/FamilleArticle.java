package jeeproject.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "familleArticle")
public class FamilleArticle implements Serializable, Bean {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idFamille")
	private int idFamille;

	@Column(name = "nomFamille")
	private String nomFamille;

	@OneToMany(mappedBy = "familleArticle")
	private List<Article> articles;

	public FamilleArticle() {

	}

	public FamilleArticle(int idFamille, String nomFamille) {
		super();
		this.idFamille = idFamille;
		this.nomFamille = nomFamille;
	}

	public int getIdFamille() {
		return idFamille;
	}

	public void setIdFamille(int idFamille) {
		this.idFamille = idFamille;
	}

	public String getNomFamille() {
		return nomFamille;
	}

	public void setNomFamille(String nomFamille) {
		this.nomFamille = nomFamille;
	}

}
