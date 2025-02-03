package entity.animal.herbivore;

import entity.Location;
import entity.animal.Animal;

public class Goat extends Herbivore {
    public Goat(Location location) {
        super("Коза", 60, 3, 10, location);
    }

    @Override
    public void reproduce() {
        super.reproduce();
    }
}