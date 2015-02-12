package behaviors;

import java.util.ArrayList;

import info.gridworld.grid.Location;
import ontology.action.Forward;
import ontology.action.Suck;
import ontology.action.Turn;
import ontology.predicate.Dirt;
import ontology.predicate.Facing;
import ontology.predicate.In;
import rules.PredicateRule;
import jade.content.ContentElementList;
import jade.content.ContentManager;
import jade.content.lang.Codec.CodecException;
import jade.content.onto.OntologyException;
import jade.content.onto.UngroundedException;
import jade.content.onto.basic.Action;
import jade.core.AID;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class VacuumBehavior extends CyclicBehaviour {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<PredicateRule> ruleList = new ArrayList<PredicateRule>();

	public void onStart() {		
		AID aid = myAgent.getAID();
		ruleList.add(new PredicateRule(new In(0, 0), new Facing(Location.NORTH), new Dirt(true), new Action(aid, new Suck())));
		ruleList.add(new PredicateRule(new In(0, 0), new Facing(Location.NORTH), new Dirt(false), new Action(aid, new Turn())));
		ruleList.add(new PredicateRule(new In(0, 0), new Facing(Location.EAST), new Dirt(true), new Action(aid, new Suck())));
		ruleList.add(new PredicateRule(new In(0, 0), new Facing(Location.EAST), new Dirt(false), new Action(aid, new Forward())));
		ruleList.add(new PredicateRule(new In(0, 0), new Facing(Location.SOUTH), new Dirt(true), new Action(aid, new Suck())));
		ruleList.add(new PredicateRule(new In(0, 0), new Facing(Location.SOUTH), new Dirt(false), new Action(aid, new Forward())));
		ruleList.add(new PredicateRule(new In(0, 0), new Facing(Location.WEST), new Dirt(true), new Action(aid, new Suck())));
		ruleList.add(new PredicateRule(new In(0, 0), new Facing(Location.WEST), new Dirt(false), new Action(aid, new Turn())));
		
		ruleList.add(new PredicateRule(new In(0, 1), new Facing(Location.NORTH), new Dirt(true), new Action(aid, new Suck())));
		ruleList.add(new PredicateRule(new In(0, 1), new Facing(Location.NORTH), new Dirt(false), new Action(aid, new Turn())));
		ruleList.add(new PredicateRule(new In(0, 1), new Facing(Location.EAST), new Dirt(true), new Action(aid, new Suck())));
		ruleList.add(new PredicateRule(new In(0, 1), new Facing(Location.EAST), new Dirt(false), new Action(aid, new Forward())));
		ruleList.add(new PredicateRule(new In(0, 1), new Facing(Location.SOUTH), new Dirt(true), new Action(aid, new Suck())));
		ruleList.add(new PredicateRule(new In(0, 1), new Facing(Location.SOUTH), new Dirt(false), new Action(aid, new Forward())));
		ruleList.add(new PredicateRule(new In(0, 1), new Facing(Location.WEST), new Dirt(true), new Action(aid, new Suck())));
		ruleList.add(new PredicateRule(new In(0, 1), new Facing(Location.WEST), new Dirt(false), new Action(aid, new Forward())));
		
		ruleList.add(new PredicateRule(new In(0, 2), new Facing(Location.NORTH), new Dirt(true), new Action(aid, new Suck())));
		ruleList.add(new PredicateRule(new In(0, 2), new Facing(Location.NORTH), new Dirt(false), new Action(aid, new Turn())));
		ruleList.add(new PredicateRule(new In(0, 2), new Facing(Location.EAST), new Dirt(true), new Action(aid, new Suck())));
		ruleList.add(new PredicateRule(new In(0, 2), new Facing(Location.EAST), new Dirt(false), new Action(aid, new Turn())));
		ruleList.add(new PredicateRule(new In(0, 2), new Facing(Location.SOUTH), new Dirt(true), new Action(aid, new Suck())));
		ruleList.add(new PredicateRule(new In(0, 2), new Facing(Location.SOUTH), new Dirt(false), new Action(aid, new Forward())));
		ruleList.add(new PredicateRule(new In(0, 2), new Facing(Location.WEST), new Dirt(true), new Action(aid, new Suck())));
		ruleList.add(new PredicateRule(new In(0, 2), new Facing(Location.WEST), new Dirt(false), new Action(aid, new Forward())));
		
		ruleList.add(new PredicateRule(new In(1, 0), new Facing(Location.NORTH), new Dirt(true), new Action(aid, new Suck())));
		ruleList.add(new PredicateRule(new In(1, 0), new Facing(Location.NORTH), new Dirt(false), new Action(aid, new Turn())));
		ruleList.add(new PredicateRule(new In(1, 0), new Facing(Location.EAST), new Dirt(true), new Action(aid, new Suck())));
		ruleList.add(new PredicateRule(new In(1, 0), new Facing(Location.EAST), new Dirt(false), new Action(aid, new Forward())));
		ruleList.add(new PredicateRule(new In(1, 0), new Facing(Location.SOUTH), new Dirt(true), new Action(aid, new Suck())));
		ruleList.add(new PredicateRule(new In(1, 0), new Facing(Location.SOUTH), new Dirt(false), new Action(aid, new Forward())));
		ruleList.add(new PredicateRule(new In(1, 0), new Facing(Location.WEST), new Dirt(true), new Action(aid, new Suck())));
		ruleList.add(new PredicateRule(new In(1, 0), new Facing(Location.WEST), new Dirt(false), new Action(aid, new Turn())));
		
		ruleList.add(new PredicateRule(new In(1, 1), new Facing(Location.NORTH), new Dirt(true), new Action(aid, new Suck())));
		ruleList.add(new PredicateRule(new In(1, 1), new Facing(Location.NORTH), new Dirt(false), new Action(aid, new Forward())));
		ruleList.add(new PredicateRule(new In(1, 1), new Facing(Location.EAST), new Dirt(true), new Action(aid, new Suck())));
		ruleList.add(new PredicateRule(new In(1, 1), new Facing(Location.EAST), new Dirt(false), new Action(aid, new Forward())));
		ruleList.add(new PredicateRule(new In(1, 1), new Facing(Location.SOUTH), new Dirt(true), new Action(aid, new Suck())));
		ruleList.add(new PredicateRule(new In(1, 1), new Facing(Location.SOUTH), new Dirt(false), new Action(aid, new Forward())));
		ruleList.add(new PredicateRule(new In(1, 1), new Facing(Location.WEST), new Dirt(true), new Action(aid, new Suck())));
		ruleList.add(new PredicateRule(new In(1, 1), new Facing(Location.WEST), new Dirt(false), new Action(aid, new Forward())));
		
		ruleList.add(new PredicateRule(new In(1, 2), new Facing(Location.NORTH), new Dirt(true), new Action(aid, new Suck())));
		ruleList.add(new PredicateRule(new In(1, 2), new Facing(Location.NORTH), new Dirt(false), new Action(aid, new Forward())));
		ruleList.add(new PredicateRule(new In(1, 2), new Facing(Location.EAST), new Dirt(true), new Action(aid, new Suck())));
		ruleList.add(new PredicateRule(new In(1, 2), new Facing(Location.EAST), new Dirt(false), new Action(aid, new Turn())));
		ruleList.add(new PredicateRule(new In(1, 2), new Facing(Location.SOUTH), new Dirt(true), new Action(aid, new Suck())));
		ruleList.add(new PredicateRule(new In(1, 2), new Facing(Location.SOUTH), new Dirt(false), new Action(aid, new Forward())));
		ruleList.add(new PredicateRule(new In(1, 2), new Facing(Location.WEST), new Dirt(true), new Action(aid, new Suck())));
		ruleList.add(new PredicateRule(new In(1, 2), new Facing(Location.WEST), new Dirt(false), new Action(aid, new Forward())));
		
		ruleList.add(new PredicateRule(new In(2, 0), new Facing(Location.NORTH), new Dirt(true), new Action(aid, new Suck())));
		ruleList.add(new PredicateRule(new In(2, 0), new Facing(Location.NORTH), new Dirt(false), new Action(aid, new Forward())));
		ruleList.add(new PredicateRule(new In(2, 0), new Facing(Location.EAST), new Dirt(true), new Action(aid, new Suck())));
		ruleList.add(new PredicateRule(new In(2, 0), new Facing(Location.EAST), new Dirt(false), new Action(aid, new Forward())));
		ruleList.add(new PredicateRule(new In(2, 0), new Facing(Location.SOUTH), new Dirt(true), new Action(aid, new Suck())));
		ruleList.add(new PredicateRule(new In(2, 0), new Facing(Location.SOUTH), new Dirt(false), new Action(aid, new Turn())));
		ruleList.add(new PredicateRule(new In(2, 0), new Facing(Location.WEST), new Dirt(true), new Action(aid, new Suck())));
		ruleList.add(new PredicateRule(new In(2, 0), new Facing(Location.WEST), new Dirt(false), new Action(aid, new Turn())));
		
		ruleList.add(new PredicateRule(new In(2, 1), new Facing(Location.NORTH), new Dirt(true), new Action(aid, new Suck())));
		ruleList.add(new PredicateRule(new In(2, 1), new Facing(Location.NORTH), new Dirt(false), new Action(aid, new Forward())));
		ruleList.add(new PredicateRule(new In(2, 1), new Facing(Location.EAST), new Dirt(true), new Action(aid, new Suck())));
		ruleList.add(new PredicateRule(new In(2, 1), new Facing(Location.EAST), new Dirt(false), new Action(aid, new Forward())));
		ruleList.add(new PredicateRule(new In(2, 1), new Facing(Location.SOUTH), new Dirt(true), new Action(aid, new Suck())));
		ruleList.add(new PredicateRule(new In(2, 1), new Facing(Location.SOUTH), new Dirt(false), new Action(aid, new Turn())));
		ruleList.add(new PredicateRule(new In(2, 1), new Facing(Location.WEST), new Dirt(true), new Action(aid, new Suck())));
		ruleList.add(new PredicateRule(new In(2, 1), new Facing(Location.WEST), new Dirt(false), new Action(aid, new Forward())));

		ruleList.add(new PredicateRule(new In(2, 2), new Facing(Location.NORTH), new Dirt(true), new Action(aid, new Suck())));
		ruleList.add(new PredicateRule(new In(2, 2), new Facing(Location.NORTH), new Dirt(false), new Action(aid, new Forward())));
		ruleList.add(new PredicateRule(new In(2, 2), new Facing(Location.EAST), new Dirt(true), new Action(aid, new Suck())));
		ruleList.add(new PredicateRule(new In(2, 2), new Facing(Location.EAST), new Dirt(false), new Action(aid, new Turn())));
		ruleList.add(new PredicateRule(new In(2, 2), new Facing(Location.SOUTH), new Dirt(true), new Action(aid, new Suck())));
		ruleList.add(new PredicateRule(new In(2, 2), new Facing(Location.SOUTH), new Dirt(false), new Action(aid, new Turn())));
		ruleList.add(new PredicateRule(new In(2, 2), new Facing(Location.WEST), new Dirt(true), new Action(aid, new Suck())));
		ruleList.add(new PredicateRule(new In(2, 2), new Facing(Location.WEST), new Dirt(false), new Action(aid, new Forward())));
		
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub
		ACLMessage msgRx = myAgent.receive();
		if (msgRx != null && msgRx.getPerformative() == ACLMessage.INFORM) {
			System.out.println("MSG " + msgRx);
			msgRx.setLanguage("fipa-sl");
			msgRx.setOntology("vacuum-ontology");
			
			ContentManager contentManager = myAgent.getContentManager();
			ContentElementList cel = new ContentElementList();
			
			ACLMessage msgTx = msgRx.createReply();
			msgTx.setPerformative(ACLMessage.REQUEST);
			msgTx.setLanguage("fipa-sl");
			msgTx.setOntology("vacuum-ontology");
			
			try {
				ContentElementList elementList = (ContentElementList) contentManager.extractContent(msgRx);
				Action action = getActionFromRules((In)elementList.get(0), (Facing)elementList.get(1), (Dirt)elementList.get(2));
				cel.add(action);
				contentManager.fillContent(msgTx, cel);
				System.out.println("MSG " + msgTx);
			} catch (UngroundedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (CodecException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (OntologyException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			myAgent.send(msgTx);
			
			ACLMessage msgFinished = msgRx.createReply();
			msgFinished.setPerformative(ACLMessage.INFORM_IF);
			msgFinished.setContent("finished");
			myAgent.send(msgFinished);
		} else if (msgRx != null && msgRx.getPerformative() == ACLMessage.CONFIRM) {
			System.out.println("Dirt is cleaned");
			myAgent.removeBehaviour(this);
		} else {
			block();
		}

	}
	
	private Action getActionFromRules(In in, Facing facing, Dirt dirt) {
		for(PredicateRule rule: ruleList) {
			In inPredicate = rule.getInPredicate();
			Facing facingPredicate = rule.getFacingPredicate();
			Dirt dirtPredicate = rule.getDirtPredicate();
			
			if (in.getLocation().getCol() == inPredicate.getLocation().getCol() &&
					in.getLocation().getRow() == inPredicate.getLocation().getRow() &&
					facing.getDirection() == facingPredicate.getDirection() &&
					dirt.getIsDirt() == dirtPredicate.getIsDirt()) {
				return rule.getAction();				
			}
		}
		return null;
	}

}
