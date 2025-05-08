package com.example.todo;

import javax.swing.*;
import java.awt.*;

public class CalculatorPanel extends JPanel {
    public CalculatorPanel() {
        setLayout(new BorderLayout());
        JButton display = new JButton("0");
        display.setEnabled(false);
        display.setFont(display.getFont().deriveFont(50f));
        add(display, BorderLayout.NORTH);
        System.out.println("Панель инициализирована"); // Для демонстрации
    }
}