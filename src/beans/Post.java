package beans;

import java.util.Date;

public class Post {
	private int id;
	private String auteur;
	private Date date;
	private String contenu;
	private Topic topic;
	
	public Post() {}
	public Post(int id, String auteur, String contenu) {
		this.id = id;
		this.auteur = auteur;
		this.contenu = contenu;
		this.date = new Date();
		this.topic = new Topic();
	}
	public Post(int id, String auteur, String contenu, Date date, Topic topic) {
		this(id, auteur, contenu);
		this.date= date;
		this.topic = topic;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public Topic getCategorie() {
		return topic;
	}
	public void setCategorie(Topic topic) {
		this.topic = topic;
	}
	@Override
	public String toString() {
		return "Publication [auteur=" + auteur + ", date=" + date + ", contenu=" + contenu + ", Id=" + id
				+ ", categorie=" + topic.toString() + "]";
	}
}
