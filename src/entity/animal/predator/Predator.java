package entity.animal.predator;

import entity.Island;
import entity.animal.Animal;
import entity.Location;
import entity.animal.herbivore.Duck;
import entity.animal.herbivore.Mouse;
import entity.animal.herbivore.Rabbit;

import java.util.*;

public abstract class Predator extends Animal {
    private static final Random random = new Random();

    private static final Map<Class<? extends Animal>, Integer> foodProbability = new HashMap<>();

    static {
        foodProbability.put(Rabbit.class, 60);
        foodProbability.put(Mouse.class, 80);
        foodProbability.put(Duck.class, 40);
    }

    public Predator(String name, double weight, int speed, double foodNeeded, Location location, Island island) {
        super(name, weight, speed, foodNeeded, location, island);
    }

    @Override
    public void eat() {
        Iterator<Animal> iterator = location.getAnimals().iterator();

        while (iterator.hasNext()) {
            Animal prey = iterator.next();
            if (foodProbability.containsKey(prey.getClass())) {
                int chance = foodProbability.get(prey.getClass());
                if (random.nextInt(100) < chance) {
                    iterator.remove(); // Безопасное удаление
                    hungerLevel = foodNeeded;
                    System.out.println(name + " съел " + prey.getName() + " и насытился!");
                    return;
                }
            }
        }
        System.out.println(name + " не нашел еды и остается голодным.");
    }
}