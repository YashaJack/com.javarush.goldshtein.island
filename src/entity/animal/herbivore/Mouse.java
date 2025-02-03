package entity.animal.herbivore;

import entity.Location;
import entity.animal.Animal;

public class Mouse extends Herbivore {
    public Mouse(Location location) {
        super("Мышь", 0.05, 1, 0.01, location);
    }

    @Override
    public void reproduce() {
        super.reproduce();
    }
}
