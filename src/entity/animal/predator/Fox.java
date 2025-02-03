package entity.animal.predator;

import entity.Location;
import entity.animal.Animal;

public class Fox extends Predator {
    public Fox(Location location) {
        super("Лиса", 8, 2, 2, location);
    }

    @Override
    public void reproduce() {
        super.reproduce();
    }
}