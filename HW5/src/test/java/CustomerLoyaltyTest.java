import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerLoyaltyTest {

    @Test
    public void basicloyalCustomerTest() {
        CustomerLoyalty loyalCustomer = new CustomerLoyalty(CustomerLoyalty.STATUS.Loyal);//half-price
        Fries fries = new Fries();//1.50
        Item[] items = {fries};
        Order order = new Order(items);


        double expected = .75;
        double actual = loyalCustomer.applyDiscount(order);
        assertEquals(expected, actual);
    }


    @Test
    public void basicRegularCustomerTest() {
        CustomerLoyalty customer = new CustomerLoyalty(CustomerLoyalty.STATUS.Regular);
        Fries fries = new Fries();//1.50
        Item[] items = {fries};
        Order order = new Order(items);


        double expected = 1.50;
        double actual = customer.applyDiscount(order);
        assertEquals(expected, actual);
    }

    @Test
    public void manyItemsRegularCustomerTest() {
        CustomerLoyalty regularCustomer = new CustomerLoyalty(CustomerLoyalty.STATUS.Regular);
        Burger burger = new Burger();//4.50
        HotDog hotdog = new HotDog();//3.50
        Fries fries = new Fries();//1.50

        Item[] items = {burger, hotdog, fries};
        Order order = new Order(items);


        double expected = 9.50;
        double actual = regularCustomer.applyDiscount(order);
        assertEquals(expected, actual);
    }

    @Test
    public void manyItemsLoyalCustomerTest() {
        CustomerLoyalty loyalCustomer = new CustomerLoyalty(CustomerLoyalty.STATUS.Loyal);
        Burger burger = new Burger();//4.50
        HotDog hotdog = new HotDog();//3.50
        Fries fries = new Fries();//1.50

        Item[] items = {burger, hotdog, fries};
        Order order = new Order(items);


        double expected = 4.75;
        double actual = loyalCustomer.applyDiscount(order);
        assertEquals(expected, actual);
    }
}
