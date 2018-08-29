package servlets;

import beans.Topic;

public class TopicControlleur {
	
	private ConnexionAdaptateur bddConnect;
	
	public TopicControlleur() {
		this.bddConnect = new ConnexionAdaptateur();
		this.bddConnect.getBddConnector();
	}
	
	public void getAllTopicFromBdd() {
		this.bddConnect.getTopicBdd(-1);
	}
	
	public void getOneTopicFromBdd(int idTopic) {
		this.bddConnect.getTopicBdd(idTopic);
	}

}
