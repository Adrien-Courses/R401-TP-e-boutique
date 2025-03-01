package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Panier implements Serializable {
	private List<Article> articles;

	public Panier() {
		this.articles = new ArrayList<>();
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void ajouterArticle(Article article) {
		// Vérifier si l'article est déjà dans le panier
		for (Article a : articles) {
			if (a.equals(article)) {
				// Incrémenter la quantité au lieu d'ajouter un nouvel article
				a.setQuantite(a.getQuantite() + 1);
				return;
			}
		}
		// Si l'article n'est pas dans le panier, l'ajouter
		articles.add(article);
	}

	public void retirerArticle(int id) {
		articles.removeIf(article -> article.getId() == id);
	}

	public int getNombreArticles() {
		int nombre = 0;
		for (Article article : articles) {
			nombre += article.getQuantite();
		}
		return nombre;
	}

	public double getTotal() {
		double total = 0;
		for (Article article : articles) {
			total += article.getSousTotal();
		}
		return total;
	}
}