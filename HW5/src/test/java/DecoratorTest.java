import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DecoratorTest {
    private Burger burger = new Burger();//4.50
    private HotDog hotdog = new HotDog();//3.50
    private Fries fries = new Fries();//1.50

    private Bacon burgerWithBacon = new Bacon(burger);//5.50
    private Bacon hotdogWithBacon = new Bacon(hotdog);//4.50
    private Bacon friesWithBacon = new Bacon(fries);//2.50

    private Cheese burgerWithCheese = new Cheese(burger);//5.00
    private Cheese hotdogWithCheese = new Cheese(hotdog);//4.00
    private Cheese friesWithCheese = new Cheese(fries);//2.00


    private CustomerLoyalty loyalCustomer = new CustomerLoyalty(CustomerLoyalty.STATUS.Loyal);//half-price
    private CustomerLoyalty regularCustomer = new CustomerLoyalty(CustomerLoyalty.STATUS.Regular);


    @Test
    public void onlyBaseFoodsTest() {
        Item[] items = {burger, hotdog, fries};
        Order order = new Order(items);

        double expected = 9.50;
        double actual = order.calculateTotalCost();
        assertEquals(expected, actual);
    }


    @Test
    public void onlyFoodsWithToppingTest() {
        Item[] items = {burgerWithBacon, hotdogWithCheese, friesWithCheese};
        Order order = new Order(items);

        double expected = 11.50;
        double actual = order.calculateTotalCost();
        assertEquals(expected, actual);
    }

    @Test
    public void mixOfFoodsWithAndWithoutToppingTest() {
        Item[] items = {burgerWithCheese, hotdog, fries};
        Order order = new Order(items);

        double expected = 10.00;
        double actual = order.calculateTotalCost();
        assertEquals(expected, actual);
    }

    @Test
    public void baseFoodWithCustomerLoyaltyTest() {
        Item[] items = {burger, hotdog, fries};
        Order order = new Order(items);

        double expected = 4.75;
        double actual = loyalCustomer.applyDiscount(order);
        assertEquals(expected, actual);
    }

    @Test
    public void baseFoodWithRegularCustomerTest() {
        Item[] items = {burger, hotdog, fries};
        Order order = new Order(items);

        double expected = 9.50;
        double actual = regularCustomer.applyDiscount(order);
        assertEquals(expected, actual);
    }

    @Test
    public void mixOfFoodsWithToppingWithCustomerLoyaltyTest() {
        Item[] items = {burgerWithCheese, hotdogWithBacon, fries};
        Order order = new Order(items);

        double expected = 11.00;
        double actual = regularCustomer.applyDiscount(order);
        assertEquals(expected, actual);
    }
}
