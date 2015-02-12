package rules;

import jade.content.onto.basic.Action;
import ontology.predicate.Dirt;
import ontology.predicate.Facing;
import ontology.predicate.In;

public class PredicateRule {
	private In inPredicate;
	private Dirt dirtPredicate;
	private Facing facingPredicate;
	private Action action;
	
	public PredicateRule(In in, Facing facing, Dirt dirt, Action action) {
		setInPredicate(in);
		setDirtPredicate(dirt);
		setFacingPredicate(facing);
		setAction(action);
	}

	public In getInPredicate() {
		return inPredicate;
	}

	public void setInPredicate(In inPredicate) {
		this.inPredicate = inPredicate;
	}

	public Dirt getDirtPredicate() {
		return dirtPredicate;
	}

	public void setDirtPredicate(Dirt dirtPredicate) {
		this.dirtPredicate = dirtPredicate;
	}

	public Facing getFacingPredicate() {
		return facingPredicate;
	}

	public void setFacingPredicate(Facing facingPredicate) {
		this.facingPredicate = facingPredicate;
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}
	

}
