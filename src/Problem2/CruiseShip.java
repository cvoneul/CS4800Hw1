package Problem2;

public class CruiseShip extends Ship {
    private int maxNumberOfPassengers;

    public CruiseShip(String name, String year, int maxNumberOfPassengers) {
        super(name, year);
        this.maxNumberOfPassengers = maxNumberOfPassengers;
    }

    @Override
    public void printShip() {
        System.out.println("Ship name: " + getName() + " Max number of passengers: " + maxNumberOfPassengers);
    }

    public int getMaxNumberOfPassengers() {
        return maxNumberOfPassengers;
    }

    public void setMaxNumberOfPassengers(int maxNumberOfPassengers) {
        this.maxNumberOfPassengers = maxNumberOfPassengers;
    }
}
