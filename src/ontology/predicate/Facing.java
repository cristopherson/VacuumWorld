package ontology.predicate;

import jade.content.Predicate;

public class Facing implements Predicate{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	private int direction;
	private boolean facing;
	
	public int getDirection() {
		return direction;
	}
	public void setDirection(int direction) {
		this.direction = direction;
	}
	
	public boolean isFacing() {
		return facing;
	}
	public void setFacing(boolean facing) {
		this.facing = facing;
	}

}
