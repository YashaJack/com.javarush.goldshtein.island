package entity.animal.predator;

import entity.Location;
import entity.animal.Animal;

public class Wolf extends Animal {
    public Wolf(Location location) {
        super("Wolf", 50, 3, 8, location);
    }

    @Override
    public void reproduce() {
        super.reproduce();
    }
}