package Problem1;

public class BaseEmployee extends Employee {
    private String baseSalary;
    public BaseEmployee(String firstName, String lastName, String ssn, String baseSalary) {
        super(firstName, lastName, ssn);
        this.baseSalary = baseSalary;
    }

    public void printBaseEmployeeDetails() {
        super.printBasicEmployeeDetails();
        System.out.println("Base Salary: " + baseSalary +  "\n\n");
    }
    public String getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(String baseSalary) {
        this.baseSalary = baseSalary;
    }
}
