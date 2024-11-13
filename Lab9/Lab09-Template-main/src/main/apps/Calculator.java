package apps;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


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

    //working
    public Calculator(){
        createFrame();
        initializeComponents();
        displayFrame();
    }

    //working
    public JFrame getFrame(){
    
        return frame;
    }

    //working
    private void createFrame()
    {
        frame = new JFrame();
        frame.setLocation(X_LOC,Y_LOC);
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle(NAME);
    }

    //working
    private void initializeComponents()
    {
        initializeInput();
        initializeResult();
        initializeButtons();
    }

    //working
    private void displayFrame()
    {
        frame.pack();
        frame.setVisible(true);
    }

    //working
    private void initializeInput() {
        JPanel inputPanel = new JPanel();
        infixExpression = new JTextField(20);
        infixExpression.setName("infixExpression"); // Set the name for the infix expression text field
        inputPanel.add(infixExpression);
        frame.add(inputPanel, BorderLayout.NORTH);
    }

    //likely working, but in the middle it should get the result?
    private void initializeResult() {
        JPanel resultPanel = new JPanel();
        JLabel resultPreamble = new JLabel(RESULT_PREAMBLE);
        resultPreamble.setName("resultPreamble"); 
        resultLabel = new JLabel(""); 
        resultLabel.setName("resultLabel"); 
        resultPanel.add(resultPreamble);
        resultPanel.add(resultLabel);
        frame.add(resultPanel, BorderLayout.CENTER);
    }
        
    //likely working
    private void initializeButtons() {
        JPanel buttonPanel = new JPanel();
        JButton calculateButton = new JButton("Evaluate");
        calculateButton.setName("calculateButton");
    
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String result = calculate();
                updateResult(result);
            }
        });

        JButton clearButton = new JButton("Clear");
        clearButton.setName("clearButton"); 

        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                infixExpression.setText("");
                updateResult("");
            }
        });
    
        buttonPanel.add(calculateButton);
        buttonPanel.add(clearButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);
    }
    
    //likely working
    private String calculate() {
        try {
            String infix = infixExpression.getText();
            String postfix = ExpressionEvaluator.toPostfix(infix);
            if (postfix.contains("Error")) {
                return postfix;
            }
            double resultValue = ExpressionEvaluator.evaluate(postfix);
            return String.valueOf(resultValue);
        } catch (Exception e) {
            return ERROR_MESSAGE;
        }
    }

    private String toPostfix(String infix) {

        String result = ExpressionEvaluator.toPostfix(infix);


        return result;
    }

    private double evaluatePostfix(String postfix) {
        double result = ExpressionEvaluator.evaluate(postfix);
        return result;
    }


    //likely working
    private void updateResult(String resultText) {
        resultLabel.setText(resultText);
    }

    public static void main(String[] args) {
        new Calculator();
    }

	
}