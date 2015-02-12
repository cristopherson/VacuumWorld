package agents;

import java.util.Iterator;

import ontology.VacuumWorldOntology;
import ontology.action.Turn;
import ontology.predicate.Facing;
import jade.content.ContentElement;
import jade.content.ContentElementList;
import jade.content.ContentManager;
import jade.content.Predicate;
import jade.content.lang.Codec;
import jade.content.lang.Codec.CodecException;
import jade.content.lang.sl.SLCodec;
import jade.content.onto.Ontology;
import jade.content.onto.OntologyException;
import jade.content.onto.UngroundedException;
import jade.content.onto.basic.Action;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.domain.FIPANames.ContentLanguage;
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
					
					msgRx.setLanguage("fipa-sl");
					msgRx.setOntology("vacuum-ontology");
					
					ContentManager contentManager = myAgent.getContentManager();					
					try {
						ContentElementList elementList = (ContentElementList) contentManager.extractContent(msgRx);
						Iterator<ContentElement> element = elementList.iterator();						
						
						while(element.hasNext()) {
							ContentElement contentElement = element.next();
							
							if(contentElement.getClass() == Action.class) {
								Action action = (Action)contentElement;
								Turn turnAction = (Turn)action.getAction();
								System.out.println("Info " + turnAction.getVacuum().getDirection());		
							} else if (contentElement.getClass() == Facing.class){
								Facing facingPredicate = (Facing) contentElement;								
								System.out.println("Info " + facingPredicate.getIsFacing());
							}
						}
						
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
					
				} else {
					block();
				}
			}
			
		});
		
	}

}
