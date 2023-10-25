package ExpressionEvaluator;

import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * The Expression class to store, change form and evaluate an expression
 * 
 * @author Xinyang Zhou
 * @version 1.0
 */
public class Expression {

    /**
     * The infix expression
     */
    private String infix;

    /**
     * Constructs a empty expression.
     */
    public Expression() {
        infix = new String();
    }

    /**
     * Constructs a Expression with a infix.
     * 
     * @param infix The infix expression
     */
    public Expression(String infix) {
        this.infix = infix;
    }

    /**
     * Gets the infix expression.
     * 
     * @return The infix expression
     */
    public String getInfix() {
        return this.infix;
    }

    /**
     * Sets the infix expression.
     * 
     * @param infix The infix expression
     */
    public void setInfix(String infix) {
        this.infix = infix;
    }

    public int precedence(String operator) {
        switch (operator) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            case "(":
            case ")":
                return 0;
            case " ":
                return -2;
        }
        return -1;
    }

    /**
     * Converts this infix to postfix and returns the postfix as a list of tokens.
     * 
     * @return
     */
    public ArrayList<String> toPostfix() {
        StringTokenizer tokenizer = new StringTokenizer(infix, " ()+-*/", true);
        GenericStack<String> stack = new GenericStack<String>();
        // Stack<String> stack = new Stack<String>();
        ArrayList<String> postfix = new ArrayList<String>();
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (precedence(token) == -2) {
            } else if (precedence(token) == -1) {
                postfix.add(token);
            } else if (token == "(") {
                stack.push(token);
            } else if (token == ")") {
                String stackPop = stack.pop();
                while (stackPop != "(") {
                    postfix.add(stackPop);
                    stackPop = stack.pop();
                }
                // Pop the opening parenthesis
            } else {
                while (!stack.isEmpty() && precedence(token) <= precedence(stack.peek())) {
                    postfix.add(stack.pop());
                }
                stack.push(token);
            }
        }

        return postfix;
    }

    // public int result() {
    // StringTokenizer postfix = this.toPostfix();

    // }

    public boolean equals(Expression otherExpression) {
        return this.infix.equals(otherExpression.infix);
    }

    public String toString() {
        return getClass().getSimpleName() + ": " + infix;
    }
}
