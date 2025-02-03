package managers;

import entity.Island;
import entity.animal.Animal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatisticsManager {
    public static void printStatistics(Island island) {
        synchronized (island) {
            Map<String, Integer> animalStats = new HashMap<>();
            int totalPlants = 0;

            for (int x = 0; x < island.getWidth(); x++) {
                for (int y = 0; y < island.getHeight(); y++) {
                    List<Animal> animals = island.getLocation(x, y).getAnimals();
                    for (Animal animal : animals) {
                        String name = animal.getClass().getSimpleName();
                        animalStats.put(name, animalStats.getOrDefault(name, 0) + 1);
                    }

                    totalPlants += island.getLocation(x, y).getPlants().size();
                }
            }

            System.out.println("\n📊 === СТАТИСТИКА ОСТРОВА ===");
            for (Map.Entry<String, Integer> entry : animalStats.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
            System.out.println("Растения: " + totalPlants);
            System.out.println("============================\n");

            IslandRenderer.drawIsland(island);
        }
    }
}