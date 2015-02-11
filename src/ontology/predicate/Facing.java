package ontology.predicate;

import ontology.concept.VacuumConcept;
import jade.content.Predicate;

public class Facing implements Predicate{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	private VacuumConcept vacuum;
	private boolean facing;
	
	public VacuumConcept getVacuumConcept() {
		return vacuum;
	}
	public void setVacuumConcept(VacuumConcept vacuum) {
		this.vacuum = vacuum;
	}
	
	public boolean isFacing() {
		return facing;
	}
	public void setFacing(boolean facing) {
		this.facing = facing;
	}

}
