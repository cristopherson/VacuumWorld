package ontology.concept;

import info.gridworld.grid.Location;
import jade.content.Concept;

public class LocationConcept implements Concept {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int row;
	private int col;

	public LocationConcept() {
		this(0, 0);
	}

	public LocationConcept(Location location) {
		this(location.getRow(), location.getCol());
	}
	public LocationConcept(int row, int col) {
		this.row = row;
		this.col = col;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

}
