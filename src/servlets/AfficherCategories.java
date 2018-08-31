package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Categorie;

/**
 * Affiche la page des catégories
 * @author alexis
 */
public class AfficherCategories extends HttpServlet {
	private static String JSP_PATH = "/WEB-INF/categories.jsp";
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// récupération des catégories
		ConnexionAdaptateur sql = new ConnexionAdaptateur();
		List<Categorie> categories = new ArrayList<>();
		try {
			categories.addAll(sql.getCategorieBdd(-1));
		} catch (SQLException ex) {
		}
		
		// injection et redirection
		req.setAttribute("categories", categories);
		req.getRequestDispatcher(JSP_PATH).forward(req, resp);
	}
}
