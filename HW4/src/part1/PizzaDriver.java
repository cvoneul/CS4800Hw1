package part1;

public class PizzaDriver {
    public static void main(String[] args) {
        Pizza pizza1 = Pizza.builder("part1.Pizza Hut", Pizza.pizzaSize.large)
                .addTopping(Pizza.Topping.PEPPERONI)
                .addTopping(Pizza.Topping.SAUSAGE)
                .addTopping(Pizza.Topping.HAM)
                .build();
        pizza1.eat();

        Pizza pizza2 = Pizza.builder("part1.Pizza Hut", Pizza.pizzaSize.small)
                .addTopping(Pizza.Topping.OLIVES)
                .addTopping(Pizza.Topping.CHICKEN)
                .build();
        pizza2.eat();



        Pizza pizza3 = Pizza.builder("Little Caesars", Pizza.pizzaSize.medium)
                .addTopping(Pizza.Topping.PEPPERONI)
                .addTopping(Pizza.Topping.SAUSAGE)
                .addTopping(Pizza.Topping.HAM)
                .addTopping(Pizza.Topping.OLIVES)
                .addTopping(Pizza.Topping.CHICKEN)
                .addTopping(Pizza.Topping.SPINACH)
                .addTopping(Pizza.Topping.PESTO)
                .addTopping(Pizza.Topping.MUSHROOMS)
                .build();
        pizza3.eat();


        Pizza pizza4 = Pizza.builder("Little Ceasars", Pizza.pizzaSize.small)
                .addTopping(Pizza.Topping.PEPPERONI)
                .addTopping(Pizza.Topping.SAUSAGE)
                .addTopping(Pizza.Topping.HAM)
                .addTopping(Pizza.Topping.PEPPERS)
                .addTopping(Pizza.Topping.OLIVES)
                .addTopping(Pizza.Topping.BEEF)
                .build();
        pizza4.eat();


        Pizza pizza5 = Pizza.builder("Dominos", Pizza.pizzaSize.small)
                .addTopping(Pizza.Topping.PEPPERONI)
                .build();
        pizza5.eat();


        Pizza pizza6 = Pizza.builder("Dominos", Pizza.pizzaSize.large)
                .addTopping(Pizza.Topping.HAM)
                .addTopping(Pizza.Topping.OLIVES)
                .addTopping(Pizza.Topping.BEEF)
                .build();
        pizza6.eat();

    }
}
