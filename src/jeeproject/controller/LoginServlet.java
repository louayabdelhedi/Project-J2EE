package jeeproject.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import jeeproject.bean.Employe;
import jeeproject.dao.EmployeDao;
import jeeproject.hibernate.dao.HibernateConnexion;
import jeeproject.service.EmployeServices;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public static HibernateConnexion hc =null;  
    public static Session session = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login= request.getParameter("username");
		String mdp= request.getParameter("passwd");
		
		if(request.getParameter("login")!=null){
			if(login != null && mdp != null){
				hc = new HibernateConnexion();
				hc.openHibernateConnexion();
				session = hc.getSession();
				System.out.println("session1==>"+session);
				EmployeServices es = new EmployeServices(hc,session);
				System.out.println("session2==>"+session);
			    boolean type=es.authentification(login, mdp);
			    System.out.println("session3==>"+session);
				if(type == true){
					
					
					System.out.println("Authentification succeess");
					request.getSession().setAttribute("employe", new Employe(login,mdp));
					System.out.println("hc==>"+hc);
					System.out.println("session4==>"+session);
					request.getSession().setAttribute("hc", hc);
					request.getSession().setAttribute("session", session);
					response.sendRedirect("Employe");
					//cb.fermeture_connexion();
					//request.getSession().setMaxInactiveInterval(60 * 15);
				}else{
					request.setAttribute("employe", "Authentification echoué");
					request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
					System.out.println("authentification echoué");
					//response.sendRedirect("login");
				}
			}
		}

	}

}
