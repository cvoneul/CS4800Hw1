public class CustomerLoyalty {
    private STATUS status;

    enum STATUS {
        Loyal,
        Regular
    }

    public CustomerLoyalty(STATUS status) {
        this.status = status;
    }

    public double applyDiscount(Order order){
        if(status == STATUS.Loyal) {
            return order.calculateTotalCost() * .50;
        }
        return order.calculateTotalCost();
    }

}
