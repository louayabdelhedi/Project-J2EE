package jeeproject.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jeeproject.bean.Employe;
import jeeproject.dao.EmployeDao;
import jeeproject.hibernate.dao.HibernateConnexion;
import jeeproject.service.EmployeServices;

import org.hibernate.Session;

/**
 * Servlet implementation class SignInServlet
 */
@WebServlet("/signin")
public class SignInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static HibernateConnexion hc =null;  
    public static Session session = null;   
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignInServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/signin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomEmploye= request.getParameter("nomEmploye");
		String prenomEmploye= request.getParameter("prenomEmploye");
		String adresseEmploye= request.getParameter("adresseEmploye");
		String cinEmploye= request.getParameter("cinEmploye");
		String loginEmploye= request.getParameter("loginEmploye");
		String mpEmploye= request.getParameter("mpEmploye");
		
		if(request.getParameter("signin")!=null){
			if(nomEmploye != null && prenomEmploye != null && adresseEmploye != null && cinEmploye != null && loginEmploye != null && mpEmploye != null){
				System.out.println("hihihihihi");
				hc = new HibernateConnexion();
				hc.openHibernateConnexion();
				session = hc.getSession();
				System.out.println("session1==>"+session);
				EmployeDao es = new EmployeDao(session);
				boolean b = es.create(new Employe(nomEmploye, prenomEmploye, adresseEmploye, Integer.valueOf(cinEmploye), loginEmploye, mpEmploye));
				if(b==true)
					System.out.println("Ajout avec success employe");
				else
					System.out.println("Ajout echoué employe");
			}
		}
		
	}

}
