package entity.animal.herbivore;

import entity.Island;
import entity.Location;
import entity.animal.Animal;

public class Goat extends Herbivore {
    public Goat(Location location, Island island) {
        super("Коза", 60, 3, 10, location, island);
    }
}