package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Post;
import beans.Topic;

public class AfficherPosts extends HttpServlet {
	private static String JSP_PATH = "/WEB-INF/discussion.jsp";
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// récupération des posts d'un topic
		ConnexionAdaptateur sql = new ConnexionAdaptateur();
		List<Post> posts = new ArrayList<>();
		Topic topic = null;
		
		int idTopic = Integer.parseInt(req.getParameter("idTopic"));
		
		try {
			posts = sql.getPostsWithTopic(idTopic);
			List<Topic> topics = sql.getTopicBdd(idTopic);
			if (!topics.isEmpty()) {
				topic = topics.get(0);
			}
		} catch (SQLException ex) {
		}
		
		
		req.setAttribute("posts", posts);
		req.setAttribute("topic", topic);
		req.getRequestDispatcher(JSP_PATH).forward(req, resp);
	}
}
