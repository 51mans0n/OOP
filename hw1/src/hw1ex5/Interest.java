package hw1ex5;
import java.util.Scanner;
public class Interest {
    public static void main(String[] argc) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Input your balance: ");
        double balance = scan.nextDouble();
        System.out.println("Input the percentages to add: ");
        double percentages = scan.nextDouble();
        double result = balance + (balance / 100) * percentages;
        System.out.println("Your balance: " + result);
    }
}
