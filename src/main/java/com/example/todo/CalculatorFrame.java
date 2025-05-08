package com.example.todo;

import javax.swing.*;
import java.awt.*;

public class CalculatorFrame extends JFrame {
    public CalculatorFrame() {
        setTitle("Калькулятор v0.3"); // Изменение 1: версия
        CalculatorPanel panel = new CalculatorPanel(); // Изменение 2: добавили панель
        add(panel);
        pack();
        // setSize(350, 100); // Изменение 4: Закомментируем setSize, pack должен справиться
        setLocationRelativeTo(null);
    }
}