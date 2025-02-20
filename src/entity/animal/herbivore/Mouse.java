package entity.animal.herbivore;

import entity.Island;
import entity.Location;
import entity.animal.Animal;

public class Mouse extends Herbivore {
    public Mouse(Location location, Island island) {
        super("Мышь", 0.05, 1, 0.01, location, island);
    }
}