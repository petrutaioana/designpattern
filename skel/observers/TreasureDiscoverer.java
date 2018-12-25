package observers;

import entities.Hero;
import entities.Treasure;
import game.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Observer that prints the lore of a treasure when a hero discovers it.
 *
 */
public class TreasureDiscoverer implements Observer {

		
	public void update(Observable o, Object arg) {
		// TODO
		// check if any hero is in an area containing a treasure
		// print some message
		// remove treasure from map and 
		// add to specific hero's inventory
		Hero luckyOne;
		World worldUpdate = (World) o;
		List<Treasure> del = new ArrayList<>();
		for(Hero h : worldUpdate.getParty()) {
			for(Treasure t : worldUpdate.getTreasures()) {
				if(h.getPosx() == t.getPosx() && h.getPosy() == t.getPosy()) {
					luckyOne = h;
					System.out.println("Here's looking at you, " + luckyOne.getName() + " !");
					h.collect(t);
					del.add(t);
					//System.out.println(h.getPosx() + " " + h.getPosy() + " " + h.getInventory());
					worldUpdate.getMap()[h.getPosx()][h.getPosy()] = worldUpdate.EMPTY_SPOT;

				}
			}
		}
		worldUpdate.getTreasures().remove(del);
		
	}
}
