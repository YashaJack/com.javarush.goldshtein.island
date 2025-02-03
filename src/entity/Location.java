package entity;

import entity.animal.Animal;
import entity.animal.herbivore.*;
import entity.animal.predator.*;
import entity.plant.Plant;

import java.util.*;

public class Location {
    private final int x;
    private final int y;
    private List<Animal> animals = new ArrayList<>();
    private List<Plant> plants = new ArrayList<>();
    private static final int MAX_ANIMALS_PER_CELL = 500;
    private static final int MAX_PLANTS_PER_CELL = 200;

    private static final Map<Class<? extends Animal>, Integer> maxAnimalsPerType = new HashMap<>();

    static {
        maxAnimalsPerType.put(Wolf.class, 30);
        maxAnimalsPerType.put(Boa.class, 30);
        maxAnimalsPerType.put(Fox.class, 30);
        maxAnimalsPerType.put(Bear.class, 5);
        maxAnimalsPerType.put(Eagle.class, 20);
        maxAnimalsPerType.put(Horse.class, 20);
        maxAnimalsPerType.put(Deer.class, 20);
        maxAnimalsPerType.put(Rabbit.class, 150);
        maxAnimalsPerType.put(Mouse.class, 500);
        maxAnimalsPerType.put(Goat.class, 140);
        maxAnimalsPerType.put(Sheep.class, 140);
        maxAnimalsPerType.put(Boar.class, 50);
        maxAnimalsPerType.put(Buffalo.class, 10);
        maxAnimalsPerType.put(Duck.class, 200);
        maxAnimalsPerType.put(Caterpillar.class, 1000);
    }

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // Метод получения максимального количества животных этого вида в клетке
    public int getMaxAnimalsPerType(Class<? extends Animal> animalClass) {
        return maxAnimalsPerType.getOrDefault(animalClass, Integer.MAX_VALUE);
    }

    public int getMaxAnimalsPerCell() {
        return MAX_ANIMALS_PER_CELL;
    }


    public List<Animal> getAnimals() {
        return animals;
    }


    public List<Plant> getPlants() {
        return plants;
    }

    // Добавление животного в клетку с проверкой лимита
    public void addAnimal(Animal animal) {
        int currentCount = (int) animals.stream().filter(a -> a.getClass().equals(animal.getClass())).count();
        int maxAllowed = getMaxAnimalsPerType(animal.getClass());

        if (animals.size() < MAX_ANIMALS_PER_CELL && currentCount < maxAllowed) {
            animals.add(animal);
        } else {
            System.out.println("❌ " + animal.getName() + " не может войти, клетка (" + x + "," + y + ") переполнена.");
        }
    }

    // Удаление животного из клетки
    public void removeAnimal(Animal animal) {
        animals.remove(animal);
    }

    // Добавление растения с проверкой лимита
    public void addPlant(Plant plant) {
        if (plants.size() < MAX_PLANTS_PER_CELL) {
            plants.add(plant);
        } else {
            System.out.println("❌ Клетка (" + x + "," + y + ") переполнена растениями.");
        }
    }

    //Удаление растения
    public void removePlant(Plant plant) {
        plants.remove(plant);
    }
}