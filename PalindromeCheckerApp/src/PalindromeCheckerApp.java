import java.util.*;

public class PalindromeCheckerApp {
    static void main() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Convert to lowercase and remove spaces
        input = input.replaceAll("\\s+", "").toLowerCase();

        // Create Queue and Stack
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        // Insert characters into Queue and Stack
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            queue.add(ch);      // Enqueue
            stack.push(ch);     // Push
        }

        boolean isPalindrome = true;

        // Compare dequeue and pop
        while (!queue.isEmpty()) {

            char qChar = queue.remove();  // Dequeue
            char sChar = stack.pop();     // Pop

            if (qChar != sChar) {
                isPalindrome = false;
                break;
            }
        }

        // Result
        if (isPalindrome) {
            System.out.println("The given string is a PALINDROME.");
        } else {
            System.out.println("The given string is NOT a palindrome.");
        }

        sc.close();
    }
}
