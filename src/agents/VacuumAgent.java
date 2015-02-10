package agents;

import jade.core.AID;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;

public class VacuumAgent extends Agent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public VacuumAgent() {
		
	}
	
	public void setup() {
		ACLMessage msgTx = new ACLMessage(ACLMessage.INFORM);
		msgTx.setContent("Hello. My name is " + getLocalName() + "\n");
		msgTx.addReceiver(new AID("Env", AID.ISLOCALNAME));
		send(msgTx);		
		
	}

}
