import java.util.ArrayList;

public class VendingMachine {
    private static StateOfVendingMachine state;
    private ArrayList<Snack> snacks;
    private DispenseHandler snackDispenser;
    private Snack currentSnack;

    public VendingMachine(ArrayList<Snack> snacks) {
        this.snacks = snacks;
        state = new IdleState(this);
        snackDispenser = initializeChain();
    }

    public DispenseHandler initializeChain() {
        DispenseHandler cokeHandler = new SnackDispenseHandler(snacks.get(0));
        SnackDispenseHandler pepsiHandler = new SnackDispenseHandler(snacks.get(1));
        SnackDispenseHandler cheetosHandler = new SnackDispenseHandler(snacks.get(2));
        SnackDispenseHandler doritosHandler = new SnackDispenseHandler(snacks.get(3));
        SnackDispenseHandler kitkatHandler = new SnackDispenseHandler(snacks.get(4));
        SnackDispenseHandler snickersHandler = new SnackDispenseHandler(snacks.get(5));
        cokeHandler.nextHandler(pepsiHandler);
        pepsiHandler.nextHandler(cheetosHandler);
        doritosHandler.nextHandler(kitkatHandler);
        kitkatHandler.nextHandler(snickersHandler);
        return cokeHandler;
    }

    public StateOfVendingMachine getIdleState() {
        return new IdleState(this);
    }

    public StateOfVendingMachine getWaitingForMoneyState() {
        return new WaitingForMoneyState(this);
    }

    public StateOfVendingMachine getDispensingSnackState() {
        return new DispensingSnackState(this);
    }

    public void selectSnack(Snack snack) {
        state.selectSnack(snack);
    }

    public void insertMoney(double moneyInserted) {
        state.insertMoney(moneyInserted);
    }

    public void dispenseSnack() {
        state.dispenseSnack();
    }

    public void setState(StateOfVendingMachine state) {
        this.state = state;
    }

    public void setCurrentSnack(Snack snack) {
        currentSnack = snack;
    }

    public Snack getCurrentSnack() {
        return currentSnack;
    }

    public StateOfVendingMachine getState() {
        return state;
    }
}
