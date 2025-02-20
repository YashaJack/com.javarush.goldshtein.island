package entity.animal.herbivore;

import entity.Island;
import entity.Location;
import entity.animal.Animal;

public class Caterpillar extends Herbivore {
    public Caterpillar(Location location, Island island) {
        super("Гусеница", 0.01, 0, 0, location, island);
    }
}