package com.tp1.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

//import java.io.PrintWriter;

import com.tp1.bdd.Noms;
import com.tp1.beans.Utilisateur;

public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Test() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Noms tableNoms = new Noms();
		request.setAttribute("utilisateurs", tableNoms.recupererUtilisateur());
		request.setAttribute("table", tableNoms);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/bonjour.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setNom(request.getParameter("nom"));
		utilisateur.setPrenom(request.getParameter("prenom"));
		
		Noms tableNoms = new Noms();
		tableNoms.ajouterUtilisateur(utilisateur);
		
		request.setAttribute("utilisateurs", tableNoms.recupererUtilisateur());
		this.getServletContext().getRequestDispatcher("/WEB-INF/bonjour.jsp").forward(request, response);
				
	}

}
