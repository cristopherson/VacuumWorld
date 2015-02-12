package ontology.concept;

import jade.content.Concept;

public class VacuumConcept implements Concept{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int direction;
	
	public VacuumConcept() {
		direction = 0;
	}
	
	public int getDirection() {
		return direction;
	}
	
	public void setDirection(int direction) {		
		this.direction = direction;
	}
}
