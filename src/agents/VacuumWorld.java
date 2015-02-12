package agents;

import jade.content.ContentElementList;
import jade.content.ContentManager;
import jade.content.lang.Codec.CodecException;
import jade.content.onto.OntologyException;
import jade.core.AID;
import jade.lang.acl.ACLMessage;

import java.awt.Color;
import java.util.ArrayList;

import ontology.concept.LocationConcept;
import ontology.predicate.Dirt;
import ontology.predicate.Facing;
import ontology.predicate.In;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.world.World;

public class VacuumWorld extends World<Actor> {
	private int gridDimension = 3;
	private int gridSize = gridDimension * gridDimension;
	private Environment env;
	private Bug bugActor;
	private Flower flowerActor = null;
	private Location bugLocation;

	public VacuumWorld(Environment env) {
		Grid<Actor> newGrid = new BoundedGrid<Actor>(gridDimension,
				gridDimension);		
		this.setGrid(newGrid);
		setBugActor(new Bug(Color.ORANGE));
		setBugLocation(new Location(0, 0));
		
		this.add(getBugLocation(), getBugActor());

		for (int i = 0; i < (gridSize) -  1; i++) {
			int flipCoin = (int)(Math.random() * 2);
			if(flipCoin == 1){
				this.add(this.getRandomEmptyLocation(), new Flower(Color.BLUE));
			}
		}
		
		this.env = env;
	}
	
	public void step(){		
		ContentManager contentManager = env.getContentManager();
		ContentElementList cel = new ContentElementList();
		
		ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
		msg.addReceiver(new AID("vacuum", AID.ISLOCALNAME));
		msg.setLanguage("fipa-sl");
		msg.setOntology("vacuum-ontology");
		
		Facing facingPredicate = new Facing();
		facingPredicate.setDirection(getBugActor().getDirection());
		
		In inPredicate = new In();
		inPredicate.setLocation(new LocationConcept(getBugLocation()));
		
		Dirt dirtPredicate = new Dirt();
		dirtPredicate.setIsDirt(flowerActor!=null);		

		cel.add(inPredicate);
		cel.add(facingPredicate);
		cel.add(dirtPredicate);
		
		try {
			contentManager.fillContent(msg, cel);
		} catch (CodecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (OntologyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		env.send(msg);
	}

	public Flower getFlowerActor() {
		return flowerActor;
	}

	public void setFlowerActor(Flower flowerActor) {
		this.flowerActor = flowerActor;
	}

	public Bug getBugActor() {
		return bugActor;
	}

	public void setBugActor(Bug bugActor) {
		this.bugActor = bugActor;
	}

	public Location getBugLocation() {
		return bugLocation;
	}

	public void setBugLocation(Location bugLocation) {
		this.bugLocation = bugLocation;
	}

	public void updateActor(Location newLocation) {		
		this.remove(bugLocation);		
		this.add(newLocation, bugActor);
		bugLocation = newLocation;
		
		if (bugLocation.getCol() == 1 && bugLocation.getRow() == 1 && bugActor.getColor() != Color.BLUE) {
			env.setGoalFinished(true);
		}
	}
}
