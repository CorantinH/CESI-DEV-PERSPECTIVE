package servlets;

import beans.Categorie;

public class CategorieControlleur {
	
	private ConnexionAdaptateur bddConnect;
	private Categorie categorie;
	
	public CategorieControlleur () {
		this.bddConnect = new ConnexionAdaptateur();
		this.bddConnect.getBddConnector();
	}
	
	public void getAllCategorieFromBdd() {
		
	}
	
	public void getOneCategorieFromBdd(int idCategorie) {
		
	}
	

}
