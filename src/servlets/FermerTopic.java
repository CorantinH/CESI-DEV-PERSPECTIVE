package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Topic;

public class FermerTopic extends HttpServlet {
	private static String JSP_PATH = "/topic?idTopic=";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// changement du statut d'un topic
		ConnexionAdaptateur sql = new ConnexionAdaptateur();
		int idTopic = Integer.parseInt(req.getParameter("idTopic"));
		
		try {
			Topic topic = new Topic();
			topic.setId(idTopic);
			sql.editTopicSolved(topic);
		} catch (SQLException ex) {
		}
		
		// injection et redirection
		req.getRequestDispatcher(JSP_PATH + idTopic).forward(req, resp);
	}
}
