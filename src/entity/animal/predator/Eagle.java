package entity.animal.predator;

import entity.Location;
import entity.animal.Animal;

public class Eagle extends Predator {
    public Eagle(Location location) {
        super("Орел", 6, 3, 1, location);
    }

    @Override
    public void reproduce() {
        super.reproduce();
    }
}