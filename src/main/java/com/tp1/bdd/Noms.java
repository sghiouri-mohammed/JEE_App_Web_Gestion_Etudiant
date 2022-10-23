package com.tp1.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import com.mysql.cj.xdevapi.Statement;
import com.tp1.beans.Utilisateur;

public class Noms {
//	
	public List<Utilisateur> recupererUtilisateur(){
		
		List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
		// chargement du driver
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch (ClassNotFoundException e) {
		}
		
		//connexion a la base
	
		Connection connexion = null;
		java.sql.Statement statement =null;
		ResultSet resultat = null;
		
		try {
			connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaece","root","");
			statement =  connexion.createStatement();
			resultat = ((java.sql.Statement) statement).executeQuery("select * from noms;");
			
			while(resultat.next()) {
				String nom = resultat.getString("nom");
				String prenom = resultat.getString("prenom");
				Utilisateur utilisateur = new Utilisateur();
				utilisateur.setNom(nom);
				utilisateur.setPrenom(prenom);
				utilisateurs.add(utilisateur);	
			}
		 }catch(SQLException e) {
		 }finally {
			try {
				if (resultat != null)
					resultat.close();
				
				if (statement != null)
					statement.close();
				
				if (connexion != null)
					connexion. close();
				}catch (SQLException ignore) {}
			}
		return utilisateurs;
	}
	
	
	public void ajouterUtilisateur(Utilisateur utilisateur)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch (ClassNotFoundException e) {
		}
		
		//connexion a la base
		
		Connection connexion = null;
		try {
			connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaece","root","");
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		PreparedStatement preparedstatement;
		try {
			preparedstatement = connexion.prepareStatement("insert into noms(nom,prenom) VALUES (?,?);");
			preparedstatement.setString(1, utilisateur.getNom());
			preparedstatement.setString(2, utilisateur.getPrenom());
			preparedstatement.executeUpdate(); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}