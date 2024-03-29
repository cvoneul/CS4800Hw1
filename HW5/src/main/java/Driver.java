public class Driver {

    public static void main(String[] args) {

        Burger burger = new Burger();
        HotDog hotdog = new HotDog();
        Bacon hotdogWbacon = new Bacon(hotdog);

        Item[] items = {burger, hotdog, hotdogWbacon};

        Order order = new Order(items);

        CustomerLoyalty customer = new CustomerLoyalty(CustomerLoyalty.STATUS.Loyal);
        double totalCost = customer.applyDiscount(order);

        //System.out.println(order.toString());

        System.out.println("Total: $" + totalCost);
    }
}
