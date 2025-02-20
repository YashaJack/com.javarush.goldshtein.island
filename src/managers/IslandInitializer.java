package managers;

import config.SimulationConfig;
import entity.Island;
import entity.Location;
import entity.animal.*;
import entity.animal.herbivore.*;
import entity.animal.predator.*;
import entity.plant.Plant;

import java.util.*;

public class IslandInitializer {
    public static void populateIsland(Island island) {
        System.out.println("Заполняем остров животными и растениями...");

        Random random = new Random();

        Map<Class<? extends Animal>, Integer> maxAnimalsPerCell = new HashMap<>();
        maxAnimalsPerCell.put(Wolf.class, 30);
        maxAnimalsPerCell.put(Fox.class, 30);
        maxAnimalsPerCell.put(Bear.class, 5);
        maxAnimalsPerCell.put(Eagle.class, 20);
        maxAnimalsPerCell.put(Boa.class, 30);
        maxAnimalsPerCell.put(Horse.class, 20);
        maxAnimalsPerCell.put(Deer.class, 20);
        maxAnimalsPerCell.put(Rabbit.class, 150);
        maxAnimalsPerCell.put(Mouse.class, 500);
        maxAnimalsPerCell.put(Goat.class, 140);
        maxAnimalsPerCell.put(Sheep.class, 140);
        maxAnimalsPerCell.put(Boar.class, 50);
        maxAnimalsPerCell.put(Buffalo.class, 10);
        maxAnimalsPerCell.put(Duck.class, 200);
        maxAnimalsPerCell.put(Caterpillar.class, 1000);

        for (Map.Entry<Class<? extends Animal>, Integer> entry : maxAnimalsPerCell.entrySet()) {
            Class<? extends Animal> animalClass = entry.getKey();
            int maxOnCell = entry.getValue();
            int count = random.nextInt(maxOnCell) + 1;

            for (int i = 0; i < count; i++) {
                int x = random.nextInt(island.getWidth());
                int y = random.nextInt(island.getHeight());
                Location location = island.getLocation(x, y);

                try {
                    Animal animal = animalClass
                            .getDeclaredConstructor(Location.class, Island.class)
                            .newInstance(location, island);
                    location.addAnimal(animal);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        int plantCount = random.nextInt(1) + 50;
        for (int i = 0; i < plantCount; i++) {
            int x = random.nextInt(island.getWidth());
            int y = random.nextInt(island.getHeight());
            island.getLocation(x, y).addPlant(new Plant(1));
        }

        System.out.println("✅ Все животные и растения добавлены.");
    }
}