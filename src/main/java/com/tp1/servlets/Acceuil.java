package com.tp1.servlets;

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.tp1.bdd.Noms;
import com.tp1.beans.Utilisateur;


public class Acceuil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Acceuil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Noms tableNoms = new Noms();
		request.setAttribute("utilisateurs", tableNoms.recupererUtilisateur());
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setNom(request.getParameter("nom"));
		utilisateur.setPrenom(request.getParameter("prenom"));
	
		Noms tableNoms = new Noms();
		tableNoms.ajouterUtilisateur(utilisateur);
		request.setAttribute("utilisateurs", tableNoms.recupererUtilisateur());
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/acceuil.jsp").forward(request, response);	}

}
