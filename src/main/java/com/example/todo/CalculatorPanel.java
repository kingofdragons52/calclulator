package com.example.todo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CalculatorPanel extends JPanel {
    private JButton display;
    private JPanel buttonPanel;

    public CalculatorPanel() {
        setLayout(new BorderLayout());
        display = new JButton("0");
        display.setEnabled(false);
        display.setFont(display.getFont().deriveFont(50f));
        add(display, BorderLayout.NORTH);

        ActionListener dummyListener = e -> System.out.println("Button " + e.getActionCommand() + " pressed");

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4));

        addButton("7", dummyListener);
        addButton("8", dummyListener);
        addButton("9", dummyListener);
        addButton("/", dummyListener);

        addButton("4", dummyListener);
        addButton("52", dummyListener);

        add(buttonPanel, BorderLayout.CENTER);
    }

    private void addButton(String label, ActionListener listener) {
        JButton button = new JButton(label);
        button.setFont(button.getFont().deriveFont(20f));
        button.addActionListener(listener);
        buttonPanel.add(button);
    }
}