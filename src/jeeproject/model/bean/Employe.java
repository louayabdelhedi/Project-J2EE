package jeeproject.model.bean;

public class Employe {

	private int idEmploye;
	private String nomEmploye;
	private String prenomEmploye;
	private String adresseEmploye;
	private int cinEmploye;
	private String loginEmploye;
	private String mpEmploye;
	
	public Employe(){
		
		
	}

	public Employe(int idEmploye, String nomEmploye, String prenomEmploye,
			String adresseEmploye, int cinEmploye, String loginEmploye,
			String mpEmploye) {
		super();
		this.idEmploye = idEmploye;
		this.nomEmploye = nomEmploye;
		this.prenomEmploye = prenomEmploye;
		this.adresseEmploye = adresseEmploye;
		this.cinEmploye = cinEmploye;
		this.loginEmploye = loginEmploye;
		this.mpEmploye = mpEmploye;
	}

	public int getIdEmploye() {
		return idEmploye;
	}

	public void setIdEmploye(int idEmploye) {
		this.idEmploye = idEmploye;
	}

	public String getNomEmploye() {
		return nomEmploye;
	}

	public void setNomEmploye(String nomEmploye) {
		this.nomEmploye = nomEmploye;
	}

	public String getPrenomEmploye() {
		return prenomEmploye;
	}

	public void setPrenomEmploye(String prenomEmploye) {
		this.prenomEmploye = prenomEmploye;
	}

	public String getAdresseEmploye() {
		return adresseEmploye;
	}

	public void setAdresseEmploye(String adresseEmploye) {
		this.adresseEmploye = adresseEmploye;
	}

	public int getCinEmploye() {
		return cinEmploye;
	}

	public void setCinEmploye(int cinEmploye) {
		this.cinEmploye = cinEmploye;
	}

	public String getLoginEmploye() {
		return loginEmploye;
	}

	public void setLoginEmploye(String loginEmploye) {
		this.loginEmploye = loginEmploye;
	}

	public String getMpEmploye() {
		return mpEmploye;
	}

	public void setMpEmploye(String mpEmploye) {
		this.mpEmploye = mpEmploye;
	}
	
	

}
