package mysql;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.rmi.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ConnexionBDD {
	private static Connection singleton = null;
	
	public static Connection getInstance() throws ConnectException {
		if (singleton == null) {
			singleton = createConnection();
		}
		return singleton;
	}
	
	private static Connection createConnection() throws ConnectException {
		Connection conn = null;
		
		// récupération des informations dans le .properties
		String url = null, user = null, passwd = null, driver = null;
		try {
			Properties config = new Properties();
			config.load(ConnexionBDD.class.getResourceAsStream("config.properties"));
			
			url = config.getProperty("url");
			user = config.getProperty("user");
			passwd = config.getProperty("passwd");
			driver = config.getProperty("driver");
		} catch (IOException ex) {
			System.err.println("Erreur lors de la récupération des informations dans le fichier .properties : "+ ex.getMessage());
		}
		
		// test du driver
		try {
			Class.forName(driver).newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
			System.err.println("Impossible de charger le driver SQL : "+ ex.getMessage());
		}
		
		try {
			conn = DriverManager.getConnection(url, user, passwd);
			Statement st = conn.createStatement();
		} catch (SQLException ex) {
			System.err.println("Erreur lors de la connexion avec la BDD : "+ ex.getMessage());
		}
		
		if (conn == null) {
			throw new ConnectException("Impossible de se connecter avec la BDD");
		}
		return conn;
	}
}
