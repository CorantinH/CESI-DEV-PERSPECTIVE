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

public class ControllerCategorie extends HttpServlet {
	private static String JSP_PATH = "/WEB-INF/categorie.jsp";
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ConnexionAdaptateur sql = new ConnexionAdaptateur();
		List<Categorie> categories = new ArrayList<>();
		try {
			categories.addAll(sql.getCategorieBdd(-1));
		} catch (SQLException ex) {
		}
		
		// TODO: supprimer les fausses catégories
		if (categories.isEmpty()) {
			categories.addAll(fakeCategories());
		}
		
		req.setAttribute("categories", categories);
		req.getRequestDispatcher(JSP_PATH).forward(req, resp);
	}
	
	private static List<Categorie> fakeCategories() {
		List<Categorie> categories = new ArrayList<>();
		
		categories.add(new Categorie(0, "Java"));
		categories.add(new Categorie(1, "C"));
		categories.add(new Categorie(2, "C++"));
		categories.add(new Categorie(3, "C#"));
		categories.add(new Categorie(4, "Python3"));
		categories.add(new Categorie(5, "HTML5/CSS3"));
		categories.add(new Categorie(6, "Javascript"));
		
		return categories;
	}
}
