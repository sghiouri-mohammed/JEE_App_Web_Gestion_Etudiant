package com.tp1.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.tp1.beans.User;
import com.tp1.beans.Utilisateur;

public class UserDbUtil {
	
	//La fonction pour recuperer les users de la table USER de la base de donnees 
	public List<User> recupererUser(){
		
		List<User> users = new ArrayList<User>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch (ClassNotFoundException e) {
		}
		
		//connexion a la base
	
		Connection connexion = null;
		java.sql.Statement statement =null;
		ResultSet resultat = null;
		
		try {
			connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/TP1","root","");
			statement =  connexion.createStatement();
			resultat = ((java.sql.Statement) statement).executeQuery(" select * from user ");
			
			while(resultat.next()) {
				String firstname = resultat.getString("fname");
				String lastname = resultat.getString("lname");
				String loginfield = resultat.getString("login");
				String motdepasse = resultat.getString("password");
				String d = resultat.getString("dob");
				String phone = resultat.getString("mobile");
				
				//creer un user (object)
				User user = new User();
				user.setFname(firstname);
				user.setLname(lastname);
				user.setLogin(loginfield);
				user.setMobile(phone);
				user.setPassword(motdepasse);
				user.setDob(d);
				
				//ajouter a la table users
				users.add(user);
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
		
		return users;
	}
	
	
	public void ajouterUser(User user)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch (ClassNotFoundException e) {
		}
		
		//connexion a la base
		
		Connection connexion = null;
		try {
			connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/TP1","root","");
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		PreparedStatement preparedstatement;
		try {
			preparedstatement = connexion.prepareStatement("insert into user(fname,lname,login,password,dob,mobile) VALUES (?,?,?,?,?,?);");
			preparedstatement.setString(1, user.getFname());
			preparedstatement.setString(2, user.getLname());
			preparedstatement.setString(3, user.getLogin());
			preparedstatement.setString(4, user.getPassword());
			preparedstatement.setString(5, user.getDob());
			preparedstatement.setString(6, user.getMobile());
			preparedstatement.executeUpdate(); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
