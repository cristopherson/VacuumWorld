package ontology.predicate;

import ontology.concept.LocationConcept;
import jade.content.Predicate;

public class Dirt implements Predicate{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LocationConcept location;
	private boolean isDirt;
	
	public Dirt() {
		location = new LocationConcept(0,0);
		isDirt = false;
	}
	
	public boolean getIsDirt() {
		return isDirt;
	}
	
	public void setDirt(boolean isDirt) {
		this.isDirt = isDirt;
	}
	
	public LocationConcept getLocation() {
		return location;
	}
	
	public void setLocation(LocationConcept location) {
		this.location = location;
	}
}
