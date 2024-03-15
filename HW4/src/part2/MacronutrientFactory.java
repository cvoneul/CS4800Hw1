package part2;

public class MacronutrientFactory {

    private static MacronutrientFactory instance;

    private MacronutrientFactory() {}

    public static MacronutrientFactory getInstance() {
        if(instance == null) {
            instance = new MacronutrientFactory();
        }
        return instance;
    }

    public MealFactory createMealFactory(String mealPlan) throws Exception {
        switch(mealPlan) {
            case "No Restriction":
                return NoRestrictionMealFactory.getInstance();
            case "Paleo":
                return PaleaoMealFactory.getInstance();
            case "Vegan":
                return VeganMealFactory.getInstance();
            case "Nut Allergy":
                return NutAllergyMealFactory.getInstance();
            default:
                throw new Exception("Invalid diet plan");
        }
    }
}
