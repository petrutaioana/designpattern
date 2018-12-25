package entities;


import game.World;

import java.util.Random;

/**
 * Class representing a "treasure". The map contains treasures that the heroes
 * will collect.
 * <p>
 * The treasures have a special story(lore) associated with them.
 */
public class Treasure {

    protected String name;
    protected String lore;
    protected int posx, posy;

    public Treasure(String name, String lore) {
        this.name = name;
        this.lore = lore;
    }

    public void setCoordinates(World map) {
		this.posx = new Random().nextInt(map.getMap().length);
		this.posy = new Random().nextInt(map.getMap().length);
    }

    public int getPosx() {
        return posx;
    }

    public void setPosx(int posx) {
        this.posx = posx;
    }

    public int getPosy() {
        return posy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLore() {
        return lore;
    }

    public void setLore(String lore) {
        this.lore = lore;
    }

    public void setPosy(int posy) {
        this.posy = posy;
    }

    @Override
    public String toString() {
        return "Treasure{" +
                "name='" + name + '\'' +
                ", lore='" + lore + '\'' +
                ", posx=" + posx +
                ", posy=" + posy +
                '}';
    }
}