package controler;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Panier;

@WebServlet("/supprimerArticle")
public class SupprimerArticleServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Récupérer l'ID de l'article à supprimer
		String idStr = request.getParameter("id");

		try {
			int id = Integer.parseInt(idStr);

			// Récupérer la session
			HttpSession session = request.getSession(false);

			if (session != null) {
				// Récupérer le panier s'il existe
				Panier panier = (Panier) session.getAttribute("panier");
				if (panier != null) {
					// Supprimer l'article
					panier.retirerArticle(id);
					request.setAttribute("message", "Article retiré du panier.");
				}
			}

		} catch (NumberFormatException e) {
			request.setAttribute("erreur", "ID d'article invalide.");
		}

		// Rediriger vers la page du panier
		request.getRequestDispatcher("panier.jsp").forward(request, response);
	}
}