package entity.animal.herbivore;

import entity.Location;
import entity.animal.Animal;

public class Caterpillar extends Herbivore {
    public Caterpillar(Location location) {
        super("Гусеница", 0.01, 0, 0, location);
    }

    @Override
    public void reproduce() {
        super.reproduce();
    }
}
