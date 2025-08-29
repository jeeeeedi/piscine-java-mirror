public class WithColdMeats extends RacletteDecorator {
    private final Raclette decoratedRaclette;

    public WithColdMeats(Raclette raclette) {
        super(raclette);
        decoratedRaclette = raclette;
    }

    @Override
    public int getCalories() {
        return super.getCalories() + 350; // Add calories for cold meats
    }

    @Override
    public String getIngredients() {
        return super.getIngredients() + ", charcuterie";
    }

    @Override
    public String toString() {
        return getIngredients() + " pour " + getCalories() + " calories";
    }
}
