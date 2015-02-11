package behaviors;

import info.gridworld.grid.Location;
import ontology.action.Turn;
import ontology.concept.VacuumConcept;
import ontology.predicate.Facing;
import jade.content.ContentElementList;
import jade.content.ContentManager;
import jade.content.lang.Codec.CodecException;
import jade.content.onto.OntologyException;
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
		ACLMessage msgTx = new ACLMessage(ACLMessage.PROPOSE);
		VacuumConcept vacuum = new VacuumConcept();
		Facing facingPredicate = new Facing();
		Turn turnAction = new Turn();
		
		msgTx.addReceiver(new AID("vacuum", AID.ISLOCALNAME));
		msgTx.setLanguage("fipa-sl");
		msgTx.setOntology("vacuum-ontology");
		vacuum.setDirection(Location.RIGHT);
		cel.add(facingPredicate);
		cel.add(turnAction);
		
		for (String lang:contentManager.getLanguageNames()) {
			System.out.println("Lang = " + lang);			
		}
		System.out.println("Ontology ");
		try {
			contentManager.fillContent(msgTx, cel);
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
