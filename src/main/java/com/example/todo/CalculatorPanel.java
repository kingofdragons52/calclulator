package com.example.todo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

public class CalculatorPanel extends JPanel {
    private JButton display;
    private JPanel panel;
    private BigDecimal result;
    private String lastCommand;
    private boolean start;

    public CalculatorPanel() {
        setLayout(new BorderLayout());

        result = BigDecimal.ZERO;
        lastCommand = "=";
        start = true;

        display = new JButton("0");
        display.setEnabled(false);
        display.setFont(display.getFont().deriveFont(50f));
        add(display, BorderLayout.NORTH);

        ActionListener insert = new InsertAction();
        ActionListener command = new CommandAction();

        panel = new JPanel(); 
        panel.setLayout(new GridLayout(4, 4));

        addButton("7", insert);
        addButton("8", insert);
        addButton("9", insert);
        addButton("÷", command);

        addButton("4", insert);
        addButton("5", insert);
        addButton("6", insert);
        addButton("*", command);

        addButton("1", insert);
        addButton("2", insert);
        addButton("3", insert);
        addButton("–", command);

        addButton("0", insert);
        addButton(".", insert);
        addButton("=", command);
        addButton("+", command);

        add(panel, BorderLayout.CENTER);
    }

    private void addButton(String label, ActionListener listener) {
        JButton button = new JButton(label);
        button.setFont(button.getFont().deriveFont(20f));
        button.addActionListener(listener);
        panel.add(button);
    }

    private class InsertAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String input = event.getActionCommand();
            if (start) {
                display.setText("");
                start = false;
            }
            if (input.equals(".") && display.getText().contains(".")) {
                return;
            }
            if (input.equals(".") && display.getText().isEmpty()) {
                display.setText("0.");
                return;
            }
            display.setText(display.getText() + input);
        }
    }

    private class CommandAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String command = event.getActionCommand();
            if (start) {
                if (command.equals("-")) {
                    display.setText(command);
                    start = false;
                } else {
                    lastCommand = command;
                }
            } else {
                String displayText = display.getText();
                if (displayText.isEmpty() || displayText.equals("-") || displayText.equals(".")) {
                    if (command.equals("=")) {
                    } else {
                        lastCommand = command;
                    }
                    start = true;
                    return;
                }

                try {
                    calculate(new BigDecimal(displayText));
                    lastCommand = command;
                    start = true;
                } catch (NumberFormatException e) {
                    display.setText("Error");
                    result = BigDecimal.ZERO;
                    lastCommand = "=";
                    start = true;
                } catch (ArithmeticException e) {
                    display.setText("Error (Div by 0)");
                    result = BigDecimal.ZERO;
                    lastCommand = "=";
                    start = true;
                }
            }
        }
    }

    public void calculate(BigDecimal x) {
        if (lastCommand.equals("+")) result = result.add(x);
        else if (lastCommand.equals("-") || lastCommand.equals("–")) result = result.subtract(x);
        else if (lastCommand.equals("*")) result = result.multiply(x);
        else if (lastCommand.equals("/") || lastCommand.equals("÷")) {
            if (x.compareTo(BigDecimal.ZERO) == 0) {
                throw new ArithmeticException("Division by zero");
            }
            result = result.divide(x, 10, BigDecimal.ROUND_HALF_UP);
        }
        else if (lastCommand.equals("=")) result = x;

        display.setText(result.stripTrailingZeros().toPlainString());
    }
}