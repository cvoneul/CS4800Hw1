public class PizzaDriver {
    public static void main(String[] args) {
        Pizza pizza = Pizza.builder("PizzaHut", "Medium")
                .addTopping("Pepperoni")
                .addTopping("Sausage")
                .build();


        pizza.eat();
    }
}
