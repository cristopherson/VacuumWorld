package ontology.action;

import utilities.Direction;
import info.gridworld.grid.Location;
import jade.content.AgentAction;

public class Turn implements AgentAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Location location;
	private Direction direction;
	
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	
	public Direction getDirection() {
		return direction;
	}
	public void setDirection(Direction direction) {
		this.direction = direction;
	}

}
