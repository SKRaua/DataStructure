package Expression;

import java.util.Stack;

public class App {
    public static void main(String[] args) throws Exception {
        // String expression = "a-(b+c*d)/e"; ((A + (B * C)) + D) a - (b + c)/d + e
        String expression = "A * ( (B + C) + D)";
        String postfixString = evaluateInfixToPostfix(expression);
        System.out.println("Infix: " + expression);
        System.out.println("Postfix: " + postfixString);
    }

    public static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return 0;
    }

    public static String evaluateInfixToPostfix(String expression) {
        Stack<Character> stack = new Stack<>();
        StringBuilder postfixString = new StringBuilder();

        for (int i = 0; i < expression.length(); i++) {
            char token = expression.charAt(i);
            if (token == ' ') {
            } else if (Character.isLetter(token)) {
                postfixString.append(token);
            } else if (token == '(') {
                stack.push(token);
            } else if (token == ')') {
                char stackPop = stack.pop();
                while (stackPop != '(') {
                    postfixString.append(stackPop);
                    stackPop = stack.pop();
                }
                // Pop the opening parenthesis
            } else {
                while (!stack.isEmpty() && precedence(token) <= precedence(stack.peek())) {
                    postfixString.append(stack.pop());
                }
                stack.push(token);
            }
        }

        while (!stack.isEmpty()) {
            postfixString.append(stack.pop());
        }

        return postfixString.toString();
    }
}
