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

public class CreationTopic extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// récupération de la catégorie actuelle et des autres
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
		
		// injection et redirection
		req.setAttribute("categories", categories);
		req.setAttribute("selectedCategorie", Integer.parseInt(req.getParameter("idCat")));
		req.getRequestDispatcher("WEB-INF/ajoutTopic.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}
	
	/**
	 * Créer des fausses catégories
	 * @return liste de catégorie
	 */
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