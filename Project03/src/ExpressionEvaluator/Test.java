package ExpressionEvaluator;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * The Test class of the expression evaluator
 * 
 * @author Xinyang Zhou
 * @version 1.0
 */
public class Test {

    /**
     * Starts the test
     */
    public static void start() {

        Expression a = new Expression("22 * ( (3 + 4) + 10)");
        //Expression a = new Expression("A * ( (B + C) + D)");
        ArrayList<String> b = a.toPostfix();
        for (String c : b) {
            System.out.print(c);
            System.out.print(" ");

        }
        // A array list that will be used to store a list of Expression objects.
        ArrayList<Expression> expressions = new ArrayList<Expression>();
        // Calls create method with a reference to the list.
        create(expressions);
        // Call display method with a reference to the list.
        display(expressions);
        // Call otherMethods with a reference to the list for more testing.
    }

    /**
     * Creates expression objects using data from an input file and store the
     * objects into the list.
     * 
     * @param expressions a list of Expression objects
     * @throws FileNotFoundException "items.txt" can't be found
     */
    public static void create(ArrayList<Expression> expressions) {
        // Create expression objects using data from an input file and store the objects
        // into the list.
        // While there are more lines (You will use hasNextLine instead of hasNext.),
        // Read the next line from the input file as a string, create an expression and
        // add it to the list.
        // 7
        // Note: This will test the constructors.
    }

    /**
     * Prints the list of expressions and the values
     * 
     * @param expressions
     */
    public static void display(ArrayList<Expression> expressions) {
        // Print the list of expressions as both infix and postfix.
        // Print the values of the list of expressions.
    }

    // • There are more methods than what are invoked/tested by the previous three
    // methods. You may add more
    // statements in the methods or write additional methods to test the rest of the
    // methods for all classes. Can you
    // create another static method that test other operations?
    public static void otherMethods(ArrayList<Expression> expressions) {
    }

}
