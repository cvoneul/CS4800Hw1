
public class MealBuilder {

    public static void main(String[] args) throws Exception {

        Customer bob = new Customer("Bob", "No Restriction");
        Customer alice = new Customer("Alice", "Paleo");
        Customer jack = new Customer("Jack", "Paleo");
        Customer adam = new Customer("Adam", "Nut Allergy");
        Customer jill = new Customer("Jill", "Nut Allergy");
        Customer chris = new Customer("Chris", "Vegan");


        printMeal(bob);
        printMeal(alice);
        printMeal(jack);
        printMeal(adam);
        printMeal(jill);
        printMeal(chris);
    }

    public static void printMeal(Customer c) throws Exception {
        MealFactory mealFactory = MacronutrientFactory.getInstance().createMealFactory(c.getDietPlan());
        System.out.println("\n meal plan: " + mealFactory.getClass().getName()
                + "\n\t meal:");
        System.out.println("\t\t" + mealFactory.getMeal().toString());
    }

}