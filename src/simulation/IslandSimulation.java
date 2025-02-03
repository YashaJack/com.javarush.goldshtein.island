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

public class IslandSimulation {
        private final Island island;
        private final SimulationScheduler scheduler;

        public IslandSimulation() {
            this.island = new Island(SimulationConfig.ISLAND_WIDTH, SimulationConfig.ISLAND_HEIGHT);
            IslandInitializer.populateIsland(island);
            this.scheduler = new SimulationScheduler(this, SimulationConfig.SIMULATION_CYCLE_TIME);
        }

    public void start() {
        System.out.println("🌍 Остров готов, запускаем симуляцию...");
        StatisticsManager.printStatistics(island);
    }

    public void growPlants() {
        synchronized (island) {
            System.out.println("🌱 Растения растут...");

            Random random = new Random();
            int newPlants = random.nextInt(100) + 1;

            for (int i = 0; i < newPlants; i++) {
                int x = random.nextInt(island.getWidth());
                int y = random.nextInt(island.getHeight());
                Location location = island.getLocation(x, y);

                if (location.getPlants().size() < 200) {
                    location.addPlant(new Plant());
                    System.out.println("🌿 Новое растение выросло в клетке (" + x + "," + y + ")");
                }
            }
        }
    }

    public void updateAnimals() {
        synchronized (island) {
            System.out.println("🐾 Обновление состояния животных...");

            List<Animal> deadAnimals = new ArrayList<>();

            for (int x = 0; x < island.getWidth(); x++) {
                for (int y = 0; y < island.getHeight(); y++) {
                    Location location = island.getLocation(x, y);
                    List<Animal> animals = new ArrayList<>(location.getAnimals());

                    for (Animal animal : animals) {
                        System.out.println("🔄 " + animal.getName() + " в клетке (" + x + "," + y + ")");

                        animal.updateHunger(); // - сытость

                        if (animal.getHungerLevel() <= 0) {
                            deadAnimals.add(animal);
                            continue;
                        }

                        animal.eat();
                        animal.move(island);

                        if (Math.random() < 0.1) {
                            animal.reproduce();
                        }
                    }
                }
            }

            for (Animal animal : deadAnimals) {
                animal.getLocation().getAnimals().remove(animal);
                System.out.println("💀 " + animal.getName() + " умер от голода.");
            }
        }
    }

        public void printStatistics() {
            StatisticsManager.printStatistics(island);
        }

        public void stop() {
            scheduler.stop();
            System.out.println("🚫 Симуляция завершена.");
        }

        public static void main(String[] args) {
            IslandSimulation simulation = new IslandSimulation();
            simulation.start();
        }
    }