package behaviors;

import java.util.Iterator;

import info.gridworld.grid.Location;
import ontology.action.Turn;
import ontology.concept.VacuumConcept;
import ontology.predicate.Facing;
import jade.content.ContentElement;
import jade.content.ContentElementList;
import jade.content.ContentManager;
import jade.content.lang.Codec.CodecException;
import jade.content.onto.OntologyException;
import jade.content.onto.basic.Action;
import jade.core.AID;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

public class VacuumBehavior extends OneShotBehaviour{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void action() {
		// TODO Auto-generated method stub
		ContentManager contentManager = myAgent.getContentManager();
		ContentElementList cel = new ContentElementList();
		ACLMessage msgTx = new ACLMessage(ACLMessage.REQUEST);
		VacuumConcept vacuum = new VacuumConcept();
		Facing facingPredicate = new Facing();
		Turn turnAction = new Turn();
		
		msgTx.addReceiver(new AID("env", AID.ISLOCALNAME));
		msgTx.setLanguage("fipa-sl");
		msgTx.setOntology("vacuum-ontology");
		vacuum.setDirection(Location.RIGHT);
//		facingPredicate.setIsFacing(true);
		facingPredicate.setVacuum(vacuum);
		turnAction.setVacuum(vacuum);
//		cel.add(facingPredicate);
		Action myAction = new Action(myAgent.getAID(), turnAction);
		
		cel.add(myAction);
		
		try {
			contentManager.fillContent(msgTx, cel);
			System.out.println("MSG " + msgTx);
		} catch (CodecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (OntologyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		myAgent.send(msgTx);
		
	}

}
