package controler;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Article;
import model.Panier;

@WebServlet("/ajouterAuPanier")
public class AjouterAuPanierServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Récupérer les paramètres du formulaire
		String idStr = request.getParameter("id");
		String nom = request.getParameter("nom");
		String prixStr = request.getParameter("prix");

		// Valider et convertir les données
		try {
			int id = Integer.parseInt(idStr);
			double prix = Double.parseDouble(prixStr);

			// Créer un nouvel article
			Article article = new Article(id, nom, prix);

			// Récupérer la session
			HttpSession session = request.getSession();

			// Récupérer le panier existant ou en créer un nouveau
			Panier panier = (Panier) session.getAttribute("panier");
			if (panier == null) {
				panier = new Panier();
				session.setAttribute("panier", panier);
			}

			// Ajouter l'article au panier
			panier.ajouterArticle(article);

			// Ajouter un message de confirmation
			request.setAttribute("message", "L'article " + nom + " a été ajouté au panier.");

		} catch (NumberFormatException e) {
			request.setAttribute("erreur", "Données invalides.");
		}

		// Rediriger vers la page du catalogue ou panier
		request.getRequestDispatcher("catalogue.jsp").forward(request, response);
	}
}