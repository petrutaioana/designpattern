package entities;

import java.util.Observable;

//extra attribute: damage (aka strength)
public class Warrior extends Hero {
    public int damage;

    public Warrior(String name) {
        this.name = name;
    }
    @Override
    public void attack() {
        System.out.println("I'm a warrior!\n");
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
