package servlets;

import beans.Post;

public class PostControlleur {
	
	private ConnexionAdaptateur bddConnect;
	
	public PostControlleur () {
		this.bddConnect = new ConnexionAdaptateur();
		this.bddConnect.getBddConnector();
	}
	
	public void getAllPostFromBdd() {
		this.bddConnect.getPostBdd(-1);
	}
	
	public void getOnePostFromBdd(int idPost) {
		this.bddConnect.getPostBdd(idPost);
	}
}
