package mysql;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class ConnexionBDD {
	public static void main(String[] args) throws SQLException, FileNotFoundException, IOException {

	    // TODO
	    // chargement du driver JDBC
	    // et ouverture d'une connexion
		Connection conn = null;
		Statement st = null;
	    Properties prop = new Properties();
	    InputStream input = null;
	    
	    input = new FileInputStream("config.properties");
	    prop.load(input);
	    
	    
	      String url = prop.getProperty("url");
	      String user = prop.getProperty("user");
	      String passwd = prop.getProperty("passwd");
	        
	          try {
	            Class.forName(prop.getProperty("driver"));
	        } catch (ClassNotFoundException e) {
	            System.out.println("Impossible de charger le Driver mySQL");
	            e.printStackTrace();
	            System.exit(10);
	        }


	        try {
	            conn = DriverManager.getConnection(url, user,passwd);
	            st = conn.createStatement();
	        } catch (SQLException e) {
	            System.out.println("Impossible de se connecter la BDD");
	            e.printStackTrace();
	            System.exit(10);
	        }
	       
	    System.out.println("Connexion réussie !");

	}}
