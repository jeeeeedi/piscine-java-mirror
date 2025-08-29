public class BaseRaclette implements Raclette {
    private int calories;
    private String ingredients;

    public BaseRaclette() {
        this.calories = 1000;
        this.ingredients = "Patate, fromage à raclette";
    }

    @Override
    public int getCalories() {
        return this.calories;
    }

    @Override
    public String getIngredients() {
        return this.ingredients;
    }
}
