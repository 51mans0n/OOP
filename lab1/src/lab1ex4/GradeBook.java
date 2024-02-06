package lab1ex4;
import classStudent.Student;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class GradeBook {
    Scanner scan = new Scanner(System.in);
    private Course course;
    private List<Double> grades;
    private double summary;
    private double maxGrade;
    private double minGrade;
    private int counter;
    private List<Student> students;
    private Student minGradeStudent;
    private Student maxGradeStudent;
    public GradeBook(Course course) {
        this.course = course;
        this.grades = new ArrayList<>();
        this.students = new ArrayList<>();
        maxGrade = Double.MIN_VALUE;
        minGrade = Double.MAX_VALUE;
        counter = 0;
        summary = 0;
    }
    public void addStudent(Student student) {
        students.add(student);
    }
    public void inputGrades () {
        for(Student student : students) {
            System.out.print(student.getName() + ": ");
            double inputGrade = scan.nextDouble();
            grades.add(inputGrade);
            summary += inputGrade;
            if (inputGrade < minGrade) {
                minGrade = inputGrade;
                minGradeStudent = student;
            }
            else if (inputGrade > maxGrade) {
                maxGrade = inputGrade;
                maxGradeStudent = student;
            }
            counter++;
        }
    }
    public void dispayMessage() {
        System.out.println("Welcome to the grade book for " + course.getDescription()  + " " + course.getName() + "\n");
        System.out.println("Plese, input grades for student:");
    }
    public double determineClassAverage() {
        if(counter == 0) {
            return 0;
        }
        return summary / counter;
    }
    public double getMaxGrade() {
        return maxGrade;
    }
    public double getMinGrade() {
        return minGrade;
    }
    public void displayGradeReport() {
        System.out.println("Class average is: " + determineClassAverage() + ". Lowest grade is " + (int) getMinGrade() + " (" + minGradeStudent.getName() +  ", id:" + minGradeStudent.getId() + ").");
        System.out.println("Highest grade is " + (int) getMaxGrade() + " (" + maxGradeStudent.getName() + ", id:" + maxGradeStudent.getId() + ").\n");
        outputBarChart();
    }
    public void outputBarChart() {
        System.out.println("Grades distribution:");
        System.out.print("00-09: " );
        for(Double temp: grades) {
            if(temp >= 0 && temp <= 9){
                System.out.print("*");
            }
        }
        System.out.print("\n10-19: ");
        for(Double temp: grades) {
            if(temp >= 10 && temp <= 19){
                System.out.print("*");
            }
        }
        System.out.print("\n20-29: ");
        for(Double temp: grades) {
            if(temp >= 20 && temp <= 29){
                System.out.print("*");
            }
        }
        System.out.print("\n30-39: ");
        for(Double temp: grades) {
            if(temp >= 30 && temp <= 39){
                System.out.print("*");
            }
        }
        System.out.print("\n40-49: ");
        for(Double temp: grades) {
            if(temp >= 40 && temp <= 49){
                System.out.print("*");
            }
        }
        System.out.print("\n50-59: ");
        for(Double temp: grades) {
            if(temp >= 50 && temp <= 59){
                System.out.print("*");
            }
        }
        System.out.print("\n60-69: ");
        for(Double temp: grades) {
            if(temp >= 60 && temp <= 69){
                System.out.print("*");
            }
        }
        System.out.print("\n70-79: ");
        for(Double temp: grades) {
            if(temp >= 70 && temp <= 79){
                System.out.print("*");
            }
        }
        System.out.print("\n80-89: ");
        for(Double temp: grades) {
            if(temp >= 80 && temp <= 89){
                System.out.print("*");
            }
        }
        System.out.print("\n90-99: ");
        for(Double temp: grades) {
            if(temp >= 90 && temp <= 99){
                System.out.print("*");
            }
        }
        System.out.print("\n100: ");
        for(Double temp: grades) {
            if(temp == 100){
                System.out.print("*");
            }
        }
    }
}
