import java.util.*;

public class PalindromeCheckerApp {

    // Stack method
    public static boolean stackPalindrome(String str) {

        str = str.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            stack.push(c);
        }

        for (char c : str.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }

        return true;
    }

    // Deque method
    public static boolean dequePalindrome(String str) {

        str = str.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();

        for (char c : str.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }

        return true;
    }

    // Two pointer method
    public static boolean twoPointerPalindrome(String str) {

        str = str.replaceAll("\\s+", "").toLowerCase();
        int start = 0;
        int end = str.length() - 1;

        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Stack timing
        long startTime = System.nanoTime();
        boolean stackResult = stackPalindrome(input);
        long endTime = System.nanoTime();
        long stackTime = endTime - startTime;

        // Deque timing
        startTime = System.nanoTime();
        boolean dequeResult = dequePalindrome(input);
        endTime = System.nanoTime();
        long dequeTime = endTime - startTime;

        // Two pointer timing
        startTime = System.nanoTime();
        boolean pointerResult = twoPointerPalindrome(input);
        endTime = System.nanoTime();
        long pointerTime = endTime - startTime;

        System.out.println("\nResults:");
        System.out.println("Stack Method: " + stackResult + " | Time: " + stackTime + " ns");
        System.out.println("Deque Method: " + dequeResult + " | Time: " + dequeTime + " ns");
        System.out.println("Two Pointer Method: " + pointerResult + " | Time: " + pointerTime + " ns");

        sc.close();
    }
}