package managers;

import entity.Island;
import entity.Location;
import entity.animal.*;
import entity.animal.herbivore.*;
import entity.animal.predator.*;

import java.util.List;

public class IslandRenderer {
    public static void drawIsland(Island island) {
        synchronized (island) {
            System.out.println("\n🌍 Карта острова:");

            for (int y = 0; y < island.getHeight(); y++) {
                for (int x = 0; x < island.getWidth(); x++) {
                    Location location = island.getLocation(x, y);
                    List<Animal> animals = location.getAnimals();

                    if (animals.isEmpty()) {
                        if (!location.getPlants().isEmpty()) {
                            System.out.print("🌿 ");
                        } else {
                            System.out.print("⬜ ");
                        }
                    } else {
                        Animal firstAnimal = animals.get(0);
                        System.out.print(getUnicodeSymbol(firstAnimal) + " ");
                    }
                }
                System.out.println();
            }
        }
    }

    private static String getUnicodeSymbol(Animal animal) {
        if (animal instanceof Wolf) return "🐺";
        if (animal instanceof Fox) return "🦊";
        if (animal instanceof Bear) return "🐻";
        if (animal instanceof Eagle) return "🦅";
        if (animal instanceof Boa) return "🐍";
        if (animal instanceof Horse) return "🐎";
        if (animal instanceof Deer) return "🦌";
        if (animal instanceof Rabbit) return "🐇";
        if (animal instanceof Mouse) return "🐁";
        if (animal instanceof Goat) return "🐐";
        if (animal instanceof Sheep) return "🐑";
        if (animal instanceof Boar) return "🐗";
        if (animal instanceof Buffalo) return "🐃";
        if (animal instanceof Duck) return "🦆";
        if (animal instanceof Caterpillar) return "🐛";
        return "❓";
    }
}