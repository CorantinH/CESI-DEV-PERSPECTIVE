package servlets;

import java.rmi.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import java.time.LocalDate;
import java.time.ZoneId;
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
	
	public List<Topic> getTopicBdd(int ID) throws SQLException, SQLTimeoutException {
		List<Topic> result = new ArrayList<Topic>();
		String req = "SELECt * FROM topics ";
		
		if (ID != -1) req += "WHERE topic_id = ?";
		
		PreparedStatement pstmt = this.bdd.prepareStatement(req);
		if (ID != -1) pstmt.setInt(1, ID);
		
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			result.add(new Topic(rs.getInt("topic_id"), rs.getString("topic_by"), rs.getString("topic_subject"), (Date) rs.getDate("topic_date"), new Categorie(rs.getInt("topic_cat"), "")));
		}
		
		return result;
	}
	
	public List<Post> getPostBdd(int ID) throws SQLException, SQLTimeoutException {
		List<Post> result = new ArrayList<Post>();
		String req = "SELECT * FROM posts ";
		
		if (ID != -1) req += "WHERE post_id = " + ID;
		
		PreparedStatement pstmt = this.bdd.prepareStatement(req);
		if (ID != -1) pstmt.setInt(1, ID);
		
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			result.add(new Post(rs.getInt("post_id"), rs.getString("post_by"), rs.getString("post_content"), (Date) rs.getDate("post_date"), new Topic(rs.getInt("post_topic"), "", "")));
		}
		
		return result;
	}
	
	public List<Categorie> getCategorieBdd(int ID) throws SQLException, SQLTimeoutException {
		List<Categorie> result = new ArrayList<Categorie>();
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
	
	public List<Topic> getTopicsWithCategorie(int ID) throws SQLException, SQLTimeoutException {
		List<Topic> result = new ArrayList<Topic>();
		String req = "SELECT * FROM topics WHERE topic_cat = ?";
		
		PreparedStatement pstmt = this.bdd.prepareStatement(req);
		pstmt.setInt(1, ID);
		
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			result.add(new Topic(rs.getInt("topic_id"), rs.getString("topic_by"), rs.getString("topic_subject"), (Date) rs.getDate("topic_date"), new Categorie(rs.getInt("topic_cat"), "")));
		}
		
		return result;
	}
	
	public List<Post> getPostsWithTopic(int ID) throws SQLException, SQLTimeoutException {
		List<Post> result = new ArrayList<Post>();
		String req = "SELECT * FROM posts WHERE post_topic = ?";
		
		PreparedStatement pstmt = this.bdd.prepareStatement(req);
		pstmt.setInt(1, ID);
		
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			result.add(new Post(rs.getInt("post_id"), rs.getString("post_by"), rs.getString("post_content"), (Date) rs.getDate("post_date"), new Topic(rs.getInt("post_topic"), "", "")));
		}
		
		return result;
	}
	
	public boolean insertTopic(Topic t) throws SQLException, SQLTimeoutException {
		String req = "INSERT INTO topics (topic_subject, topic_date, topic_cat, topic_by, topic_status) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement pstmt = this.bdd.prepareStatement(req);
		pstmt.setString(1, t.getSujet());
		pstmt.setDate(2, java.sql.Date.valueOf(LocalDate.now(ZoneId.of("Europe/Paris"))));
		pstmt.setInt(3, t.getCategorie().getId());
		pstmt.setString(4, t.getAuteur());
		pstmt.setString(5, "En cours");
		
		pstmt.executeUpdate();
		
		return true;
	}
	
	public boolean insertPost(Post p) throws SQLException, SQLTimeoutException {
		String req = "INSERT INTO posts (post_content, post_date, post_topic, post_by) VALUES (?, ?, ?, ?)";
		PreparedStatement pstmt = this.bdd.prepareStatement(req);
		pstmt.setString(1, p.getContenu());
		pstmt.setDate(2, java.sql.Date.valueOf(LocalDate.now(ZoneId.of("Europe/Paris"))));
		pstmt.setInt(3, p.getTopic().getId());
		pstmt.setString(4, p.getAuteur());
		
		pstmt.executeUpdate();
		
		return true;
	}
	
	public boolean insertCategorie(Categorie c) throws SQLException, SQLTimeoutException {
		String req = "INSERT INTO categories (cat_name) VALUES (?)";
		PreparedStatement pstmt = this.bdd.prepareStatement(req);
		pstmt.setString(1, c.getLibelle());
		
		pstmt.executeUpdate();
		
		return true;
	}
	
	public boolean editTopicSolved(Topic t) throws SQLException, SQLTimeoutException {
		String req = "UPDATE topics SET topic_status = ? WHERE topic_id = ?";
		PreparedStatement pstmt = this.bdd.prepareStatement(req);
		pstmt.setString(1, "Resolu");
		pstmt.setInt(2, t.getId());
		
		pstmt.executeUpdate();
		
		return true;
	}
}
