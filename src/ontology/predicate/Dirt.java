package ontology.predicate;

import jade.content.Predicate;

public class Dirt implements Predicate{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean isDirt;
	
	public Dirt(boolean isDirt) {
		this.isDirt = isDirt;
	}
	
	public Dirt() {
		this(false);
	}
	
	public boolean getIsDirt() {
		return isDirt;
	}
	
	public void setIsDirt(boolean isDirt) {
		this.isDirt = isDirt;
	}
}
