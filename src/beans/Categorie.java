package beans;

public class Categorie {
	private String libelle;
	private Long Id;
	
	public Categorie() {}
	public Categorie(String libelle) {
		this.libelle = libelle;
	}
	
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
}
