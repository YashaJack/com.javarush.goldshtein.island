package entity.animal.predator;

import entity.Island;
import entity.Location;

public class Wolf extends Predator {
    public Wolf(Location location, Island island) {
        super("Волк", 50.0, 3, 8.0, location, island);
    }
}