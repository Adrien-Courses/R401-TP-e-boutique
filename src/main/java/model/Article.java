package model;

import java.io.Serializable;

public class Article implements Serializable {
	private int id;
	private String nom;
	private double prix;
	private int quantite;

	public Article(int id, String nom, double prix) {
		this.id = id;
		this.nom = nom;
		this.prix = prix;
		this.quantite = 1; // Quantité par défaut
	}

	// Getters et Setters
	public int getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public double getPrix() {
		return prix;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public double getSousTotal() {
		return prix * quantite;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		Article article = (Article) obj;
		return id == article.id;
	}

	@Override
	public int hashCode() {
		return id;
	}
}