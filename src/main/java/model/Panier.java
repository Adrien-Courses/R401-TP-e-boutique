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

	}

	public void retirerArticle(int id) {

	}

	public int getNombreArticles() {
		return 0;
	}

	public double getTotal() {
		double total = 0;
		for (Article article : articles) {
			total += article.getSousTotal();
		}
		return total;
	}
}