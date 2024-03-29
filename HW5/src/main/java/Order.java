public class Order {
    Item[] foodItems;

    public Order(Item[] foodItems) {
        this.foodItems = foodItems;
    }

    public double calculateTotalCost() {
        double sum = 0;
        for(Item x: foodItems) {
            sum += x.calculateCost();
        }
        return sum;
    }

    public Item[] getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(Item[] foodItems) {
        this.foodItems = foodItems;
    }

    @Override
    public String toString() {
        String items = "";
        for(Item x: foodItems) {
            items += x.getClass().getSimpleName() + ", ";
        }
        items = items.substring(0, items.length() - 2);
        return items;
    }
}
