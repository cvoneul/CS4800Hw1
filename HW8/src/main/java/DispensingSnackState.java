public class DispensingSnackState implements  StateOfVendingMachine {
    private VendingMachine vendingMachine;

    public DispensingSnackState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectSnack(Snack snack) {
        System.out.println("Cannot choose snack while one is dispensing");
    }

    @Override
    public void insertMoney(double amount) {
        System.out.println("Cannot insert money while snack is dispensing");
    }

    @Override
    public void dispenseSnack() {
        Snack snack = vendingMachine.getCurrentSnack();
        if(snack.getQuantity() > 0) {
            System.out.println("Dispensing: " + snack.getName());
            snack.setQuantity(snack.getQuantity() - 1);
        }else {
            System.out.println("Out of stock on " + snack.getName());
        }
        vendingMachine.setState(vendingMachine.getIdleState());
    }
}
