package hw1ex3;
import java.util.Scanner;
public class Grade {
    public static void main(String[] argc) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Input a grade: ");
        double grade = scan.nextDouble();
        if (grade > 100 || grade < 0) {
            System.out.println("Invalid value of grade");
        }
        else if (grade <= 100 && grade >= 95) {
            System.out.println("Your grade: A");
        }
        else if(grade < 95 && grade >= 90) {
            System.out.println("Your grade: A-");
        }
        else if(grade < 90 && grade >= 85) {
            System.out.println("Your grade: B+");
        }
        else if(grade < 85 && grade >= 80) {
            System.out.println("Your grade: B");
        }
        else if(grade < 80 && grade >= 75) {
            System.out.println("Your grade: B-");
        }
        else if(grade < 75 && grade >= 70) {
            System.out.println("Your grade: C+");
        }
        else if(grade < 70 && grade >= 65) {
            System.out.println("Your grade: C");
        }
        else if(grade < 65 && grade >= 60) {
            System.out.println("Your grade: C-");
        }
        else if(grade < 60 && grade >= 55) {
            System.out.println("Your grade: D+");
        }
        else if(grade < 55 && grade >= 50) {
            System.out.println("Your grade: D");
        }
        else System.out.println("Your grade: F");
    }
}
