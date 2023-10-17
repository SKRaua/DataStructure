import java.util.Stack;

public class App {
    public static void main(String[] args) throws Exception {
        String expression = "a-(b+c*d)/e";
        String postfixString = evaluateInfixToPostfix(expression);
        System.out.println("Infix: " + expression);
        System.out.println("Postfix: " + postfixString);
    }

    // public static String evaluatePrefix(String expression) {
    // char[] stack = new char[20];
    // String postfixString = new String();

    // for (int i = 0; i < expression.length(); i++) {
    // char token = stack[i];
    // if (token == '('||token == ')'||token == '*' || token == '/' || token == '+'
    // || token == '-') {
    // String operand1 =

    // }else if (token > 96 || token < 123) {
    // postfixString += token;
    // }
    // }
    // }

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

            if (Character.isLetter(token)) {
                postfixString.append(token);
            } else if (token == '(') {
                stack.push(token);
            } else if (token == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfixString.append(stack.pop());
                }
                stack.pop(); // Pop the opening parenthesis
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
