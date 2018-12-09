package entities;

import java.util.Observable;

//extra attribute: knowledge
public class Priest extends Hero {

    public int knowledge;

    public Priest(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void attack() {
        System.out.println("I'm a priest!\n");
    }

}
