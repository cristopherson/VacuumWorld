package ontology.predicate;

import jade.content.Predicate;

public class Dirt implements Predicate{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int col;
	private int row;
	private boolean dirt;
	
	public boolean isDirt() {
		return dirt;
	}
	
	public void setDirt(boolean dirt) {
		this.dirt = dirt;
	}
	
	public int getRow() {
		return row;
	}
	
	public void setRow(int row) {
		this.row= row;
	}

	public int getCol() {
		return col;
	}
	
	public void setCol(int col) {
		this.col = col;
	}

}
