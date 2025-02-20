package entity.animal.herbivore;

import entity.Island;
import entity.Location;
import entity.animal.Animal;

public class Buffalo extends Herbivore {
    public Buffalo(Location location, Island island) {
        super("Буйвол", 700, 3, 100, location, island);
    }

}
