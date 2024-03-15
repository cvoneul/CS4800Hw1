import java.util.ArrayList;

public class Pizza {
    private pizzaSize size;
    private String pizzaChain;
    private ArrayList<Topping> toppings = new ArrayList<Topping>();

    public enum Topping {
        PEPPERONI, SAUSAGE, MUSHROOMS, BACON, ONIONS, EXTRA_CHEESE, PEPPERS, CHICKEN,
        OLIVES, SPINACH, TOMATO_AND_BASIL, BEEF, HAM, PESTO, SPICY_PORK, HAM_AND_PINEAPPLE
    }


    enum pizzaSize {
        large, medium, small;
    }

    public Pizza(String pizzaChain, pizzaSize size, ArrayList<Topping> toppings) {
        this.pizzaChain = pizzaChain;
        this.size = size;
        this.toppings = toppings;
    }

    public static Builder builder(String chain, pizzaSize size) {
        return new Builder(chain, size);
    }

    public void eat() {
        System.out.println("Pizza Chain: " + pizzaChain
                + "\n Size: " + size
                + "\n Toppings: ");
                printAllToppings();
    }

    private void printAllToppings() {
        for(Topping x: toppings) {
            System.out.println(x);
        }
    }


    public static class Builder {
        private pizzaSize size;
        private String pizzaChain;
        private ArrayList<Topping> toppings = new ArrayList<Topping>();

        public Builder(String pizzaChain, pizzaSize size) {
            this.pizzaChain = pizzaChain;
            this.size = size;
        }

        public Builder addTopping(Topping topping) {
            toppings.add(topping);
            return this;
        }

        public Pizza build() {
            return new Pizza(pizzaChain, size, toppings);
        }
    }


}
