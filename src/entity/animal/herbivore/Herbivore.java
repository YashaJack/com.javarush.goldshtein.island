package entity.animal.herbivore;

import entity.Island;
import entity.animal.Animal;
import entity.Location;
import entity.plant.Plant;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

public abstract class Herbivore extends Animal {
    private static final Random random = new Random();

    public Herbivore(String name, double weight, int speed, double foodNeeded, Location location, Island island) {
        super(name, weight, speed, foodNeeded, location, island);
    }

    @Override
    public void eat() {
        List<Plant> plants = location.getPlants();

        if (!plants.isEmpty()) {
            plants.remove(0);
            hungerLevel = foodNeeded;
            System.out.println(name + " съел растение и насытился!");
            return;
        }

        if (this instanceof entity.animal.herbivore.Duck) {
            List<Animal> animalsInLocation = location.getAnimals();
            Iterator<Animal> iterator = animalsInLocation.iterator();
            while (iterator.hasNext()) {
                Animal animal = iterator.next();
                if (animal instanceof entity.animal.herbivore.Caterpillar && random.nextInt(100) < 90) {
                    iterator.remove(); // Безопасное удаление
                    hungerLevel = foodNeeded;
                    System.out.println(name + " съел гусеницу и насытился!");
                    return;
                }
            }
        }

        System.out.println(name + " не нашел еды и остается голодным.");
    }
}