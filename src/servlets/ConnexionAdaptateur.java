package servlets;

import java.rmi.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import beans.*;
import mysql.ConnexionBDD;

public class ConnexionAdaptateur {
	
	private static final String[][] BDDDescription = new String [10][10];
	private Connection bdd;
	
	public void getBddConnector() {
		try {
			this.bdd = ConnexionBDD.getInstance();
		} catch (ConnectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Topic> getTopicBdd(int ID) throws SQLException {
		List<Topic> result = new ArrayList();
		String req = "SELECt * FROM topics JOIN users ON topic_by = user_id ";
		
		if (ID != -1) req += "WHERE topic_id = ?";
		
		PreparedStatement pstmt = this.bdd.prepareStatement(req);
		if (ID != -1) pstmt.setInt(0, ID);
		
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			result.add(new Topic(rs.getInt("topic_id"), rs.getString("user_name"), rs.getString("topic_subject"), new Date(), new Categorie(rs.getInt("topic_cat"), "")));
		}
		
		return result;
	}
	
	public List<Post> getPostBdd(int ID) throws SQLException {
		List<Post> result = new ArrayList();
		String req = "SELECT * FROM posts ";
		
		if (ID != -1) req += "WHERE post_id = " + ID;
		
		PreparedStatement pstmt = this.bdd.prepareStatement(req);
		if (ID != -1) pstmt.setInt(0, ID);
		
		return result;
	}
	
	public List<Categorie> getCategorieBdd(int ID) throws SQLException {
		List<Categorie> result = new ArrayList();
		String req = "SELECT * FROM categories ";
		
		if (ID != -1) req += "WHERE cat_id = ?";
		
		PreparedStatement pstmt = this.bdd.prepareStatement(req);
		if (ID != -1) pstmt.setInt(0, ID);
		
		return result;
	}
	
	public List<Topic> getTopicsWithCategorie(int ID) throws SQLException {
		List<Topic> result = new ArrayList();
		String req = "SELECT * FROM topics WHERE topic_cat = ?";
		
		PreparedStatement pstmt = this.bdd.prepareStatement(req);
		pstmt.setInt(0, ID);
		return result;
	}
	
	public List<Post> getPostsWithTopic(int ID) throws SQLException {
		List<Post> result = new ArrayList();
		String req = "SELECT * FROM posts WHERE post_topic = ?";
		
		PreparedStatement pstmt = this.bdd.prepareStatement(req);
		pstmt.setInt(0, ID);
		
		ResultSet rs = pstmt.executeQuery();
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
