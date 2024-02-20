package Problem2;
public class Ship {
    private String name, year;
    public Ship(String name, String year) {
        this.name = name;
        this.year = year;
    }
    public void printShip() {
        System.out.println("Ship name: " + name + " Year: " + year);
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getYear() {
        return year;
    }
    public void setYear(String year) {
        this.year = year;
    }
}
