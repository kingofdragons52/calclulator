package com.example.todo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener; // Добавим импорт

public class CalculatorPanel extends JPanel {
    private JButton display;
    private JPanel buttonPanel; // Добавим поле для панели кнопок

    public CalculatorPanel() {
        setLayout(new BorderLayout());
        display = new JButton("0"); // Присвоим полю display
        display.setEnabled(false);
        display.setFont(display.getFont().deriveFont(50f));
        add(display, BorderLayout.NORTH);
        // System.out.println("Панель инициализирована");

        // ActionListener заглушка, пока не реализуем логику
        ActionListener dummyListener = e -> System.out.println("Button " + e.getActionCommand() + " pressed");

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4)); // Сетка для кнопок

        addButton("7", dummyListener);
        addButton("8", dummyListener);
        addButton("9", dummyListener);
        addButton("/", dummyListener); // Используем / для деления

        addButton("4", dummyListener);
        // ... и так далее для остальных кнопок, можно не все для теста

        add(buttonPanel, BorderLayout.CENTER); // Добавляем панель кнопок
    }

    // Новый метод
    private void addButton(String label, ActionListener listener) {
        JButton button = new JButton(label);
        button.setFont(button.getFont().deriveFont(20f));
        button.addActionListener(listener);
        buttonPanel.add(button);
    }
}