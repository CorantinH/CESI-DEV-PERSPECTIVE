package servlets;

import java.io.IOException;
import java.rmi.ConnectException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mysql.ConnexionBDD;

public class TestConnection extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Connection conn = ConnexionBDD.getInstance();
		} catch (ConnectException ex) {
			System.err.println("CA MARCHE PAS");
		}
	}
}
