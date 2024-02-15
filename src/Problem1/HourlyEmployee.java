package Problem1;

public class HourlyEmployee extends Employee {
    private int hourlyWage;
    private int numbOfHoursWorked;

    public HourlyEmployee(String firstName, String lastName, String ssn, int hourlyWage, int numbOfHoursWorked) {
        super(firstName, lastName, ssn);
        this.hourlyWage = hourlyWage;
        this.numbOfHoursWorked = numbOfHoursWorked;
    }

    public void printHourlyEmployeeDetails() {
        super.printBasicEmployeeDetails();
        System.out.println("Hourly Wage: " + hourlyWage + " Number Of Hours Worked: " + numbOfHoursWorked + "\n\n");
    }


    public int getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(int hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    public int getNumbOfHoursWorked() {
        return numbOfHoursWorked;
    }

    public void setNumbOfHoursWorked(int numbOfHoursWorked) {
        this.numbOfHoursWorked = numbOfHoursWorked;
    }
}
