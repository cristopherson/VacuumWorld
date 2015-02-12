package ontology.predicate;

import ontology.concept.LocationConcept;
import jade.content.Predicate;

public class In implements Predicate{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LocationConcept location;
	private boolean isAt;
	
	public In() {
		location = new LocationConcept();
		isAt = false;
	}
	
	public LocationConcept getLocation() {
		return location;
	}
	
	public void setCol(LocationConcept location) {
		this.location = location;
	}
	
	public boolean getIsAt() {
		return isAt;
	}
	
	public void setIsAt(boolean isAt) {
		this.isAt  = isAt;
	}

}
