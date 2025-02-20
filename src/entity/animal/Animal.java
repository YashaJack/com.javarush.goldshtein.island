package entity.animal;

import entity.Island;
import entity.Location;
import entity.plant.Plant;

import java.util.List;
import java.util.Random;

public abstract class Animal implements Runnable {
    protected String name;
    protected double weight;
    protected int speed;
    protected double foodNeeded;
    protected double hungerLevel;
    protected Location location;
    protected final Island island;
    private static final Random random = new Random();

    public Animal(String name, double weight, int speed, double foodNeeded, Location location, Island island) {
        this.name = name;
        this.weight = weight;
        this.speed = speed;
        this.foodNeeded = foodNeeded;
        this.hungerLevel = foodNeeded;
        this.location = location;
        this.island = island;
    }

    public double getHungerLevel() {
        return hungerLevel;
    }

    public String getName() {
        return name;
    }

    public void reproduce() {
        if (random.nextDouble() < 0.2) { // 20% шанс размножения
            try {
                Animal offspring = this.getClass()
                        .getDeclaredConstructor(Location.class, Island.class)
                        .newInstance(location, island);
                location.addAnimal(offspring);
                System.out.println(name + " размножился! Новый " + offspring.getName() + " появился.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void move() {
        List<Location> neighbors = location.getNeighbors(island);
        if (!neighbors.isEmpty() && random.nextDouble() < 0.5) {
            Location newLocation = neighbors.get(random.nextInt(neighbors.size()));
            location.removeAnimal(this);
            newLocation.addAnimal(this);
            this.location = newLocation;
        }
    }

    public void eat() {
        List<Plant> plants = location.getPlants();
        if (!plants.isEmpty() && hungerLevel < foodNeeded) {
            Plant plant = plants.get(0);
            location.removePlant(plant);
            hungerLevel = Math.min(foodNeeded, hungerLevel + plant.getNutritionValue());
        }
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            move();
            eat();
            reproduce();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
//@Override
//public void run() {
//    while (!Thread.currentThread().isInterrupted()) {
//        System.out.println(name + " работает в потоке " + Thread.currentThread().getName());
//        move();
//        eat();
//        reproduce();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//        }
//    }
//}