package jeeproject.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import jeeproject.bean.Article;
import jeeproject.bean.Bean;
import jeeproject.hibernate.dao.HibernateConnexion;

public abstract class Dao {
	
	
	Transaction transaction;
	Session session;
	
	public  boolean create(Bean bean){
		try {
			transaction = session.beginTransaction();
			session.save(bean);

			transaction.commit();

		} catch (RuntimeException exc) {
			if (transaction != null)
				transaction.rollback();
			exc.printStackTrace();
			return false;
		} finally {
			session.flush();
		}
		return true;
	}
	public abstract boolean update(Bean bean);
	public abstract boolean delete(Bean bean);
	public  abstract List<Bean> listAll();
	public abstract Bean search(int id);
	
	

	
	
}
