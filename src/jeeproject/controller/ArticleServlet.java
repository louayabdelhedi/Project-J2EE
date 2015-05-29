package jeeproject.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jeeproject.hibernate.dao.HibernateConnexion;

/**
 * Servlet implementation class ArticleServlet
 */
@WebServlet("/Article")
public class ArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ArticleServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/articles.jsp").forward(request,
				response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String modifier= request.getParameter("modifier_art");
		String supprimer= request.getParameter("supprimer_art");
		
		if(request.getParameter("logout")!=null){
			HibernateConnexion hc = (HibernateConnexion) request.getSession().getAttribute("hc");
			hc.closeHibernateConnexion();
			System.out.println("logouuuuuuuuuuuuuuuuuuutt");
			HttpSession session = request.getSession(true); 
			session.invalidate();
			response.sendRedirect("login");
		}
		if(modifier !=null){
			request.getSession().setAttribute("id_art",modifier);
			response.sendRedirect("modif_emp");
		}
		if(supprimer !=null){
			//EmployeDao ed = new EmployeDao();
			//ed.delete(new Employe(supprimer, ""));
		}
	}

}
