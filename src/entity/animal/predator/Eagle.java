package entity.animal.predator;

import entity.Island;
import entity.Location;
import entity.animal.Animal;

public class Eagle extends Predator {
    public Eagle(Location location, Island island) {
        super("Орел", 6, 3, 1, location, island);
    }
}