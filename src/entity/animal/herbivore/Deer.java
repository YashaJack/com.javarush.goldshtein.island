package entity.animal.herbivore;

import entity.Location;
import entity.animal.Animal;

public class Deer extends Herbivore {
    public Deer(Location location) {
        super("Олень", 300, 4, 50, location);
    }

    @Override
    public void reproduce() {
        super.reproduce();
    }
}