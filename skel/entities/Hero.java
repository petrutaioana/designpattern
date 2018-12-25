package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

import game.World;

public abstract class Hero {

	protected String name;
	protected List<Treasure> inventory;
	protected int posx, posy;

	/* Hero actions */
	public void move(Direction direction) {
		//System.out.println(posx + " " + posy);

		World world = World.getInstance();
		world.getMap()[posx][posy] = world.EMPTY_SPOT;
		switch(direction) {
		case E:
			posy = (posy + 1) % World.MAP_SIZE;
			break;
		case W:
			posy = (posy + World.MAP_SIZE -1) % World.MAP_SIZE;
			break;
		case S:
			posx = (posx + 1) % World.MAP_SIZE;
			break;
		case N:
			posx = (posx + World.MAP_SIZE -1) % World.MAP_SIZE;
			break;
		
		}
	
		//TODO the world must be informed in order to update its observers about this move
		world.getMap()[posx][posy] = world.HERO_SPOT;
        world.update();
	}

	public void collect(Treasure treasure) {
		if(inventory == null) {
			inventory = new ArrayList<>();
		}
		inventory.add(treasure);
	}

	public abstract void attack();


	/* Getters and setters */
	public int getPosy() {
		return posy;
	}

	public void setPosy(int posy) {
		this.posy = posy;
	}

	public int getPosx() {
		return posx;
	}

	public void setPosx(int posx) {
		this.posx = posx;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public enum Direction{
		S, N, E, W
	}
	
	public enum Type {
		WARRIOR, MAGE, PRIEST
	}

	public List<Treasure> getInventory() {
		return inventory;
	}

	public void setInventory(List<Treasure> inventory) {
		this.inventory = inventory;
	}

	@Override
	public String toString() {
		return "Hero{" +
				"name='" + name + '\'' +
				", inventory=" + inventory +
				", posx=" + posx +
				", posy=" + posy +
				'}';
	}
}


