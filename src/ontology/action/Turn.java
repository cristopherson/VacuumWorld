package ontology.action;

import ontology.concept.VacuumConcept;
import jade.content.AgentAction;
import jade.content.onto.basic.Action;

public class Turn implements AgentAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private VacuumConcept vacuum;
	
	public Turn() {
		vacuum = new VacuumConcept();
	}
	
	public VacuumConcept getVacuum() {
		return vacuum;
	}
	public void setVacuum(VacuumConcept vacuum) {
		this.vacuum = vacuum;
	}
	

}
