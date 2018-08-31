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
import beans.Topic;

/**
 * Récupère et affiche les topics d'une categorie
 * @author alexis
 *
 */
public class AfficherTopics extends HttpServlet {
	private static String JSP_PATH = "/WEB-INF/topics.jsp";
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// récupération des topics d'une catégorie
		ConnexionAdaptateur sql = new ConnexionAdaptateur();
		List<Topic> topics = new ArrayList<>();
		Categorie categorie = null;
		
		try {
			int idCat = Integer.parseInt(req.getParameter("id"));
			topics.addAll(sql.getTopicsWithCategorie(idCat));
			
			List<Categorie> categories = sql.getCategorieBdd(idCat);
			if (!categories.isEmpty()) {
				categorie = categories.get(0);
			} else {
				// TODO: supprimer fausse catégorie
				categorie = new Categorie(0, "Java");
			}
		} catch (SQLException ex) {
		}
		
		// récupération du nombre de messages d'un topic
		getNbMessageFromTopic(sql, topics);
		
		// TODO: supprimer les faux topics
		if (topics.isEmpty()) {
			topics.addAll(fakeTopics());
		}
		
		// injection et redirection
		req.setAttribute("categorie", categorie);
		req.setAttribute("topics", topics);
		req.getRequestDispatcher(JSP_PATH).forward(req, resp);
	}
	
	private static void getNbMessageFromTopic(ConnexionAdaptateur sql, List<Topic> topics) {
		for (Topic topic : topics) {
			int nbMessages = 0;
			try {
				nbMessages = sql.getPostBdd(topic.getId()).size();
			} catch (SQLException ex) {
			}
			
			topic.setNbMessages(nbMessages);
		}
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
}
