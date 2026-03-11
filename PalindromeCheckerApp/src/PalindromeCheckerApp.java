import java.util.*;

class Node {
    char data;
    Node next;

    Node(char data) {
        this.data = data;
        this.next = null;
    }
}
public class PalindromeCheckerApp {
    public static Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }

    // Check palindrome
    public static boolean isPalindrome(Node head) {
        if (head == null || head.next == null)
            return true;
        Node slow = head;
        Node fast = head;
        // Find middle using fast & slow pointer
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // Reverse second half
        Node secondHalf = reverse(slow);
        Node firstHalf = head;
        // Compare both halves
        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        input = input.replaceAll("\\s+", "").toLowerCase();
        Node head = null;
        Node temp = null;
        // Convert string to linked list
        for (int i = 0; i < input.length(); i++) {
            Node newNode = new Node(input.charAt(i));
            if (head == null) {
                head = newNode;
                temp = head;
            } else {
                temp.next = newNode;
                temp = newNode;
            }
        }
        // Check palindrome
        if (isPalindrome(head)) {
            System.out.println("The given string is a PALINDROME.");
        } else {
            System.out.println("The given string is NOT a palindrome.");
        }
        sc.close();
    }
}
