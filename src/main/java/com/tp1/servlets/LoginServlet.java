package com.tp1.servlets;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import javax.sql.DataSource;

import com.tp1.bdd.UserDbUtil;
import com.tp1.beans.User;


public class LoginServlet extends HttpServlet {
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

    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		UserDbUtil tableUsers = new UserDbUtil();
		request.setAttribute("users", tableUsers.recupererUser());
		int d=0;
		String connexion =  request.getParameter("login");
		String pwd = request.getParameter("password");
		
		
		if ( connexion != "" && pwd != "" ) {
			for (User user : tableUsers.recupererUser() ) {
				if ( user.getLogin().equals(connexion)  && user.getPassword().equals(pwd)) {
					HttpSession session = request.getSession();
					session.setAttribute("nom", user.getFname());
					session.setAttribute("prenom", user.getLname());
					d=1;
				}
			}
		}
		if (d == 1 ) {
			response.sendRedirect("/tP1_JEE/Welcome");
		}else {
			d=2;
			this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		}
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
	}

}
