package apps;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PostfixCalculatorGUI extends JFrame {
    private JTextField inputField;
    private JTextField resultField;
    private JButton evaluateButton;
    private PostfixEvaluator evaluator;

    public PostfixCalculatorGUI() {
        setTitle("Postfix Calculator");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        evaluator = new PostfixEvaluator();

        inputField = new JTextField();
        resultField = new JTextField();
        resultField.setEditable(false);

        evaluateButton = new JButton("Evaluate");
        evaluateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evaluateExpression();
            }
        });

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(new JLabel("Enter Postfix Expression:"), BorderLayout.NORTH);
        inputPanel.add(inputField, BorderLayout.CENTER);

        JPanel resultPanel = new JPanel(new BorderLayout());
        resultPanel.add(new JLabel("Result:"), BorderLayout.NORTH);
        resultPanel.add(resultField, BorderLayout.CENTER);

        add(inputPanel, BorderLayout.NORTH);
        add(evaluateButton, BorderLayout.CENTER);
        add(resultPanel, BorderLayout.SOUTH);
    }

    private void evaluateExpression() {
        String expression = inputField.getText();
        try {
            double result = evaluator.evaluate(expression);
            resultField.setText(String.valueOf(result));
        } catch (IllegalArgumentException | ArithmeticException ex) {
            resultField.setText("Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PostfixCalculatorGUI calculatorGUI = new PostfixCalculatorGUI();
            calculatorGUI.setVisible(true);
        });
    }
}
