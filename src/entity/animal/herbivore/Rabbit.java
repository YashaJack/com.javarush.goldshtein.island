package entity.animal.herbivore;

import entity.Island;
import entity.Location;

public class Rabbit extends Herbivore {
    public Rabbit(Location location, Island island) {
        super("Кролик", 2.5, 2, 1.0, location, island);
    }
}