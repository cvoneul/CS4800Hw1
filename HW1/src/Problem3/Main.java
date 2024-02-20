package Problem3;

public class Main {
    public static void main(String[] args) {
        Instructor instructor1 = new Instructor("Nima", "Davarpanah", 32636);
        Instructor instructor2 = new Instructor("Gerald", "Adams", 23454);

        Textbook textbook1 = new Textbook("Clean Code", "Robert Martin","Prentice Hall");
        Textbook textbook2 = new Textbook("Ugly Code", "Robert Martin","Prentice Hall");

        Instructor[] instructors = {instructor1, instructor2};
        Textbook[] textbooks = {textbook1, textbook2};

        Course course1 = new Course("Software Engineering", instructors, textbooks);

        course1.printCourseDetails();
    }
}
