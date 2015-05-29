package jeeproject.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jeeproject.bean.Employe;
import jeeproject.hibernate.dao.HibernateConnexion;
import jeeproject.hibernate.dao.HibernateSessionManager;

/**
 * Servlet implementation class EmployeServlet
 */
@WebServlet("/Employe")
public class EmployeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public EmployeServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/employees.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String modifier= request.getParameter("modifier_emp");
		String supprimer= request.getParameter("supprimer_emp");
		
		if(request.getParameter("logout")!=null){
			HibernateConnexion hc = (HibernateConnexion) request.getSession().getAttribute("hc");
			hc.closeHibernateConnexion();
			System.out.println("logouuuuuuuuuuuuuuuuuuutt");
			HttpSession session = request.getSession(true); 
			session.invalidate();
			response.sendRedirect("login");
		}
		if(modifier !=null){
			request.getSession().setAttribute("id_emp",modifier);
			response.sendRedirect("modif_emp");
		}
		if(supprimer !=null){
			//EmployeDao ed = new EmployeDao();
			//ed.delete(new Employe(supprimer, ""));
		}
		
		
	}

}
