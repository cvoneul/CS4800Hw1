package Problem3;

public class Instructor {
    private String firstName, lastName;
    private int officeNumber;

    public Instructor(String firstName, String lastName, int officeNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.officeNumber = officeNumber;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public int getOfficeNumber() {
        return officeNumber;
    }
    public void setOfficeNumber(int officeNumber) {
        this.officeNumber = officeNumber;
    }
}
