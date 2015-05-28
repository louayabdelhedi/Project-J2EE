package jeeproject.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import jeeproject.bean.Article;
import jeeproject.bean.Bean;

public abstract class Dao {
	
	Transaction trns=null;
	Session session=null;
	public boolean create(Bean bean) {
		return false;
	}
	public boolean update(Bean bean) {
		return false;
	}
	public boolean delete(Bean bean) {
		return false;
	}
	public List<Bean> listAll() {
		return null;
	}
	public Bean search(int id) {
		return null;
	}
	
	

	
	
}
