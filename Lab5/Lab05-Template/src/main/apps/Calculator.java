package apps;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Calculator //extends JFrame 
{
	private final int X_LOC = 100;
    private final int Y_LOC = 100;
    private final int WIDTH = 400;
    private final int HEIGHT = 400;
    private final String NAME = "Cool Calculator";
    private final String RESULT_PREAMBLE = "Result = ";
    private final String ERROR_MESSAGE = "Error";

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
        JTextField leftOperand = new JTextField(6);
        inputPanel.add(leftOperand);
        JTextField rightOperand = new JTextField(5);
        inputPanel.add(rightOperand);



        frame.add(inputPanel);


    }

    private void initializeResults()
    {
        JPanel resultLabel = new JPanel();
        JLabel resultPreamble = new JLabel(RESULT_PREAMBLE);
        JLabel result = new JLabel("wow cool");

        resultLabel.add(resultPreamble);
        resultLabel.add(result);

        frame.add(resultLabel, BorderLayout.EAST);
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
            }
        });
        subButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                performOperation('-');
            }
        });

        multButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                performOperation('*');
            }
        });

        divButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                performOperation('/');
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
        return 1.0;
    }
    private double getRightNum()
    {
        return 1.0;
    }
    private void updateResult(double result)
    {
        

    }







}