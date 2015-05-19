package jeeproject.model.bean;

public class LigneCommande {
	
	private int numLigne;
	private int quantiteCommande;
	
	public LigneCommande(){
		
	}

	public LigneCommande(int numLigne, int quantiteCommande) {
		super();
		this.numLigne = numLigne;
		this.quantiteCommande = quantiteCommande;
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

	
	
}
