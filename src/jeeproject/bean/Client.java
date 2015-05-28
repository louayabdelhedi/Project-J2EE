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
@Table(name = "client")
public class Client implements Serializable,Bean{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idClient")
	private int idClient;
	
	@Column(name = "nomClient")
	private String nomClient;
	
	@Column(name = "adresseClient")
	private String adresseClient;
	
	@Column(name = "villeClient")
	private String villeClient;
	
	@Column(name = "telClient")
	private int telClient;
	
	@Column(name = "prenomClient")
	private String prenomClient;
	
	@Column(name = "cinClient")
	private int cinClient;
	
	
	@OneToMany(mappedBy = "client")
	private List<Commande> commandes;
	public Client(){
		
	}

	public Client(int idClient, String nomClient, String adresseClient,
			String villeClient, int telClient,String prenomClient,int cinClient) {
		super();
		this.idClient = idClient;
		this.nomClient = nomClient;
		this.adresseClient = adresseClient;
		this.villeClient = villeClient;
		this.telClient = telClient;
		this.prenomClient=prenomClient;
		this.cinClient=cinClient;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public String getAdresseClient() {
		return adresseClient;
	}

	public void setAdresseClient(String adresseClient) {
		this.adresseClient = adresseClient;
	}

	public String getVilleClient() {
		return villeClient;
	}

	public void setVilleClient(String villeClient) {
		this.villeClient = villeClient;
	}

	public int getTelClient() {
		return telClient;
	}

	public void setTelClient(int telClient) {
		this.telClient = telClient;
	}

	public String getPrenomClient() {
		return prenomClient;
	}

	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}

	public int getCinClient() {
		return cinClient;
	}

	public void setCinClient(int cinClient) {
		this.cinClient = cinClient;
	}

	public List<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}
	
	

}
