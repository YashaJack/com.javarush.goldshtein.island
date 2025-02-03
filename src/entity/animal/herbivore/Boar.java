package entity.animal.herbivore;

import entity.Location;

public class Boar extends Herbivore {
    public Boar(Location location) {
        super("Кабан", 400, 2, 50, location);
    }

    @Override
    public void reproduce() {
        System.out.println("Кабан нашел себе пару!");
    }
}