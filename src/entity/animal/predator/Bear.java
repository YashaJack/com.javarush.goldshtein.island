package entity.animal.predator;


import entity.Island;
import entity.Location;
import entity.animal.Animal;

public class Bear extends Predator {
    public Bear(Location location, Island island) {
        super("Медведь", 500, 2, 80, location, island);
    }
}