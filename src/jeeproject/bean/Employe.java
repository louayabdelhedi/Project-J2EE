package jeeproject.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "employe")
public class Employe implements Serializable,Bean{

	
	
	@Column(name = "nomEmploye")
	private String nomEmploye;
	
	@Column(name = "prenomEmploye")
	private String prenomEmploye;
	
	@Column(name = "adresseEmploye")
	private String adresseEmploye;
	
	@Column(name = "cinEmploye")
	private int cinEmploye;
	
	@Id
	@Column(name = "loginEmploye")
	private String loginEmploye;
	
	@Column(name = "mpEmploye")
	private String mpEmploye;
	
	public Employe(){
		
		
	}

	public Employe(String nomEmploye, String prenomEmploye,
			String adresseEmploye, int cinEmploye, String loginEmploye,
			String mpEmploye) {
		super();
		this.nomEmploye = nomEmploye;
		this.prenomEmploye = prenomEmploye;
		this.adresseEmploye = adresseEmploye;
		this.cinEmploye = cinEmploye;
		this.loginEmploye = loginEmploye;
		this.mpEmploye = mpEmploye;
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
