package entity.animal.herbivore;

import entity.Location;
import entity.animal.Animal;

public class Rabbit extends Herbivore {
    public Rabbit(Location location) {
        super("Кролик", 2, 2, 0.45, location);
    }

    @Override
    public void reproduce() {
        super.reproduce();
    }
}