package ontology.predicate;

import info.gridworld.grid.Location;
import jade.content.Predicate;

public class Facing implements Predicate{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	private int direction;
	
	public Facing()  {
		this(Location.NORTH);
	}
	
	public Facing(int direction) {
		this.direction = direction;		
	}
	
	public int getDirection() {
		return direction;
	}
	public void setDirection(int direction) {
		this.direction = direction;
	}

}
