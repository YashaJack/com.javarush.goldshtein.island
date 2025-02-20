package entity.plant;

public class Plant {
    private final double nutritionValue;

    public Plant(double nutritionValue) {
        this.nutritionValue = nutritionValue;
    }

    public double getNutritionValue() {
        return nutritionValue;
    }
}