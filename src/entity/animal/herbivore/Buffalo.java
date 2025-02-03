package entity.animal.herbivore;

import entity.Location;
import entity.animal.Animal;

public class Buffalo extends Herbivore {
    public Buffalo(Location location) {
        super("Буйвол", 700, 3, 100, location);
    }

    @Override
    public void reproduce() {
        super.reproduce();
    }
}
