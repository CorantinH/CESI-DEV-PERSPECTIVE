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
			int idCat = Integer.parseInt(req.getParameter("idCat"));
			topics.addAll(sql.getTopicsWithCategorie(idCat));
			
			List<Categorie> categories = sql.getCategorieBdd(idCat);
			if (!categories.isEmpty()) {
				categorie = categories.get(0);
			}
		} catch (SQLException ex) {
		}
		
		// récupération du nombre de messages d'un topic
		getNbMessageFromTopic(sql, topics);
		
		// injection et redirection
		req.setAttribute("categorie", categorie);
		req.setAttribute("topics", topics);
		req.getRequestDispatcher(JSP_PATH).forward(req, resp);
	}
	
	private static void getNbMessageFromTopic(ConnexionAdaptateur sql, List<Topic> topics) {
		for (Topic topic : topics) {
			int nbMessages = 0;
			try {
				nbMessages = sql.getPostsWithTopic(topic.getId()).size();
			} catch (SQLException ex) {
			}
			
			topic.setNbMessages(nbMessages);
		}
	}
}
