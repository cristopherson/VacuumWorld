package ontology.action;

import ontology.concept.LocationConcept;
import jade.content.AgentAction;

public class Forward implements AgentAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LocationConcept location;
	
	public Forward() {
		location = new LocationConcept();
	}
	
	public LocationConcept getLocation() {
		return location;
	}
	public void setLocation(LocationConcept location) {
		this.location = location;
	}

}
