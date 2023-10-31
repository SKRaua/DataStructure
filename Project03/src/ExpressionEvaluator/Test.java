package ExpressionEvaluator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The Test class of the expression evaluator
 * 
 * @author Xinyang Zhou
 * @version 1.0
 */
public class Test {

    /**
     * Starts the test
     * 
     * @throws FileNotFoundException "items.txt" can't be found
     */
    public static void start() throws FileNotFoundException {
        // A array list that will be used to store a list of Expression objects.
        ArrayList<Expression> expressions = new ArrayList<Expression>();
        // Calls create method with a reference to the list.
        create(expressions);
        // Call display method with a reference to the list.
        display(expressions);
        // Call other methods for more testing.
        otherExpressionTests(expressions);
        otherGenericStackTests();
    }

    /**
     * Creates expression objects using data from an input file and store the
     * objects into the list.
     * 
     * @param expressions a list of Expression objects
     * @throws FileNotFoundException "items.txt" can't be found
     */
    public static void create(ArrayList<Expression> expressions) throws FileNotFoundException {
        Scanner input = new Scanner(new File("items.txt"));
        // Create expression objects and store the objects into the list.
        while (input.hasNextLine()) {
            expressions.add(new Expression(input.nextLine()));
        }
        input.close();
    }

    /**
     * Prints the list of expressions and the values
     * 
     * @param expressions The expression array list
     */
    public static void display(ArrayList<Expression> expressions) {
        for (Expression expression : expressions) {
            ArrayList<String> postfixexpression = expression.toPostfix();

            // Prints the list of expressions as both infix and postfix.
            System.out.println("The infix: " + expression.getInfix());
            System.out.print("The postfix: ");
            for (String token : postfixexpression) {
                System.out.print(token + " ");
            }
            System.out.println();

            // Prints the results.
            System.out.println("The result: " + expression.result());
            System.out.println();
        }
    }

    /**
     * Tests other methods in Expression class.
     * 
     * @param expressions The expression array list
     */
    public static void otherExpressionTests(ArrayList<Expression> expressions) {
        System.out.println("Other Expression tests: ");
        Expression expression1 = expressions.get(0);
        Expression expression2 = new Expression("1 + 1");

        // toString()
        System.out.println(expression1.toString());

        // setInfix(String)
        expression1.setInfix("1 + 1");
        System.out.println("The expression1 has been set to \"1 + 1\".");
        System.out.println(expression1.toString());

        // equals(Expression)
        System.out.println(
                "Are two expressions equal: " + expression1.equals(expression2) + " (\"1 + 1\" \"1 + 1\")");
        System.out.println("Are two expressions equal: "
                + expression1.equals(expressions.get(1)) + " (\"1 + 1\" \"2*(3+(4+5))\")");
        System.out.println();
    }

    /**
     * Tests other methods in GenericStack class.
     */
    public static void otherGenericStackTests() {
        System.out.println("Other GenericStack tests: ");
        GenericStack<String> stack = new GenericStack<String>();
        stack.push("a");
        stack.push("b");
        stack.push("c");

        // isEmpty()
        System.out.println("Is the stack empty: " + stack.isEmpty());
        // size()
        System.out.println("Size of the stack: " + stack.size());

        // popAll()
        stack.popAll();
        System.out.println("All items have been pop.");
        System.out.println("Is the stack empty: " + stack.isEmpty());
        System.out.println("Size of the stack: " + stack.size());
        System.out.println();
    }
}