package apps;
import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import apps.ExpressionEvaluator;
import java.util.*;


public class Calculator{
    private static final int X_LOC = 100;
    private static final int Y_LOC = 100;
    private static final int WIDTH = 300;
    private static final int HEIGHT = 200;
    private static final String NAME = "Calculator";
    private static final String RESULT_PREAMBLE = "Result = ";
    private static final String ERROR_MESSAGE = "Error";
    private JFrame frame;


    private JLabel resultLabel;
    private JTextField infixExpression;

    public Calculator(){
        createFrame();
        initializeComponents();
        displayFrame();
    }

    public JFrame getFrame(){
    
        return frame;
    }

    private void createFrame()
    {
        frame = new JFrame();
        frame.setLocation(X_LOC,Y_LOC);
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle(NAME);
    }

    private void initializeComponents()
    {
        initializeInput();
        initializeResult();
        initializeButtons();
    }

    private void displayFrame()
    {
        frame.pack();
        frame.setVisible(true);
    }

    private void initializeInput(){
        JPanel inputPanel = new JPanel();
        infixExpression = new JTextField(6);
        inputPanel.add(infixExpression);




        frame.add(inputPanel, BorderLayout.NORTH);
    }

    private void initializeResult(){
        resultLabel = new JLabel(RESULT_PREAMBLE);
        resultLabel.setHorizontalAlignment(JLabel.CENTER);
        frame.add(resultLabel, BorderLayout.CENTER);
    }

        

    private void initializeButtons() {
        JPanel buttonPanel = new JPanel();
        JButton evaluateButton = new JButton("Evaluate");

        evaluateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculate();
            }
        });

        buttonPanel.add(evaluateButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);
    }

    private String calculate() {
        String infix = infixExpression.getText();
        String postfix = ExpressionEvaluator.toPostfix(infix);
        double resultValue = evaluatePostfix(postfix);
        //updateResult(String.valueOf(resultValue));
        return String.valueOf(resultValue);
    }

    private String toPostfix(String infix) {
        // Implement the infix to postfix conversion logic here
        // This is a placeholder implementation
        String result = ExpressionEvaluator.toPostfix(infix);


        return result;
    }

    private double evaluatePostfix(String postfix) {
        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);
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



    private void updateResult(String resultText) {
        resultLabel.setText(resultText);
    }

    public static void main(String[] args) {
        new Calculator();
    }

	
}