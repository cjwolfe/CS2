package apps;

import java.util.*;
import java.util.regex.Pattern;

public class ExpressionEvaluator {
    private static final Pattern UNSIGNED_DOUBLE = Pattern.compile("((\\d+\\.?\\d*)|(\\.\\d+))([Ee][-+]?\\d+)?.*?");;
    private static final Pattern CHARACTER = Pattern.compile("\\S.*?");;

    public static String toPostfix(String expression) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        StringTokenizer tokenizer = new StringTokenizer(expression, "()+-*/ ", true);
        boolean lastWasOperand = false;
        boolean lastWasOperator = false;

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken().trim();
            if (token.isEmpty()) {
                continue;
            }

            char ch = token.charAt(0);

            if (ch == '(') {
                stack.push(ch);
                lastWasOperand = false;
                lastWasOperator = false;
            } else if (Character.isDigit(ch)) {
                // Read the entire number
                result.append(token).append(' ');
                if (lastWasOperand) {
                    return "Error: Missing operator";
                }
                lastWasOperand = true;
                lastWasOperator = false;
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                if (lastWasOperator) {
                    return "Error: Missing operand";
                }
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(ch)) {
                    result.append(stack.pop()).append(' ');
                }
                stack.push(ch);
                lastWasOperand = false;
                lastWasOperator = true;
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop()).append(' ');
                }
                if (stack.isEmpty()) {
                    return "Error: Unbalanced parentheses";
                }
                stack.pop(); // discard the left parenthesis
                lastWasOperand = true;
                lastWasOperator = false;
            } else {
                return "Error: Invalid character";
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                return "Error: Unbalanced parentheses";
            }
            result.append(stack.pop()).append(' ');
        }

        return result.toString().trim();
    }



    private static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return -1;
        }
    }

    public static double evaluate(String postfix) {
        Stack<Double> stack = new Stack<>();
        StringTokenizer tokenizer = new StringTokenizer(postfix);

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();

            if (token.matches("-?\\d+(\\.\\d+)?")) {
                stack.push(Double.parseDouble(token));
            } else {
                double val1 = stack.pop();
                double val2 = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(val2 + val1);
                        break;
                    case "-":
                        stack.push(val2 - val1);
                        break;
                    case "*":
                        stack.push(val2 * val1);
                        break;
                    case "/":
                        stack.push(val2 / val1);
                        break;
                }
            }
        }

        return stack.pop();
    }

    private static boolean higherPrecedence(char current, char top){
        return (top == '*' || top == '/') && (current == '+' || current == '-');
    }

}
