public class WithPickles extends RacletteDecorator {
    private final Raclette decoratedRaclette;

    public WithPickles(Raclette raclette) {
        super(raclette);
        decoratedRaclette = raclette;
    }

    @Override
    public int getCalories() {
        return super.getCalories() + 50; // Add calories for pickles
    }

    @Override
    public String getIngredients() {
        return super.getIngredients() + ", cornichons";
    }

    @Override
    public String toString() {
        return getIngredients() + " pour " + getCalories() + " calories";
    }
}
