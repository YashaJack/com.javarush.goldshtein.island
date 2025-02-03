package entity.animal.predator;


import entity.Location;
import entity.animal.Animal;

public class Boa extends Predator {
    public Boa(Location location) {
        super("Удав", 15, 1, 3, location);
    }

    @Override
    public void reproduce() {
        super.reproduce();
    }
}