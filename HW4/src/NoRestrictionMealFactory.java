import java.util.Random;

public class NoRestrictionMealFactory extends MealFactory {

    private static NoRestrictionMealFactory instance;

    private NoRestrictionMealFactory() {}

    public static NoRestrictionMealFactory getInstance() {
        if(instance == null) {
            instance = new NoRestrictionMealFactory();
        }
        return instance;
    }

    @Override
    public Meal getMeal() {
        String carb = new Carb().generateCarb();
        String protein = new Protein().generateProtein();
        String fat = new Fat().generateFat();

        return new Meal(carb, protein, fat);
    }
}
