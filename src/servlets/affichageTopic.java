package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class affichageTopic extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setAttribute("name", "<b>Mon CSS a cassé</b>" );
		req.setAttribute("status", "En cours" );
		req.setAttribute("author", "Jean Le Modo" );
		req.setAttribute("corps", "Plus de détails stp" );
		req.setAttribute("date", "21/01/2018" );
		
		req.getRequestDispatcher("WEB-INF/afficherTopic.jsp").forward(req, resp);
	}
}
