package apps;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Calculator //extends JFrame 
{
	private final static int X_LOC = 100;
    private final static int Y_LOC = 100;
    private final static int WIDTH = 400;
    private final static int HEIGHT = 400;
    private final static String NAME = "Cool Calculator";
    private final static String RESULT_PREAMBLE = "Result = ";
    private final static String ERROR_MESSAGE = "Error";
    private JTextField leftOperand;
    private JTextField rightOperand;

    private JFrame frame;
    // private JTextField leftOpField;
    // private JTextField rightOpField;
    // private JLabel resultLabel;

    public Calculator()
    {
        //JFrame frame = new JFrame();
        createFrame();
        initializeComponents();
        displayFrame();
        //JTextField leftOpField = new JTextField


        // frame.add(leftOpField);
        // frame.add(rightOpField);





        
    }
    // Implement the actionPerformed method required by the ActionListener interface
    public void actionPerformed(ActionEvent e) {
        // Add your code here to handle the action events
    }

    public JFrame getFrame()
    {
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
        initializeInputs();
        initializeResults();
        initializeButtons();
    }

    private void displayFrame()
    {
        frame.pack();
        //remember to uncomment above
        frame.setVisible(true);
    }
    
    private void initializeInputs()
    {
        // JPanel inputPanel = new JPanel();
        // frame.setLayout(FlowLayout);
        JPanel inputPanel = new JPanel();
        leftOperand = new JTextField(6);
        inputPanel.add(leftOperand);
        rightOperand = new JTextField(5);
        inputPanel.add(rightOperand);



        frame.add(inputPanel);


    }

    private void initializeResults()
    {
        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new FlowLayout());

        JLabel resultPreamble = new JLabel(RESULT_PREAMBLE);
        JLabel result = new JLabel();

        resultPanel.add(resultPreamble);
        resultPanel.add(result);

        frame.add(resultPanel, BorderLayout.EAST);
    }
        

    private void initializeButtons()
    {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 2, 10, 10));

        JButton addButton = new JButton("ADD");
        JButton subButton = new JButton("SUB");
        JButton multButton = new JButton("MULT");
        JButton divButton = new JButton("DIV");

        buttonPanel.add(addButton);
        buttonPanel.add(subButton);
        buttonPanel.add(multButton);
        buttonPanel.add(divButton);

        addButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                performOperation('+');
                double result = getLeftNum() + getRightNum();
                updateResult(result);
            }
        });
        subButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                performOperation('-');
                double result = getLeftNum() - getRightNum();
                updateResult(result);
            }
        });

        multButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                performOperation('*');
                double result = getLeftNum() * getRightNum();
                updateResult(result);
            }
        });

        divButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                performOperation('/');
                double result = getLeftNum() / getRightNum();
                updateResult(result);
            }
        });


        

        frame.add(buttonPanel, BorderLayout.SOUTH);

        
    }
    
    private void performOperation(char operator) {
        double num1 = getLeftNum(); // Assuming you have getLeftNum()
        double num2 = getRightNum(); // Assuming you have getRightNum()
        double result = 0;

        switch (operator) {
            case '+' -> result = num1 + num2;
            case '-' -> result = num1 - num2;
            case '*' -> result = num1 * num2;
            case '/' -> { 
                if (num2 == 0) {
                    result = Double.NaN;
                } else {
                    result = num1 / num2;
                }
                }
        }

        // Update result on the display
        updateResult(result);
    }


    
    private double getLeftNum()
    {
        return Double.parseDouble(leftOperand.getText());
    }
    private double getRightNum()
    {
        return Double.parseDouble(rightOperand.getText());
    }
    private void updateResult(double result)
    {
        // Update the result here
    }







}