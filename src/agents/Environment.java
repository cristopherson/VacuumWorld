package agents;

import ontology.VacuumWorldOntology;
import jade.content.ContentManager;
import jade.content.lang.Codec;
import jade.content.lang.Codec.CodecException;
import jade.content.lang.sl.SLCodec;
import jade.content.onto.Ontology;
import jade.content.onto.OntologyException;
import jade.content.onto.UngroundedException;
import jade.content.onto.basic.Action;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class Environment extends Agent{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private VacuumWorld world;
	private Codec codec;
	private Ontology ontology;
	
	public Environment() {
		codec = new SLCodec();
		ontology = VacuumWorldOntology.getInstance();
		world = new VacuumWorld();
		world.show();
	}
	
	public void setup() {
		
		getContentManager().registerLanguage(codec);
		getContentManager().registerOntology(ontology);		
		
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
					System.out.println(msgRx.getContent());
					// Message received. Process it
					ACLMessage reply = msgRx.createReply();
					ContentManager contentManager = myAgent.getContentManager();					
//					try {
//						Action action = (Action) contentManager.extractContent(msgRx);
//					} catch (UngroundedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					} catch (CodecException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					} catch (OntologyException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
					
				} else {
					block();
				}
			}
			
		});
		
	}

}
