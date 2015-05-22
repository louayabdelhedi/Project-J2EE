package jeeproject.hibernate.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionManager {

	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() 
	{
		try 
		{
			// Create the SessionFactory from hibernate.cfg.xml
			return new Configuration().configure().buildSessionFactory();
		} 
		catch (Throwable ex) 
		{
			// Make sure you log the exception, as it might be swallowed
			System.err.println("SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	
	public static SessionFactory getSessionFactory() 
	{
		return sessionFactory;
	}

	
	public static void shutdown() 
	{
		// Close caches and connection pools
		getSessionFactory().close();
	}

}

/*
 * package com.javahash.hibernate;
 * 
 * import org.hibernate.SessionFactory; import org.hibernate.cfg.Configuration;
 * import org.hibernate.cfg.AnnotationConfiguration;
 * 
 * public class HibernateSessionManager {
 * 
 * private static final SessionFactory sessionFactory = buildSessionFactory();
 * 
 * private static SessionFactory buildSessionFactory() { try { return new
 * AnnotationConfiguration().
 * configure().addAnnotatedClass(User.class).buildSessionFactory(); } catch
 * (Throwable ex) { System.err.println("SessionFactory creation failed." + ex);
 * throw new ExceptionInInitializerError(ex); } }
 * 
 * public static SessionFactory getSessionFactory() { return sessionFactory; }
 * 
 * public static void shutdown() { // Close caches and connection pools
 * getSessionFactory().close(); }
 * 
 * }
 */