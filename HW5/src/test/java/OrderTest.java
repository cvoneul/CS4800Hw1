import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderTest {
    private Burger burger = new Burger();
    private HotDog hotdog = new HotDog();
    private Fries fries = new Fries();

    private Bacon burgerWithBacon = new Bacon(burger);
    private Bacon hotdogWithBacon = new Bacon(hotdog);
    private Bacon friesWithBacon = new Bacon(fries);

    private Cheese burgerWithCheese = new Cheese(burger);
    private Cheese hotdogWithCheese = new Cheese(hotdog);
    private Cheese friesWithCheese = new Cheese(fries);

    @Test
    public void toStringTest() {
        Item[] items = {burger, hotdog, fries};
        Order order = new Order(items);

        String expected = "Burger, HotDog, Fries";
        String actual = order.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void totalCostBasesOnlyTest() {
        Item[] items = {burger, hotdog, fries};
        Order order = new Order(items);

        double expected = 9.50;
        double actual = order.calculateTotalCost();
        assertEquals(expected, actual);
    }

    @Test
    public void totalCostMixedTest() {
        Item[] items = {burgerWithCheese, hotdogWithCheese, fries};
        Order order = new Order(items);

        double expected = 10.50;
        double actual = order.calculateTotalCost();
        assertEquals(expected, actual);
    }
}
