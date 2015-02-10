package agents;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class Environment extends Agent{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private VacuumWorld world;
	
	public Environment() {
		world = new VacuumWorld();
		world.show();
	}
	
	public void setup() {
		addBehaviour(new CyclicBehaviour() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void action() {
				// TODO Auto-generated method stub
				
				ACLMessage msgRx = receive();
				if (msgRx != null) {
					System.out.println(msgRx);
				} else {
					block();
				}
			}
			
		});
		
	}

}
