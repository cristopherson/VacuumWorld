package ontology.action;

import java.awt.Color;
import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Location;
import agents.Environment;
import ontology.concept.LocationConcept;
import jade.content.AgentAction;

public class Forward implements AgentAction, Executable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LocationConcept location;
	
	public Forward() {
		location = new LocationConcept();
	}
	
	public LocationConcept getLocation() {
		return location;
	}
	public void setLocation(LocationConcept location) {
		this.location = location;
	}

	@Override
	public void execute(Environment env) {
		// TODO Auto-generated method stub
		Bug bugActor = env.getWorld().getBugActor();
		int direction = bugActor.getDirection();
		Location bugLocation = env.getWorld().getBugLocation();
		Location newLocation = new Location(0,0);
		
		ArrayList<Location> locationList = env.getWorld().getGrid()
				.getOccupiedLocations();
		env.getWorld().remove(bugLocation);
		
		switch(direction) {
		case Location.NORTH:
			newLocation = new Location(bugLocation.getRow() - 1, bugLocation.getCol());
			break;
		case Location.EAST:
			newLocation = new Location(bugLocation.getRow(), bugLocation.getCol() + 1);
			break;
		case Location.SOUTH:
			newLocation = new Location(bugLocation.getRow() + 1, bugLocation.getCol());
			break;
		case Location.WEST:
			newLocation = new Location(bugLocation.getRow(), bugLocation.getCol() - 1);
			break;			
		}
		
		
		for (Location location : locationList) {
			Actor actor = env.getWorld().getGrid().get(location);
			if(actor != null && location.getCol() == newLocation.getCol() && location.getRow() == newLocation.getRow()) {
				env.getWorld().setFlowerActor((Flower)actor);
				bugActor.setColor(Color.BLUE);
			}
		}
		
		env.getWorld().updateActor(newLocation);
	}

}
