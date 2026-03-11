import java.util.Scanner;

public class PalindromeCheckerApp {

    // Recursive function to check palindrome
    public static boolean isPalindrome(String str, int start, int end) {

        // Base condition
        if (start >= end) {
            return true;
        }

        // If characters don't match
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        // Recursive call
        return isPalindrome(str, start + 1, end - 1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Remove spaces and convert to lowercase
        input = input.replaceAll("\\s+", "").toLowerCase();

        boolean result = isPalindrome(input, 0, input.length() - 1);

        if (result) {
            System.out.println("The given string is a PALINDROME.");
        } else {
            System.out.println("The given string is NOT a palindrome.");
        }

        sc.close();
    }
}