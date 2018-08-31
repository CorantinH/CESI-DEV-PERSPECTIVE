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
		
		// TODO: supprimer les fausses catégories
		if (categories.isEmpty()) {
			categories.addAll(fakeCategories());
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
			} else {
				// TODO: supprimer fausse catégorie
				categorie = fakeCategories().get(idCat);
			}
			post.setCategorie(categorie);
			
			message = (sql.insertTopic(topic) && sql.insertPost(post))? "" : "Erreur lors de la création du topic";
		} catch (SQLException ex) {
		}
		
		// TODO: supprimer les faux topics
		if (topics.isEmpty()) {
			topics.addAll(fakeTopics());
			topics.add(topic);
		}

		// injection et redirection
		req.setAttribute("message", message);
		req.setAttribute("categorie", categorie);
		req.setAttribute("topics", topics);
		req.getRequestDispatcher(JSP_PATH).forward(req, resp);
	}
	
	/**
	 * Créer des fausses catégories
	 * @return liste de catégorie
	 */
	private static List<Topic> fakeTopics() {
		List<Topic> topics = new ArrayList<>();
		
		topics.add(new Topic(0, "Raidez", "Besoin d'aide sur MySQL", new Date(), 3));
		topics.add(new Topic(1, "Mci7", "Pu*** de WEB-INF", new Date(), 8));
		topics.add(new Topic(2, "Mci7-sister", "compren pa JSTL", new Date(), 2));
		topics.add(new Topic(3, "Raidez", "adapteur ou controller ?", new Date(), 17));
		
		return topics;
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