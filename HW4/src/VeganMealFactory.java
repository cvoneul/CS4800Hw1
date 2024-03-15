import java.util.Random;

public class VeganMealFactory extends MealFactory {

    private static VeganMealFactory instance;

    private VeganMealFactory() {}

    public static VeganMealFactory getInstance() {
        if(instance == null) {
            instance = new VeganMealFactory();
        }
        return instance;
    }

    @Override
    public Meal getMeal() {
        String carb = new VeganCarb().generateCarb();
        String protein = new VeganProtein().generateProtein();
        String fat = new VeganFat().generateFat();

        return new Meal(carb, protein, fat);
    }
}
