package apps;
import javax.swing.*;


public class Calculator{
    private static final int X_LOC = 100;
    private static final int Y_LOC = 100;
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;
    private static final String NAME = "Calculator";
    private static final String RESULT_PREAMBLE = "Result = ";
    private static final String ERROR_MESSAGE = "Error";
    private JFrame frame;

    private JTextField infixExpression;
    private JLabel resultLabel;

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
        //remember to uncomment above
        frame.setVisible(true);
    }

    private void initializeInput(){
        JPanel inputPanel = new JPanel();
        JTextField leftOperand = new JTextField(6);
        inputPanel.add(leftOperand);
        JTextField rightOperand = new JTextField(5);
        inputPanel.add(rightOperand);



        frame.add(inputPanel);
    }

    private void initializeResult(){
        JPanel resultLabel = new JPanel();
        JLabel resultPreamble = new JLabel(RESULT_PREAMBLE);
        JLabel result = new JLabel("wow cool");

        resultLabel.add(resultPreamble);
        resultLabel.add(result);

        // frame.add(resultLabel, BorderLayout.EAST);
    }

    private void initializeButtons(){}

    private String calculate(){
    
        String result = "";
        return result;
    }

    private void updateResult(String result){}

    

	
}