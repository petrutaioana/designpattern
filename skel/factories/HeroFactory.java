package factories;

import entities.Hero;
import entities.Mage;
import entities.Priest;
import entities.Warrior;

public class HeroFactory {
    //TODO implement me


    private static HeroFactory instance = null;

    private HeroFactory(){
    }

    public static HeroFactory getInstance() {
        if (instance == null) {
            instance = new HeroFactory();
        }
        return instance;
    }
        /**
         *
         * @param type the Hero type
         * @param name
         * @return
         */
        public Hero createHero (Hero.Type type, String name){
            if (type.toString().equals("MAGE")) {
                return new Mage(name);
            } else if (type.toString().equals("PRIEST")) {
                return new Priest(name);
            } else if (type.toString().equals("WARRIOR")) {
                return new Warrior(name);
            }
            return null;
        }
    }
