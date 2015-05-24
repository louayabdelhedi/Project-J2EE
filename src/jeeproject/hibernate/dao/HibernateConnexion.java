package jeeproject.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class HibernateConnexion {

	private Session session;

	// private Transaction transaction;

	public HibernateConnexion() {
	}

	public Session openHibernateConnexion() {

		session = HibernateSessionManager.getSessionFactory().openSession();
		session.beginTransaction();
		return session;

	}

	public Session closeHibernateConnexion() {

		session.getTransaction().commit();
		HibernateSessionManager.shutdown();
		return session;

	}

}
