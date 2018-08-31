package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControleurTopic extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO: mettre l'affichage et la création topic
		req.setAttribute("name", "<b>Mon CSS a cassé</b>" );
		req.setAttribute("status", "En cours" );
		req.setAttribute("author", "Jean Le Modo" );
		req.setAttribute("corps", "Plus de détails stp" );
		req.getRequestDispatcher("WEB-INF/discussion.jsp").forward(req, resp);
	}
}
