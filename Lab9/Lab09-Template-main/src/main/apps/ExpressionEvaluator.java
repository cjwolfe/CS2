package apps;

import java.util.*;
import java.util.regex.Pattern;

public class ExpressionEvaluator {
    private static final Pattern UNSIGNED_DOUBLE = Pattern.compile("((\\d+\\.?\\d*)|(\\.\\d+))([Ee][-+]?\\d+)?.*?");;
    private static final Pattern CHARACTER = Pattern.compile("\\S.*?");;

    public static String toPostfix(String expression){
        String result = "";
        Scanner input = new Scanner(expression);

        Stack<Integer> stack = new Stack<>();


        while (input.hasNext()) {
            //String token = input.next();
            try {
                while (input.hasNext()){                
                if (input.hasNext(UNSIGNED_DOUBLE)) {
                    stack.push(Integer.parseInt(input.next()));
                } else if (true) {
                    result += input.findInLine(UNSIGNED_DOUBLE);
                }

            }
            } catch (Exception e) {
                return null;
            }
        }

        input.close();

        

//         do
//    if (the next input is a left parenthesis)
//       Read the left parenthesis and push it onto the stack.
//    else if (the next input is a number or other operand)
//       Read the operand and write it to the output.
//    else if (the next input is one of the operation symbols)
//    {
//       Pop and print operations off the stack until one of three things occurs: (1) The
//       stack becomes empty, (2) the next symbol on the stack is a left parenthesis,
//       or (3) the next symbol on the stack is an operation with lower precedence than
//       the next input symbol. When one of these situations occurs, stop popping, read
//       the next input symbol, and push this symbol onto the stack.
//    }
//    else
//    {
//       Read and discard the next input symbol (which should be a right parenthesis).
//       Pop and print operations off the stack until the next symbol on the stack is a
//       left parenthesis. (If no left parenthesis is encountered, then print an error message
//       indicating unbalanced parentheses and halt.) Finally, pop and discard the
//       left parenthesis.
//    }
// while (there is more of the expression to read);



        return result;
    }

    public static double evaluate(String postfixExpression){
        double result = 0;

        return result;
    
    }

    private static boolean higherPrecedence(char current, char top){
        return (top == '*' || top == '/') && (current == '+' || current == '-');
    }

}
