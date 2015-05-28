package jeeproject.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import jeeproject.bean.Article;
import jeeproject.bean.Bean;
import jeeproject.bean.Client;
import jeeproject.hibernate.dao.HibernateConnexion;

public class ClientDao extends Dao{

	HibernateConnexion connexion;
	Transaction transaction;
	Session session;

	public ClientDao(HibernateConnexion connexion) {

		this.connexion = connexion;
		session = connexion.getSession();

	}

	@Override
	public boolean create(Bean bean) {

		try {
			transaction = session.beginTransaction();
			session.save(bean);

			transaction.commit();

		} catch (RuntimeException exc) {

			exc.printStackTrace();
			return false;
		}

		return true;
	}

	@Override
	public boolean update(Bean bean) {

		Client client=(Client)bean;
		Query query = session.createQuery(" from Client where cinClient=:cin");
		query.setInteger("cin",client.getCinClient() );
		Iterator clients = query.iterate();

		Client clientToUpdate = (Client) clients.next();
		clientToUpdate = (Client) session.get(Client.class, clientToUpdate.getCinClient());
		System.out.println("Nom Client=>>>>>" + clientToUpdate.getNomClient());

		clientToUpdate.setCinClient(client.getCinClient());
		clientToUpdate.setNomClient(client.getNomClient());
		clientToUpdate.setPrenomClient(client.getPrenomClient());
		clientToUpdate.setAdresseClient(client.getAdresseClient());
		clientToUpdate.setVilleClient(client.getVilleClient());
		clientToUpdate.setTelClient(client.getTelClient());

		try {
			transaction = session.beginTransaction();
			session.update(clientToUpdate);
			transaction.commit();
		} catch (RuntimeException exc) {

			exc.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(Bean bean) {

		Query query = session.createQuery(" from Client where cinClient=:cin");
		query.setInteger("cin", ((Client)bean).getCinClient());
		Iterator clients = query.iterate();
		Client client = (Client) clients.next();
		client = (Client) session.get(Client.class, client.getIdClient());

		try {
			transaction = session.beginTransaction();
			session.delete(client);
			transaction.commit();
		} catch (RuntimeException exc) {

			exc.printStackTrace();
			return false;
		}
		return true;

	}

	@Override
	public List<Bean> listAll() {
		Query req = session.createQuery("from Client");

		List<Bean> clients = (List<Bean>) req.list();

		return clients;

	}

	@Override
	public Bean search(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
