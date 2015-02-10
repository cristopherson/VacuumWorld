package agents;

import java.awt.Color;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Grid;
import info.gridworld.world.World;

public class VacuumWorld extends World<Actor> {
	private int gridDimension = 3;
	private int gridSize = gridDimension * gridDimension; 

	public VacuumWorld() {
		Grid<Actor> newGrid = new BoundedGrid<Actor>(gridDimension,
				gridDimension);
		this.setGrid(newGrid);
		
		this.add(this.getRandomEmptyLocation(), new Bug(Color.ORANGE));

		for (int i = 0; i < (gridSize) -  1; i++) {
			int flipCoin = (int)(Math.random() * 2);
			if(flipCoin == 1){
				this.add(this.getRandomEmptyLocation(), new Flower(Color.BLUE));
			}
		}

	}
}
