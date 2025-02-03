package entity.animal.predator;


import entity.Location;
import entity.animal.Animal;

public class Bear extends Predator {
    public Bear(Location location) {
        super("Медведь", 500, 2, 80, location);
    }

    @Override
    public void reproduce() {
        super.reproduce();
    }
}