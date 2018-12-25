package entities;

import java.util.Observable;

//additional attack: magicAttack
public class Mage extends Hero {

    public Mage(String name) {
        this.name = name;
        this.posx = 0;
        this.posy = 0;
    }

    @Override
    public void attack() {
        System.out.println("I'm a mage!\n");
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
