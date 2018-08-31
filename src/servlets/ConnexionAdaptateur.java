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
	
	private Connection bdd;
	
	public ConnexionAdaptateur() {
		this.getBddConnector();
	}
	
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
		if (ID != -1) pstmt.setInt(1, ID);
		
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			result.add(new Topic(rs.getInt("topic_id"), rs.getString("user_name"), rs.getString("topic_subject"), rs.getDate("topic_date"), new Categorie(rs.getInt("topic_cat"), "")));
		}
		
		return result;
	}
	
	public List<Post> getPostBdd(int ID) throws SQLException {
		List<Post> result = new ArrayList();
		String req = "SELECT * FROM posts JOIN users ON post_by = user_id ";
		
		if (ID != -1) req += "WHERE post_id = " + ID;
		
		PreparedStatement pstmt = this.bdd.prepareStatement(req);
		if (ID != -1) pstmt.setInt(1, ID);
		
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			result.add(new Post(rs.getInt("post_id"), rs.getString("user_name"), rs.getString("post_content"), rs.getDate("post_date"), new Topic(rs.getInt("post_topic"), "", "")));
		}
		
		return result;
	}
	
	public List<Categorie> getCategorieBdd(int ID) throws SQLException {
		List<Categorie> result = new ArrayList();
		String req = "SELECT * FROM categories ";
		
		if (ID != -1) req += "WHERE cat_id = ?";
		
		PreparedStatement pstmt = this.bdd.prepareStatement(req);
		if (ID != -1) pstmt.setInt(1, ID);
		
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			result.add(new Categorie(rs.getInt("cat_id"), rs.getString("cat_name")));
		}
		
		return result;
	}
	
	public List<Topic> getTopicsWithCategorie(int ID) throws SQLException {
		List<Topic> result = new ArrayList();
		String req = "SELECT * FROM topics WHERE topic_cat = ?";
		
		PreparedStatement pstmt = this.bdd.prepareStatement(req);
		pstmt.setInt(1, ID);
		
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			result.add(new Topic(rs.getInt("topic_id"), rs.getString("user_name"), rs.getString("topic_subject"), rs.getDate("topic_date"), new Categorie(rs.getInt("topic_cat"), "")));
		}
		
		return result;
	}
	
	public List<Post> getPostsWithTopic(int ID) throws SQLException {
		List<Post> result = new ArrayList();
		String req = "SELECT * FROM posts WHERE post_topic = ?";
		
		PreparedStatement pstmt = this.bdd.prepareStatement(req);
		pstmt.setInt(1, ID);
		
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			result.add(new Post(rs.getInt("post_id"), rs.getString("user_name"), rs.getString("post_content"), rs.getDate("post_date"), new Topic(rs.getInt("post_topic"), "", "")));
		}
		
		return result;
	}
	
	public boolean insertTopic(Topic t) throws SQLException {
		String req = "INSERT INTO topics () VALUES ()";
		return true;
	}
	
	public boolean insertPost(Post p) throws SQLException {
		String req = "INSERT INTO  () VALUES ()";
		return true;
	}
	
	public boolean insertCategorie(Categorie c) throws SQLException {
		String req = "INSERT INTO  () VALUES ()";
		return true;
	}
	
	public boolean editTopic(Topic t) throws SQLException {
		String req = "UPDATE topics SET blabla = balba WHERE topic_id = ";
		return true;
	}
	
	public boolean editPost(Post p) throws SQLException {
		String req = "UPDATE posts SET blabla = balba WHERE topic_id = ";
		return true;
	}
	
	public boolean editCategorie(Categorie c) throws SQLException {
		String req = "UPDATE categories SET blabla = balba WHERE topic_id = ;";
		return true;
	}
}
