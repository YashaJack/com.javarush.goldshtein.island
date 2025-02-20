package entity.animal.herbivore;

import entity.Island;
import entity.Location;

public class Deer extends Herbivore {
    public Deer(Location location, Island island) {
        super("Олень", 150.0, 4, 20.0, location, island);
    }
}