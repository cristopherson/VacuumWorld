package ontology.predicate;

import ontology.concept.VacuumConcept;
import jade.content.Predicate;

public class Facing implements Predicate{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	private VacuumConcept vacuum;
	private Boolean isfacing;
	
	public Facing() {
		vacuum = new VacuumConcept();
		isfacing = false;
	}
	
	public VacuumConcept getVacuum() {
		return vacuum;
	}
	public void setVacuum(VacuumConcept vacuum) {
		this.vacuum = vacuum;
	}
	
	public Boolean getIsFacing() {
		return isfacing;
	}
	public void setIsFacing(Boolean isFacing) {
		this.isfacing = isFacing;
	}

}
