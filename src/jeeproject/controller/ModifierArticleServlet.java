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

/**
 * Servlet implementation class ModifierArticleServlet
 */
@WebServlet("/modif_art")
public class ModifierArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierArticleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/modif_article.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String libelleArticle= request.getParameter("libelleArticle");
		String referenceArticle= request.getParameter("referenceArticle");
		String prixHtArticle= request.getParameter("prixHtArticle");
		String tvaArticle= request.getParameter("tvaArticle");
		String quantiteArticle= request.getParameter("quantiteArticle");
		
		/*if(request.getParameter("signin")!=null){
			if(nomEmploye != null && prenomEmploye != null && adresseEmploye != null && cinEmploye != null && loginEmploye != null && mpEmploye != null){
				System.out.println("hihihihihi");
				hc = new HibernateConnexion();
				hc.openHibernateConnexion();
				session = hc.getSession();
				System.out.println("session1==>"+session);
				EmployeDao es = new EmployeDao(session);
				boolean b = es.update(new Employe(nomEmploye, prenomEmploye, adresseEmploye, Integer.valueOf(cinEmploye), loginEmploye, mpEmploye));
				if(b==true)
					System.out.println("Modification avec success employe");
				else
					System.out.println("Modification echoué employe");
			}*/
		}
	}


