package lab1ex4;

import classStudent.Student;

public class GradeBookTest {
    public static void main(String[] argc) {
        Course newCourse = new Course("Object-Oriented Programming and Design", "CS101", 5, "PP2");
        GradeBook newGradeBook = new GradeBook(newCourse);

        newGradeBook.addStudent(new Student("Student A", 1112));
        newGradeBook.addStudent(new Student("Student B", 1113));
        newGradeBook.addStudent(new Student("Student C", 1114));
        newGradeBook.addStudent(new Student("Student D", 1115));
        newGradeBook.addStudent(new Student("Student E", 1116));
        newGradeBook.addStudent(new Student("Student P", 1117));
        newGradeBook.addStudent(new Student("Student G", 1118));
        newGradeBook.addStudent(new Student("Student H", 1119));
        newGradeBook.addStudent(new Student("Student I", 1120));
        newGradeBook.addStudent(new Student("Student J", 1121));

        newGradeBook.dispayMessage();
        newGradeBook.inputGrades();
        newGradeBook.displayGradeReport();
    }
}
