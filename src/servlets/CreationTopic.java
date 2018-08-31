package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Categorie;
import beans.Post;
import beans.Topic;

public class CreationTopic extends HttpServlet {
	private static String JSP_PATH = "WEB-INF/topics.jsp";
	private static String JSP_PATH_AJOUT = "WEB-INF/ajoutTopic.jsp";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// récupération de la catégorie actuelle et des autres
		ConnexionAdaptateur sql = new ConnexionAdaptateur();
		List<Categorie> categories = new ArrayList<>();
		try {
			categories.addAll(sql.getCategorieBdd(-1));
		} catch (SQLException ex) {
		}
		
		// injection et redirection
		req.setAttribute("categories", categories);
		req.setAttribute("selectedCategorie", Integer.parseInt(req.getParameter("idCat")));
		req.getRequestDispatcher(JSP_PATH_AJOUT).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ConnexionAdaptateur sql = new ConnexionAdaptateur();
		List<Topic> topics = new ArrayList<>();
		Categorie categorie = null;
		String message = null;
		
		Topic topic = new Topic();
		topic.setAuteur(req.getParameter("auteur"));
		topic.setSujet(req.getParameter("sujet"));
		topic.setNbMessages(1);
		topic.setDate(new Date());
		topic.setStatut(false);
		
		Post post = new Post();
		post.setAuteur(topic.getAuteur());
		post.setContenu(req.getParameter("contenu"));
		post.setDate(topic.getDate());
		
		try {
			int idCat = Integer.parseInt(req.getParameter("categorie"));
			topics.addAll(sql.getTopicsWithCategorie(idCat));
			
			List<Categorie> categories = sql.getCategorieBdd(idCat);
			if (!categories.isEmpty()) {
				categorie = categories.get(0);
			}
			topic.setCategorie(categorie);
			post.setTopic(topic);
			
			message = (sql.insertTopic(topic) && sql.insertPost(post))? "" : "Erreur lors de la création du topic";
		} catch (SQLException ex) {
		}

		// injection et redirection
		req.setAttribute("message", message);
		req.setAttribute("categorie", categorie);
		req.setAttribute("topics", topics);
		req.getRequestDispatcher(JSP_PATH).forward(req, resp);
	}
}