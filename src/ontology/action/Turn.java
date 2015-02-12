package ontology.action;

import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;
import agents.Environment;
import ontology.concept.VacuumConcept;
import jade.content.AgentAction;

public class Turn implements AgentAction, Executable{

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

	@Override
	public void execute(Environment env) {
		// TODO Auto-generated method stub
		Bug bugActor = env.getWorld().getBugActor();
		int direction = bugActor.getDirection();
		
		switch(direction) {
		case Location.NORTH:
			bugActor.setDirection(Location.RIGHT);
			break;
		case Location.EAST:
			bugActor.setDirection(Location.SOUTH);
			break;
		case Location.SOUTH:
			bugActor.setDirection(Location.LEFT);
			break;
		case Location.WEST:
			bugActor.setDirection(Location.NORTH);
			break;			
		}
		
		env.getWorld().updateActor(env.getWorld().getBugLocation());
	}
	

}
