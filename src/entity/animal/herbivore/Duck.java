package entity.animal.herbivore;

import entity.Location;
import entity.animal.Animal;

public class Duck extends Herbivore {
    public Duck(Location location) {
        super("Утка", 1, 4, 0.15, location);
    }

    @Override
    public void reproduce() {
        super.reproduce();
    }
}