package simulation;

import config.SimulationConfig;
import entity.Island;
import entity.Location;
import entity.animal.Animal;
import entity.plant.Plant;
import managers.IslandInitializer;
import managers.SimulationScheduler;
import managers.StatisticsManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class IslandSimulation {
    private final Island island;
    private final SimulationScheduler scheduler;
    private final ExecutorService animalExecutor;

    public IslandSimulation() {
        this.island = new Island(SimulationConfig.ISLAND_WIDTH, SimulationConfig.ISLAND_HEIGHT);
        IslandInitializer.populateIsland(island);
        this.scheduler = new SimulationScheduler(this, SimulationConfig.SIMULATION_CYCLE_TIME);
        this.animalExecutor = Executors.newFixedThreadPool(10);
    }

    public void start() {
        System.out.println("🌍 Остров готов, запускаем симуляцию...");
        StatisticsManager.printStatistics(island);

        for (Location location : island.getLocations()) {
            List<Animal> animalsCopy = new ArrayList<>(location.getAnimals()); // Создаем копию списка
            for (Animal animal : animalsCopy) {
                animalExecutor.submit(animal); // Запускаем животное в поток
            }
        }
    }

    public void growPlants() {
        for (Location location : island.getLocations()) {
            if (location.getPlants().size() < Location.MAX_PLANTS_PER_CELL) {
                location.addPlant(new Plant(1.0));
            }
        }
    }

    public void updateAnimals() {
        for (Location location : island.getLocations()) {
            for (Animal animal : new ArrayList<>(location.getAnimals())) {
                animal.run();
            }
        }
    }

    public void printStatistics() {
        StatisticsManager.printStatistics(island);
    }

    public void stop() {
        scheduler.stop();
        animalExecutor.shutdownNow();
    }

    public static void main(String[] args) {
        IslandSimulation simulation = new IslandSimulation();
        simulation.start();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("\nЗавершаем симуляцию...");
            simulation.stop();
        }));
    }
}
