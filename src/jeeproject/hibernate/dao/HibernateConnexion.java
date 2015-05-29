package jeeproject.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class HibernateConnexion {

	private Session session;

	private Transaction transaction;

	public HibernateConnexion() {
	}

	public void openHibernateConnexion() {

		session = HibernateSessionManager.getSessionFactory().openSession();
		//transaction=session.beginTransaction();
		

	}

	public void closeHibernateConnexion() {
		//session.close();
		HibernateSessionManager.shutdown();
		

	}

	public Session getSession() {
		return session;
	}

	
	

}
