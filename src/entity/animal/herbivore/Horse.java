package entity.animal.herbivore;

import entity.Location;
import entity.animal.Animal;

public class Horse extends Herbivore {
    public Horse(Location location) {
        super("Лошадь", 400, 4, 60, location);
    }

    @Override
    public void reproduce() {
        super.reproduce();
    }
}