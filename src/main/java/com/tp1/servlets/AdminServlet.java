 package com.tp1.servlets;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import javax.sql.DataSource;

import com.tp1.bdd.UserDbUtil;



public class AdminServlet extends HttpServlet {
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
	
    public AdminServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		UserDbUtil tableUsers = new UserDbUtil();
		request.setAttribute("users", tableUsers.recupererUser());
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/admin-page.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.getServletContext().getRequestDispatcher("/WEB-INF/admin-page.jsp").forward(request, response);
	}

}
