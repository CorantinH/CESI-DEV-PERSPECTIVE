package beans;

import java.util.Date;

public class Topic {
	private int id;
	private String auteur;
	private String sujet;
	private Date date;
	private Categorie categorie;
	private boolean statut;
	private int nbMessages;
	
	public Topic() {}
	public Topic(int id, String auteur, String sujet) {
		this.id = id;
		this.auteur = auteur;
		this.sujet = sujet;
		this.date = new Date();
		this.categorie = new Categorie();
		this.statut = false;
	}
	public Topic(int id, String auteur, String sujet, Date date, Categorie categorie) {
		this(id, auteur, sujet);
		this.date = date;
		this.categorie = categorie;
	}
	public Topic(int id, String auteur, String sujet, Date date, int nbMessages) {
		this(id, auteur, sujet);
		this.date = date;
		this.nbMessages = nbMessages;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public String getSujet() {
		return sujet;
	}
	public void setSujet(String sujet) {
		this.sujet = sujet;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public boolean isStatut() {
		return statut;
	}
	public void setStatut(boolean statut) {
		this.statut = statut;
	}
	public int getNbMessages() {
		return nbMessages;
	}
	public void setNbMessages(int nbMessages) {
		this.nbMessages = nbMessages;
	}
}
