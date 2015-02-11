package agents;

import behaviors.VacuumBehavior;
import ontology.VacuumWorldOntology;
import jade.content.lang.Codec;
import jade.content.lang.sl.SLCodec;
import jade.content.onto.Ontology;
import jade.core.AID;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;

public class VacuumAgent extends Agent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Ontology  ontology;
	private Codec codec;
	
	public VacuumAgent() {
		ontology = VacuumWorldOntology.getInstance();
		codec = new SLCodec();
	}
	
	public void setup() {
		getContentManager().registerLanguage(codec);
		getContentManager().registerOntology(ontology);
		addBehaviour(new VacuumBehavior());
	}

}
