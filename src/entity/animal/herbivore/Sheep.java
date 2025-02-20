package entity.animal.herbivore;

import entity.Island;
import entity.Location;
import entity.animal.Animal;

public class Sheep extends Herbivore {
    public Sheep(Location location, Island island) {
        super("Овца", 70, 3, 15, location, island);
    }
}