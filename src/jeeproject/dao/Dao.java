package jeeproject.dao;

import java.util.List;

import jeeproject.bean.Bean;

public interface Dao {
	
	public boolean create(Bean bean);
	public boolean update(Bean bean);
	public boolean delete(Bean bean);
	public List<Bean> listAll(Bean bean);
	public Bean read(int id);
	

}
