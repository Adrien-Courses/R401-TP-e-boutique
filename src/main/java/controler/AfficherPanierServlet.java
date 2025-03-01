package controler;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Panier;

@WebServlet("/afficherPanier")
public class AfficherPanierServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Récupérer la session
		HttpSession session = request.getSession(false); // false pour ne pas créer de session si on tombe dessus en
															// premier

		if (session != null) {
			// Récupérer le panier s'il existe
			Panier panier = (Panier) session.getAttribute("panier");
			if (panier == null) {
				panier = new Panier();
				session.setAttribute("panier", panier);
			}
		}

		// Rediriger vers la page du panier
		request.getRequestDispatcher("panier.jsp").forward(request, response);
	}
}