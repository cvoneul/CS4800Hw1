package Problem3;

public class Course {
    private String courseName;
    private Instructor[] instructor;
    private Textbook[] textbook;

    public Course(String courseName, Instructor[] instructor, Textbook[] textbook) {
        this.instructor = new Instructor[instructor.length];
        this.textbook = new Textbook[textbook.length];

        this.courseName = courseName;

        for(int i = 0; i < instructor.length; i++) {
            this.instructor[i] = instructor[i];
        }
        for(int i = 0; i < textbook.length; i++) {
            this.textbook[i] = textbook[i];
        }
    }

    public void printCourseDetails() {
        System.out.print("Course Name: " + courseName + " \nInstructors: ");
        for(int i = 0; i < instructor.length; i++) {
            System.out.print(instructor[i].getFirstName()+ " " + instructor[i].getLastName() + "; ");
        }
        System.out.print("\nTextbooks: ");
        for(int i = 0; i < textbook.length; i++) {
            System.out.print(textbook[i].getTitle() + ", Author: " + textbook[i].getAuthor() + "; ");
        }
    }
    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public Instructor getInstructor(int i) {
        return instructor[i];
    }
    public void setInstructor(Instructor instructor, int i) {
        this.instructor[i] = instructor;
    }
    public Textbook getTextbook(int i) {
        return textbook[i];
    }
    public void setTextbook(Textbook textbook, int i) {
        this.textbook[i] = textbook;
    }
}
