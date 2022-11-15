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

public class Modification extends HttpServlet {
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
   
    public Modification() {
        super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
//		UserDbUtil tableUsers = new UserDbUtil();
		for ( User user : tableUsers.recupererUser()) {
			if ( user.getId() == id ) {
				tableUsers.modifierUser(user,request.getParameter("fname"),request.getParameter("lname"),request.getParameter("mobile"),id);
			}
		}
		response.sendRedirect("/tP1_JEE/AdminServlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
