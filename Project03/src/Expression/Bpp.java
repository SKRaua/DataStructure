package Expression;
import java.util.Stack;

public class Bpp {
    public static void main(String[] args) throws Exception {
        String expression = " ((A + (B * C)) + D)";
        String prefixString = evaluateInfixToPrefix(expression);
        System.out.println("Infix: " + expression);
        System.out.println("Prefix: " + prefixString);
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

    public static String evaluateInfixToPrefix(String expression) {
        // Step 1: Reverse the input expression
        StringBuilder reversedExpression = new StringBuilder(expression).reverse();

        // Step 2: Modify operator precedence
        StringBuilder modifiedExpression = new StringBuilder();
        for (int i = 0; i < reversedExpression.length(); i++) {
            char token = reversedExpression.charAt(i);
            if (token == '(') {
                modifiedExpression.append(')');
            } else if (token == ')') {
                modifiedExpression.append('(');
            } else {
                modifiedExpression.append(token);
            }
        }

        Stack<Character> stack = new Stack<>();
        StringBuilder prefixString = new StringBuilder();

        for (int i = 0; i < modifiedExpression.length(); i++) {
            char token = modifiedExpression.charAt(i);
            if (token == ' ') {
            } else if (Character.isLetter(token)) {
                prefixString.append(token);
            } else if (token == '(') {
                stack.push(token);
            } else if (token == ')') {
                char stackPop = stack.pop();
                while (stackPop != '(') {
                    prefixString.append(stackPop);
                    stackPop = stack.pop();
                }
            } else {
                while (!stack.isEmpty() && precedence(token) < precedence(stack.peek())) {
                    prefixString.append(stack.pop());
                }
                stack.push(token);
            }
        }

        while (!stack.isEmpty()) {
            prefixString.append(stack.pop());
        }

        // Step 3: Reverse the prefix expression to get the final result
        return prefixString.reverse().toString();
    }
}
