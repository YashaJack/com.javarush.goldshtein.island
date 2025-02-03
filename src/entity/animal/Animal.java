package entity.animal;

import entity.Island;
import entity.Location;
import entity.animal.herbivore.Herbivore;
import entity.animal.predator.Predator;
import entity.plant.Plant;

import java.util.List;
import java.util.Random;

public abstract class Animal {
    protected String name;
    protected double weight;
    protected int speed;
    protected double foodNeeded;
    protected double hungerLevel;
    protected Location location;
    private static final Random random = new Random();

    public Animal(String name, double weight, int speed, double foodNeeded, Location location) {
        this.name = name;
        this.weight = weight;
        this.speed = speed;
        this.foodNeeded = foodNeeded;
        this.hungerLevel = foodNeeded; // Начальный запас еды
        this.location = location;
    }

    public double getHungerLevel() {
        return hungerLevel;
    }

    public void reproduce() {
        List<Animal> animalsInLocation = location.getAnimals();

        // есть ли пара
        long count = animalsInLocation.stream()
                .filter(a -> a.getClass().equals(this.getClass()))
                .count();

        if (count < 2) {
            System.out.println("❌ " + name + " не нашел пару для размножения.");
            return;
        }

        // есть ли еда для размножения (не менее 50% от foodNeeded)
        if (hungerLevel < foodNeeded * 0.5) {
            System.out.println("❌ " + name + " слишком голоден для размножения.");
            return;
        }

        // Проверяем, не переполнена ли клетка
        if (location.getAnimals().size() >= location.getMaxAnimalsPerCell()) {
            System.out.println("❌ " + name + " не размножился, клетка переполнена.");
            return;
        }

        try {
            Animal baby = this.getClass().getDeclaredConstructor(Location.class).newInstance(this.location);
            location.addAnimal(baby);
            System.out.println("🐣 Новый " + baby.getName() + " появился в клетке (" + location.getX() + "," + location.getY() + ")!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void eat() {
        List<Plant> plants = location.getPlants();
        List<Animal> animals = location.getAnimals();

        if (this instanceof Herbivore && !plants.isEmpty()) {
            plants.remove(0);
            hungerLevel = foodNeeded;
            System.out.println(name + " съел растение! 🌿");
            return;
        }

        if (this instanceof Predator) {
            for (Animal prey : animals) {
                if (prey != this && Math.random() < 0.5) {
                    location.getAnimals().remove(prey);
                    hungerLevel = foodNeeded;
                    System.out.println(name + " съел " + prey.getName() + "! 🥩");
                    return;
                }
            }
        }

        System.out.println(name + " не нашел еды. ❌");
    }

    public void move(Island island) {
        Random random = new Random();
        int dx = random.nextInt(speed * 2 + 1) - speed;
        int dy = random.nextInt(speed * 2 + 1) - speed;

        int newX = Math.max(0, Math.min(island.getWidth() - 1, location.getX() + dx));
        int newY = Math.max(0, Math.min(island.getHeight() - 1, location.getY() + dy));

        Location newLocation = island.getLocation(newX, newY);

        if (newLocation != location) {
            location.getAnimals().remove(this);
            newLocation.addAnimal(this);
            this.location = newLocation;
            System.out.println("🚶 " + name + " переместился в (" + newX + "," + newY + ")");
        } else {
            System.out.println("❌ " + name + " не смог переместиться.");
        }
    }

    public void updateHunger() {
        hungerLevel -= 1;
        if (hungerLevel <= 0) {
            location.getAnimals().remove(this);
            System.out.println(name + " умер от голода.");
        }
    }

    public Location getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }
}