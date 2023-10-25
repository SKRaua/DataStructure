package b;

import java.util.Stack;

public class ExpressionConverter {
    // 判断是否是表达式
    public static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    // 是否有更高级别的操作符
    public static boolean hasHigherPrecedence(char op1, char op2) {
        int op1Weight = getOperatorWeight(op1);
        int op2Weight = getOperatorWeight(op2);
        return op1Weight >= op2Weight;
    }

    // 返回表达式的优先级
    public static int getOperatorWeight(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }

    // 中缀转换为后缀表达式
    public static String infixToPostfix(String infixExpression) {
        StringBuilder postfixExpression = new StringBuilder();
        Stack<Character> operatorStack = new Stack<>();

        for (int i = 0; i < infixExpression.length(); i++) {
            // 拿到当前的char
            char currentChar = infixExpression.charAt(i);
            // 是字母或者数字吗
            if (Character.isLetterOrDigit(currentChar)) {
                postfixExpression.append(currentChar);
                // 是操作符吗
            } else if (isOperator(currentChar)) {
                while (!operatorStack.isEmpty() && operatorStack.peek() != '('
                        && hasHigherPrecedence(operatorStack.peek(), currentChar)) {
                    postfixExpression.append(operatorStack.pop());
                }
                operatorStack.push(currentChar);
            } else if (currentChar == '(') {
                operatorStack.push(currentChar);
            } else if (currentChar == ')') {
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    postfixExpression.append(operatorStack.pop());
                }
                if (!operatorStack.isEmpty() && operatorStack.peek() == '(') {
                    operatorStack.pop();
                }
            }
        }
        while (!operatorStack.isEmpty()) {
            postfixExpression.append(operatorStack.pop());
        }

        return postfixExpression.toString();
    }

    // 中缀转换为前缀表达式
    public static String infixToPrefix(String infixExpression) {
        StringBuilder prefixExpression = new StringBuilder();
        Stack<Character> operatorStack = new Stack<>();

        for (int i = infixExpression.length() - 1; i >= 0; i--) {
            char currentChar = infixExpression.charAt(i);
            if (Character.isLetterOrDigit(currentChar)) {
                prefixExpression.insert(0, currentChar);
            } else if (isOperator(currentChar)) {
                while (!operatorStack.isEmpty() && operatorStack.peek() != ')'
                        && hasHigherPrecedence(operatorStack.peek(), currentChar)) {
                    prefixExpression.insert(0, operatorStack.pop());
                }
                operatorStack.push(currentChar);
            } else if (currentChar == ')') {
                operatorStack.push(currentChar);
            } else if (currentChar == '(') {
                while (!operatorStack.isEmpty() && operatorStack.peek() != ')') {
                    prefixExpression.insert(0, operatorStack.pop());
                }

                if (!operatorStack.isEmpty() && operatorStack.peek() == ')') {
                    operatorStack.pop();
                }
            }
        }
        while (!operatorStack.isEmpty()) {
            prefixExpression.insert(0, operatorStack.pop());
        }
        return prefixExpression.toString();
    }

    // 主函数入口
    public static void main(String[] args) {
        String infixExpression = "3+4*5-6";
        String postfixExpression = infixToPostfix(infixExpression);
        String prefixExpression = infixToPrefix(infixExpression);

        System.out.println("Infix Expression: " + infixExpression);
        System.out.println("Postfix Expression: " + postfixExpression);
        System.out.println("Prefix Expression: " + prefixExpression);
    }
}
