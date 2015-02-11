package ontology.action;

import info.gridworld.grid.Location;
import jade.content.AgentAction;

public class Suck implements AgentAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Location location;
	
	public Suck() {
		location = new Location(0,0);
	}
	
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}

}
