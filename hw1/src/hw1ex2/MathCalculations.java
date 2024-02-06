package hw1ex2;
import java.util.Scanner;

public class MathCalculations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Input a side of square: ");
        double side = scan.nextInt();
        double area = Math.pow(side, 2);
        double perimeter = side + side;
        double lengthOfDiagonal = Math.sqrt(2) * side;
        System.out.println("Side length: " + side + "\n" + "Perimeter of square: " + perimeter + "\n" + "Length of diagonal: " + lengthOfDiagonal);
    }
}
