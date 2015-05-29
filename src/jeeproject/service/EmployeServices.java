package jeeproject.service;

import org.hibernate.Session;

import jeeproject.bean.Bean;
import jeeproject.bean.Employe;
import jeeproject.dao.Dao;
import jeeproject.dao.EmployeDao;
import jeeproject.hibernate.dao.HibernateConnexion;
import jeeproject.hibernate.dao.HibernateSessionManager;

public class EmployeServices {
	
	private Session session;
	private HibernateConnexion hc;

	public EmployeServices(HibernateConnexion hc,Session session){

		this.hc = hc;
		this.session = session;
	}
	
	public boolean authentification(String login,String mdp){
		boolean b =false;
		Bean bean = new Employe("", "", "", 0, login, mdp);
		Dao dao = new EmployeDao(session);
		
		if(((EmployeDao)dao).search(((Employe)bean).getLoginEmploye(),((Employe)bean).getMpEmploye())==null)
			b = false;
		else
			b = true;
		
		return b;
	}

}
