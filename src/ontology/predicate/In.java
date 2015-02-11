package ontology.predicate;

import jade.content.Predicate;

public class In implements Predicate{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int row;
	private int col;
	private boolean at;
	
	public In() {
		row = 0;
		col = 0;
		at = false;
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
	
	public boolean isAt() {
		return at;
	}
	
	public void setAt(boolean at) {
		this.at  = at;
	}

}
