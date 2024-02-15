package Problem1;

public class CommisionEmployee extends Employee {
    private double commisionRate;
    private String grossSales;
    public CommisionEmployee(String firstName, String lastName, String ssn, double commisionRate, String grossSales) {
        super(firstName, lastName, ssn);
        this.commisionRate = commisionRate;
        this.grossSales = grossSales;
    }


    public void printCommisionEmployeeDetails() {
        super.printBasicEmployeeDetails();
        System.out.println("Commision Rate: " + commisionRate + " Gross Sales: " + grossSales + "\n\n");
    }

    public double getCommisionRate() {
        return commisionRate;
    }

    public void setCommisionRate(double commisionRate) {
        this.commisionRate = commisionRate;
    }

    public String getGrossSales() {
        return grossSales;
    }

    public void setGrossSales(String grossSales) {
        this.grossSales = grossSales;
    }
}
