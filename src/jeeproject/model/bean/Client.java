package jeeproject.model.bean;

public class Client {

	private int idClient;
	private String nomClient;
	private String adresseClient;
	private String villeClient;
	private int telClient;
	
	public Client(){
		
	}

	public Client(int idClient, String nomClient, String adresseClient,
			String villeClient, int telClient) {
		super();
		this.idClient = idClient;
		this.nomClient = nomClient;
		this.adresseClient = adresseClient;
		this.villeClient = villeClient;
		this.telClient = telClient;
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
	
	

}
