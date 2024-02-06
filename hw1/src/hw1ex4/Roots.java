package hw1ex4;
import java.util.Scanner;
public class Roots {
    public static void main(String[] argc) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Input \"a\" value");
        double aValue = scan.nextDouble();
        System.out.println("Input \"b\" value");
        double bValue = scan.nextDouble();
        System.out.println("Input \"c\" value");
        double cValue = scan.nextDouble();
        double firstFinalValue, secondFinalValue;
        double discriminant = Math.pow(bValue, 2) - 4 * aValue * cValue;
        if (discriminant < 0) {
            System.out.println("No roots, discriminant = 0");
        }
        else if (discriminant == 0) {
            firstFinalValue = -1 * (bValue / 2 * aValue);
            System.out.println("Only one root: " + firstFinalValue);
        }
        else {
            firstFinalValue = (-1 * (bValue - Math.sqrt(discriminant)) / (2 * aValue));
            secondFinalValue = (-1 * (bValue + Math.sqrt(discriminant)) / (2 * aValue));
            System.out.println("First root: " + firstFinalValue + "\n" + "Second root: " + secondFinalValue);
        }
    }
}
