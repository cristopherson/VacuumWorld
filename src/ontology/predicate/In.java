package ontology.predicate;

import ontology.concept.LocationConcept;
import jade.content.Predicate;

public class In implements Predicate{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LocationConcept location;
	
	public In(LocationConcept location) {
		this.location = location;
	}
	
	public In(int row, int col) {
		this(new LocationConcept(row, col));
	}
	
	public In() {
		this(new LocationConcept());
	}
	
	public LocationConcept getLocation() {
		return location;
	}
	
	public void setLocation(LocationConcept location) {
		this.location = location;
	}
	
}
