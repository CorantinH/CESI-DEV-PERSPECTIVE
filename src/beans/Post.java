package beans;

import java.util.Date;

public class Post {
	private int id;
	private String auteur;
	private Date date;
	private String contenu;
	private Categorie categorie;
	
	public Post() {}
	public Post(int id, String auteur, String contenu) {
		this.id = id;
		this.auteur = auteur;
		this.contenu = contenu;
		this.date = new Date();
		this.categorie = new Categorie();
	}
	public Post(int id, String auteur, String contenu, Date date, Categorie categorie) {
		this(id, auteur, contenu);
		this.date= date;
		this.categorie = categorie;
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
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	@Override
	public String toString() {
		return "Publication [auteur=" + auteur + ", date=" + date + ", contenu=" + contenu + ", Id=" + id
				+ ", categorie=" + categorie + "]";
	}
}
