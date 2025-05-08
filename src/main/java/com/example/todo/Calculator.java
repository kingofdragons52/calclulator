package com.example.todo;

import javax.swing.*;
import java.awt.*;

public class Calculator {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Простой Калькулятор");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(300, 200);
                frame.setVisible(true);
                System.out.println("Калькулятор запущен!");
            }
        });
    }
}

