package entity.animal.herbivore;

import entity.Location;
import entity.animal.Animal;

public class Sheep extends Herbivore {
    public Sheep(Location location) {
        super("Овца", 70, 3, 15, location);
    }

    @Override
    public void reproduce() {
        super.reproduce();
    }
}
