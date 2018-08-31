package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Post;
import beans.Topic;

public class AjoutPost extends HttpServlet {
	private static String JSP_PATH = "/topic?";
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ConnexionAdaptateur sql = new ConnexionAdaptateur();
		int idTopic = Integer.parseInt(req.getParameter("idTopic"));
		
		try {
			Topic topic = new Topic();
			topic.setId(idTopic);
			
			Post post = new Post();
			post.setAuteur(req.getParameter("auteur"));
			post.setContenu(req.getParameter("contenu"));
			post.setTopic(topic);
			sql.insertPost(post);
		} catch (SQLException ex) {
		}
		
		req.getRequestDispatcher(JSP_PATH + idTopic).forward(req, resp);
	}
}
