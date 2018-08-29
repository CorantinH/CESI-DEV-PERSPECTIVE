package servlets;

import beans.Categorie;

public class CategorieControlleur {
	
	private ConnexionAdaptateur bddConnect;
	
	public CategorieControlleur () {
		this.bddConnect = new ConnexionAdaptateur();
		this.bddConnect.getBddConnector();
	}
	
	public void getAllCategorieFromBdd() {
		this.bddConnect.getCategorieBdd(-1);
	}
	
	public void getOneCategorieFromBdd(int idCategorie) {
		this.bddConnect.getCategorieBdd(idCategorie);
	}
	

}
