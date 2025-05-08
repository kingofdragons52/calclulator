package com.example.todo;

import javax.swing.*;
import java.awt.*;

public class CalculatorFrame extends JFrame { // Сделали класс public
    public CalculatorFrame() {
        setTitle("Калькулятор v0.2");
        // CalculatorPanel panel = new CalculatorPanel();
        // add(panel);
        pack();
        setSize(350, 100);
        setLocationRelativeTo(null);
    }
}