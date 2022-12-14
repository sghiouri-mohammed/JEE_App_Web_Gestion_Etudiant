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


public class RegistrationServlet extends HttpServlet {
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
    
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		UserDbUtil tableUsers = new UserDbUtil();
		request.setAttribute("users", tableUsers.recupererUser());

		
		this.getServletContext().getRequestDispatcher("/WEB-INF/registration.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User user = new User();
		user.setFname(request.getParameter("fname"));
		user.setLname(request.getParameter("lname"));
		user.setLogin(request.getParameter("login"));
		user.setPassword(request.getParameter("password"));
		user.setDob(request.getParameter("dob"));
		user.setMobile(request.getParameter("mobile"));

//		UserDbUtil tableUsers = new UserDbUtil();
		tableUsers.ajouterUser(user);
		request.setAttribute("valider", true);
						
		this.getServletContext().getRequestDispatcher("/WEB-INF/registration.jsp").forward(request, response);
	}

}
