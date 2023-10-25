package stack;

import java.util.Stack;

/**
 * Demonstration of the java.util.Stack class.
 * 
 * @author Tony Gaddis and Qi Wang
 * @version 1.0
 */
public class StackDemo {
    /**
     * Stores a list of strings in a stack.
     * 
     * @param args A reference to a string array containing command-line arguments
     */
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        String[] names = { "Al", "Bob", "Carol" };

        System.out.println("Pushing onto the stack the names:");
        System.out.println("Al Bob Carol");
        for (String s : names) {
            stack.push(s);
        }

        System.out.println("Popping and printing all stack values:");
        while (!stack.empty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
