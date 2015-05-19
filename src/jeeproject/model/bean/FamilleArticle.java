package jeeproject.model.bean;

public class FamilleArticle {
	
	private int idFamille;
	private String nomFamille;
	
	public FamilleArticle(){
		
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
