package agents;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import behaviors.EnvironmentBehavior;

import ontology.VacuumWorldOntology;
import ontology.action.Executable;
import ontology.action.Forward;
import ontology.action.Suck;
import ontology.action.Turn;
import ontology.predicate.Facing;
import jade.content.ContentElement;
import jade.content.ContentElementList;
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

public class Environment extends Agent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private VacuumWorld world;
	private Codec codec;
	private Ontology ontology;
	private boolean goalFinished;

	public Environment() {
		setGoalFinished(false);
		codec = new SLCodec();
		ontology = VacuumWorldOntology.getInstance();
		setWorld(new VacuumWorld(this));
		getWorld().show();
	}

	public VacuumWorld getWorld() {
		return world;
	}

	public void setWorld(VacuumWorld world) {
		this.world = world;
	}
	
	public void setup() {
		getContentManager().registerLanguage(codec);
		getContentManager().registerOntology(ontology);
		addBehaviour(new EnvironmentBehavior());
	}

	public boolean isGoalFinished() {
		return goalFinished;
	}

	public void setGoalFinished(boolean goalFinished) {
		this.goalFinished = goalFinished;
	}

}
