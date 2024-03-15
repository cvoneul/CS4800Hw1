package part2;

public class NutAllergyMealFactory extends MealFactory {

    private static NutAllergyMealFactory instance;

    private NutAllergyMealFactory() {}

    public static NutAllergyMealFactory getInstance() {
        if(instance == null) {
            instance = new NutAllergyMealFactory();
        }
        return instance;
    }


    @Override
    public Meal getMeal() {
        String carb = new NutAllergyCarb().generateCarb();
        String protein = new NutAllergyProtein().generateProtein();
        String fat = new NutAllergyFat().generateFat();

        return new Meal(carb, protein, fat);
    }
}
