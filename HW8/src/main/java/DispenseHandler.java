public interface DispenseHandler {
    void dispense(Snack snack);
    void nextHandler(DispenseHandler handler);
}
