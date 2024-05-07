public class SnackDispenseHandler implements DispenseHandler {
    private DispenseHandler nextDispenseHandler;
    private Snack snack;

    public SnackDispenseHandler(Snack snack) {
        this.snack = snack;
    }

    @Override
    public void dispense(Snack snack) {
        if(this.snack.getName().equals(snack.getName())) {
            System.out.println("Dispensing: " + snack.getName());
        } else if (nextDispenseHandler != null) {
            nextDispenseHandler.dispense(snack);
        } else {
            System.out.println("Snack does not exist");
        }
    }

    @Override
    public void nextHandler(DispenseHandler handler) {
        this.nextDispenseHandler = handler;
    }
}
