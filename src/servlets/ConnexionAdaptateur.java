package servlets;

import java.rmi.ConnectException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.*;
import mysql.ConnexionBDD;

public class ConnexionAdaptateur {
	
	private static final String[][] BDDDescription = new String [10][10];
	private ConnexionBDD bdd;
	
	public void getBddConnector() {
		try {
			this.bdd.getInstance();
		} catch (ConnectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Topic> getTopicBdd(int ID) throws SQLException {
		List<Topic> result = new ArrayList();
		
		if (ID < 0) {
			String req = "select * from topics";
		} else {
			String req = "select * from topics where topic_id = " + ID;
		}
		
		return result;
	}
	
	public List<Post> getPostBdd(int ID) throws SQLException {
		List<Post> result = new ArrayList();
		
		if (ID < 0) {
			String req = "select * from posts";
		} else {
			String req = "select * from posts where post_id = " + ID;
		}
		
		return result;
	}
	
	public List<Categorie> getCategorieBdd(int ID) throws SQLException {
		List<Categorie> result = new ArrayList();
		
		if (ID < 0) {
			String req = "select * from categorie";
		} else {
			String req = "select * from categorie where cat_id = " + ID;
		}
		
		return result;
	}
	
	public boolean insertTopic(Topic t) throws SQLException {
		return true;
	}
	
	public boolean insertPost(Post p) throws SQLException {
		return true;
	}
	
	public boolean insertCategorie(Categorie c) throws SQLException {
		return true;
	}
	
	public boolean editTopic(Topic t) throws SQLException {
		return true;
	}
	
	public boolean editPost(Post p) throws SQLException {
		return true;
	}
	
	public boolean editCategorie(Categorie c) throws SQLException {
		return true;
	}
}
