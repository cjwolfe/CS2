package apps;

import java.util.*;
import java.util.regex.Pattern;

public class ExpressionEvaluator {
    private static final Pattern UNSIGNED_DOUBLE = Pattern.compile("((\\d+\\.?\\d*)|(\\.\\d+))([Ee][-+]?\\d+)?.*?");;
    private static final Pattern CHARACTER = Pattern.compile("\\S.*?");;

    public static String toPostfix(String expression){
        StringBuilder result = new StringBuilder();
        Scanner input = new Scanner(expression);

        Stack<Character> stack = new Stack<>();


        while (input.hasNext()) {
            String token = input.findInLine(CHARACTER);
            if (token == null){break;}

            char ch = token.charAt(0);

            if (ch == '('){
                stack.push(ch);
            } else if (Character.isDigit(ch) || ch == '.'){
                result.append(token).append(' ');
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/'){
                while(!stack.isEmpty() && precedence(stack.peek()) >= precedence(ch)){
                    result.append(stack.pop()).append(' ');
                }
                stack.push(ch);
            } else if (ch ==')') {
                while(!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop()).append(' ');
                }
                if (stack.isEmpty()) {
                    return "Error: Unbalanced parentheses";
                }
                stack.pop(); // discard the left parenthesis
            }

            while (!stack.isEmpty()) {
                if (stack.peek() == '(') {
                    return "Error: Unbalanced parentheses";
                }
                result.append(stack.pop()).append(' ');
            }
        }
            input.close();
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

    private double evaluate(String postfixExpression) {
        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < postfixExpression.length(); i++) {
            char c = postfixExpression.charAt(i);
            if (Character.isDigit(c)) {
                stack.push((double) (c - '0'));
            } else {
                double val1 = stack.pop();
                double val2 = stack.pop();
                switch (c) {
                    case '+':
                        stack.push(val2 + val1);
                        break;
                    case '-':
                        stack.push(val2 - val1);
                        break;
                    case '*':
                        stack.push(val2 * val1);
                        break;
                    case '/':
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
