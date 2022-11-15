package com.tp1.servlets;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import javax.sql.DataSource;

import com.tp1.bdd.UserDbUtil;
import com.tp1.beans.User;

/**
 * Servlet implementation class Modifyservlet
 */
public class Modifyservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserDbUtil tableUsers;
    
	@Resource(name="jdbc/TP1")
	private DataSource dataSource;
	
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		// create our student db util ... and pass in the conn pool / datasource
		try {
			tableUsers = new UserDbUtil(dataSource);
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	}
    public Modifyservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
//		UserDbUtil tableUsers = new UserDbUtil();
		for ( User user : tableUsers.recupererUser() ) {
			if ( user.getId() == id ) {
				request.setAttribute("user", user);
			}
		}
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/modifier-user.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
