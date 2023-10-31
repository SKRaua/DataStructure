package ExpressionEvaluator;

import java.util.ArrayList;
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

    /**
     * Converts this infix to postfix and returns the postfix as a list of tokens.
     * 
     * @return The postfix expression
     */
    public ArrayList<String> toPostfix() {
        // The tokenizer for the expression
        StringTokenizer expressionTokenizer = new StringTokenizer(infix, " ()+-*/", true);
        // The stack for storing operators
        GenericStack<String> operatorStack = new GenericStack<String>();
        // The postfix expression
        ArrayList<String> postfix = new ArrayList<String>();

        // Traverses each token.
        while (expressionTokenizer.hasMoreTokens()) {
            String token = expressionTokenizer.nextToken();

            if (token.equals(" ")) {
                // Ignores spaces
                continue;
            }

            if (token.equals("(")) {
                // Pushes "(" to the stack.
                operatorStack.push(token);
            } else if (token.equals(")")) {
                // Pops operators from the stack until "(" is encountered.
                String stackPop = operatorStack.pop();
                while (!stackPop.equals("(")) {
                    // Adds the operator at the top of the stack to the postfix expression.
                    postfix.add(stackPop);
                    stackPop = operatorStack.pop();
                }
            } else {
                // The precedence of the token
                int precedence = precedence(token);
                if (precedence == 0) {
                    // Adds the operand to the postfix expression.
                    postfix.add(token);
                } else {
                    while (!operatorStack.isEmpty() && precedence <= precedence(operatorStack.peek())) {
                        // Adds the operators with a precedence greater than or equal to
                        // the token operator's precedence to the stack
                        postfix.add(operatorStack.pop());
                    }
                    // Pushes the token operator to the stack.
                    operatorStack.push(token);
                }
            }
        }
        while (!operatorStack.isEmpty()) {
            // Add the remaining operators in the stack to the postfix expression.
            postfix.add(operatorStack.pop());
        }
        return postfix;
    }

    /**
     * Calculates the result of the expression then return it.
     * 
     * @return the result of the expression
     */
    public int result() {
        // Obtains the postfix expression of the infix expression.
        ArrayList<String> postfix = this.toPostfix();
        // The stack for storing operands.
        GenericStack<Integer> operandStack = new GenericStack<Integer>();

        // Traverses each token.
        for (int i = 0; i < postfix.size(); i++) {
            String token = postfix.get(i);

            if (!"+-*/".contains(token)) {
                // Pushes the operand to the stack.
                operandStack.push(Integer.parseInt(token));
            } else {
                // Pops operand2 and operand1 from the stack.
                int operand2 = operandStack.pop();
                int operand1 = operandStack.pop();
                // performs the operation using the operator "token".
                operandStack.push(performOperation(operand1, operand2, token));
            }
        }
        // Pops the result from the stack then returns it.
        return operandStack.pop();
    }

    /**
     * Determine whether two expressions are the same
     * 
     * @param otherExpression The other expression
     * @return if two infix expressions are the same
     */
    public boolean equals(Expression otherExpression) {
        return this.infix.equals(otherExpression.infix);
    }

    /**
     * Returns a string representation of this infix expression.
     * 
     * @return A string representation of this infix expression
     */
    public String toString() {
        // return getClass().getSimpleName() + ": " + infix;

        ArrayList<String> postfixList = toPostfix();
        String postfix = new String();
        for (String item : postfixList) {
            postfix += item + " ";
        }
        return getClass().getSimpleName() + " infix: " + infix + " postfix: " + postfix;
    }

    /**
     * Determine the precedence of an operator or operand
     * 
     * @param token An operator or operand
     * @return The precedence of the operator or operand
     */
    private int precedence(String token) {
        switch (token) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
        }
        // Default precedence for operand
        return 0;
    }

    /**
     * Perform the operation with two operands and the operator
     * 
     * @param operand1 The operand1
     * @param operand2 The operand2
     * @param operator The operator between the two operands
     * @return
     */
    private int performOperation(int operand1, int operand2, String operator) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}