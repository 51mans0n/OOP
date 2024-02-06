package hw1ex6;
import java.util.Scanner;
public class Palindrome {
    public static void main(String[] argc) {
        Scanner scan = new Scanner(System.in);
        String word = scan.nextLine();
        if (isPalindrome(word)) {
            System.out.println("The word is palindrome");
        }
        else System.out.println("The word isn't palindrome");
    }
    public static boolean isPalindrome(String word) {
        int length = word.length();
        for(int i = 0 ; i < length / 2 ; i++) {
            if(word.charAt(i) != word.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
