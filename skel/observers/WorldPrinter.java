package observers;

/**
 * Observer that prints the game's world (the map with all the treasures,
 * heroes, obstacles)
 */

import entities.Hero;
import entities.Treasure;
import game.World;

import java.util.Observable;
import java.util.Observer;

public class WorldPrinter implements Observer {

    @Override


    public void update(Observable o, Object arg) {
        // TODO obtain the World's map, treasures and heroes
        // print the map
        // e.g.
        // 0  1  1  1  0
        // H  T  0  1  0
        // 0  0  T  0  0
        // 0  0  0  T  T
        // 0  T  0  0  0
        // T - treasure, H - hero, 1 - obstacle
        World worldUpdate = (World) o;

        for (int i = 0; i < worldUpdate.getMap().length; i++) {
            for (int j = 0; j < worldUpdate.getMap().length; j++) {
                if (worldUpdate.getMap()[i][j] == worldUpdate.TREASURE_SPOT) {
                    System.out.print("T ");
                } else if(worldUpdate.getMap()[i][j] == worldUpdate.HERO_SPOT) {
                    System.out.print("H ");
                } else System.out.print(worldUpdate.getMap()[i][j] + " ");
            }
            System.out.println();
        }


    }

}