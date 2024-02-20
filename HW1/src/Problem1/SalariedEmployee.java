package Problem1;

public class SalariedEmployee extends Employee {
    private String weeklySalary;
    public SalariedEmployee(String firstName, String lastName, String ssn, String weeklySalary) {
        super(firstName, lastName, ssn);
        this.weeklySalary = weeklySalary;
    }


    public void printSalariedEmployeeDetails() {
        super.printBasicEmployeeDetails();
        System.out.println("Weekly Salary: " + weeklySalary + "\n\n");
    }


    public String getWeeklySalary() {
        return weeklySalary;
    }

    public void setWeeklySalary(String weeklySalary) {
        this.weeklySalary = weeklySalary;
    }
}
