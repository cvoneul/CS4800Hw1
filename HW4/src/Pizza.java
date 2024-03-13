import java.util.ArrayList;

public class Pizza {
    private String size;
    private String pizzaChain;
    private ArrayList<String> toppings = new ArrayList<String>();

    public Pizza(String pizzaChain, String size, ArrayList<String> toppings) {
        this.pizzaChain = pizzaChain;
        this.size = size;
        this.toppings = toppings;
    }

    public static Builder builder(String chain, String size) {
        return new Builder(chain, size);
    }

    public void eat() {
        System.out.println("Pizza Chain: " + pizzaChain
                + "\n Size: " + size
                + "\n Toppings: ");
                printAllToppings();
    }

    private void printAllToppings() {
        for(String x: toppings) {
            System.out.println(x);
        }
    }


    public static class Builder {
        private String size;
        private String pizzaChain;
        private ArrayList<String> toppings = new ArrayList<String>();

        public Builder(String pizzaChain, String size) {
            this.pizzaChain = pizzaChain;
            this.size = size;
        }

        public Builder addTopping(String topping) {
            toppings.add(topping);
            return this;
        }

        public Pizza build() {
            return new Pizza(pizzaChain, size, toppings);
        }
    }


}
