package ontology.concept;

import jade.content.Concept;

public class LocationConcept implements Concept{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int row;
	private int col;
	
	public LocationConcept() {
		row = 0;
		col = 0;		
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
