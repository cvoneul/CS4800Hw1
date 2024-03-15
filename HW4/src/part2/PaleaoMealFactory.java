package part2;

public class PaleaoMealFactory extends MealFactory {

    private static PaleaoMealFactory instance;

    private PaleaoMealFactory() {}

    public static PaleaoMealFactory getInstance() {
        if(instance == null) {
            instance = new PaleaoMealFactory();
        }
        return instance;
    }

    @Override
    public Meal getMeal() {
        String carb = new PaleoCarb().generateCarb();
        String protein = new PaleoProtein().generateProtein();
        String fat = new PaleoFat().generateFat();

        return new Meal(carb, protein, fat);
    }
}
