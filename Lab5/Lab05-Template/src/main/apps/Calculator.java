package apps;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator
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
        JTextField leftOperand = new JTextField(5);
        inputPanel.add(leftOperand);
        JTextField rightOperand = new JTextField(5);
        
        inputPanel.add(rightOperand);
        //double x = Double.parseDouble(leftOperand.getText());
        // could use check block but i don't wanna
        //double x2 = Double.parseDouble(x);
        //double y = Double.parseDouble(rightOperand.getText());
        frame.add(inputPanel);


    }

    private void initializeResults()
    {
        JPanel resultsPanel = new JPanel();
        JLabel resultPreamble = new JLabel(RESULT_PREAMBLE);
        JLabel result = new JLabel("wow cool");

        resultsPanel.add(resultPreamble);
        resultsPanel.add(result);

        frame.add(resultsPanel);
    }

    private void initializeButtons()
    {
        JPanel buttonPanel = new JPanel();
        JButton button0 = new JButton();
        buttonPanel.add(button0);
        JButton button1 = new JButton();
        buttonPanel.add(button1);
        JButton button2 = new JButton();
        buttonPanel.add(button2);
        JButton button3 = new JButton();
        buttonPanel.add(button3);
        frame.add(buttonPanel);
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