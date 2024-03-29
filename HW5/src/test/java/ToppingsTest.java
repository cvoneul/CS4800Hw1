import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToppingsTest {

    private Burger burger = new Burger();//4.50
    private HotDog hotdog = new HotDog();//3.50
    private Fries fries = new Fries();//1.50

    @Test
    public void baconTest() {
        Bacon burgerWithBacon = new Bacon(burger);

        double expected = 5.50;
        double actual = burgerWithBacon.calculateCost();
        assertEquals(expected, actual);
    }

    @Test
    public void cheeseTest() {
        Cheese hotdogWithCheese = new Cheese(hotdog);

        double expected = 4.00;
        double actual = hotdogWithCheese.calculateCost();
        assertEquals(expected, actual);
    }
}
