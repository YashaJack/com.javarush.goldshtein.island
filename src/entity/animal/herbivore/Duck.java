package entity.animal.herbivore;

import entity.Island;
import entity.Location;
import entity.animal.Animal;

public class Duck extends Herbivore {
    public Duck(Location location, Island island) {
        super("Утка", 1, 4, 0.15, location, island);
    }
}