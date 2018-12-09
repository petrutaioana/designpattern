package game;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import entities.Hero;
import entities.Treasure;
import factories.TreasureFactory;

public class World extends Observable {

    public static final int MAP_SIZE = 5;
    public static final int EMPTY_SPOT = 0;
    public static final int OBSTACLE_SPOT = 1;
    public static final int HERO_SPOT = 2;
    public static final int TREASURE_SPOT = 3;

    private ArrayList<Hero> party = new ArrayList<Hero>();
    //observatorii sunt party ul
    private ArrayList<Treasure> treasures = new ArrayList<Treasure>();
    private boolean adventureStarted = false;
    public ArrayList<Observer> obs = new ArrayList<>();

    private int[][] map = new int[][]
            {
                    {0, 0, 1, 1, 0},
                    {0, 0, 0, 1, 0},
                    {0, 0, 0, 0, 0},
                    {0, 0, 1, 0, 0},
                    {0, 0, 0, 0, 0}
            };

    private static World world = null;

    private World() {
    }

    public static World getInstance() {
        if (world == null)
            world = new World();
        return world;
    }

    public void update() {

        this.setChanged();
        this.notifyObservers();
    }

    public void populateTreasures(int numTreasures) {

        if (numTreasures > MAP_SIZE * MAP_SIZE) {
            System.err.println("Too many treasures");
            return;
        }

        //TODO place treasures randomly on the map

        for (int i = 0; i < map.length; i++) {
            for(int j = 0; j < map.length; j++) {
                if(map[i][j] == 1) {
                    treasures.add(new TreasureFactory().createTreasure());
                }
            }
        }
    }

    public void removeTreasure(Treasure t) {
        treasures.remove(t);
    }

    public ArrayList<Hero> getParty() {
        return party;
    }

    public void setParty(ArrayList<Hero> party) {
        this.party = party;
    }

    public ArrayList<Treasure> getTreasures() {
        return treasures;
    }

    public void setTreasures(ArrayList<Treasure> treasures) {
        this.treasures = treasures;
    }

    public boolean isAdventureStarted() {
        return adventureStarted;
    }

    public void setAdventureStarted(boolean adventureStarted) {
        this.adventureStarted = adventureStarted;
    }

    public int[][] getMap() {
        return map;
    }

    @Override
    public String toString() {
        return "World{" +
                "party=" + party +
                '}';
    }
}