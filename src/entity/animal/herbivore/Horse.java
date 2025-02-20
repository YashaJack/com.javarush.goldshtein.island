package entity.animal.herbivore;

import entity.Island;
import entity.Location;
import entity.animal.Animal;

public class Horse extends Herbivore {
    public Horse(Location location, Island island) {
        super("Лошадь", 400, 4, 60, location, island);
    }
}