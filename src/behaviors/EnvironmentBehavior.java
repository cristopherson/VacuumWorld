package behaviors;

import jade.content.ContentManager;
import jade.content.lang.Codec.CodecException;
import jade.content.onto.OntologyException;
import jade.content.onto.UngroundedException;
import jade.content.onto.basic.Action;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import ontology.action.Executable;
import agents.Environment;

public class EnvironmentBehavior extends CyclicBehaviour {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void action() {
		// TODO Auto-generated method stub

		ACLMessage msgRx = myAgent.receive();
		if (msgRx != null && msgRx.getPerformative() == ACLMessage.REQUEST) {
			ContentManager contentManager = myAgent.getContentManager();
			System.out.println("RECEIVED = " + msgRx.getContent());
			msgRx.setLanguage("fipa-sl");
			msgRx.setOntology("vacuum-ontology");

			try {
				Action action = (Action) contentManager.extractContent(msgRx);
				((Executable) (action.getAction()))
						.execute((Environment) myAgent);
			} catch (UngroundedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (CodecException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (OntologyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		} else if (msgRx != null && msgRx.getPerformative() == ACLMessage.INFORM_IF){
			if (msgRx.getContent().equals("finished") && ((Environment)myAgent).isGoalFinished()) {
				ACLMessage msgFinished = msgRx.createReply();
				msgFinished.setPerformative(ACLMessage.CONFIRM);
				myAgent.send(msgFinished);
				myAgent.removeBehaviour(this);
			}
		} else {
			block();
		}
	}

}
