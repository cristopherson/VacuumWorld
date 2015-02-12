package ontology.action;

import java.awt.Color;

import agents.Environment;
import info.gridworld.grid.Location;
import jade.content.AgentAction;

public class Suck implements AgentAction, Executable{

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

	@Override
	public void execute(Environment env) {
		// TODO Auto-generated method stub
		env.getWorld().getBugActor().setColor(Color.ORANGE);
		env.getWorld().setFlowerActor(null);
		env.getWorld().updateActor(env.getWorld().getBugLocation());
	}

}
