package Problem1;

public class Main {
    public static void main(String[] args) {
        SalariedEmployee E1 = new SalariedEmployee("Joe","Jones", "111111111", "2500");
        E1.printSalariedEmployeeDetails();

        HourlyEmployee E2 = new HourlyEmployee("Stephanie", "Smith", "222222222", 25, 32);
        E2.printHourlyEmployeeDetails();

        HourlyEmployee E3 = new HourlyEmployee("Mary", "Quinn", "333333333", 19, 47);
        E3.printHourlyEmployeeDetails();

        CommisionEmployee E4 = new CommisionEmployee("Nicole", "Dior", "4444444444", .15, "50000");
        E4.printCommisionEmployeeDetails();

        SalariedEmployee E5 = new SalariedEmployee("Renwa", "Chanel", "555555555", "1700");
        E5.printSalariedEmployeeDetails();

        BaseEmployee E6 = new BaseEmployee("Mike", "Davenport", "6666666666", "95000");
        E6.printBaseEmployeeDetails();

        CommisionEmployee E7 = new CommisionEmployee("Mahnaz", "Vaziri", "777777777", .22, "40000");
        E7.printCommisionEmployeeDetails();
    }
}