package com.company.third;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

public class Window extends JFrame {

    Window() {
        setLayout(null);
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel lblYourText = new JLabel("Ваш текст:");
        JLabel lblChooseColor = new JLabel("Выберите цвет:");
        JLabel lblChooseFont = new JLabel("Выберите шрифт:");

        JTextArea text = new JTextArea();

        JComboBox<String> cbColor = new JComboBox<>();
        cbColor.addItem("Красный");
        cbColor.addItem("Синий");
        cbColor.addItem("Черный");

        JComboBox<String> cbFont = new JComboBox<>();
        cbFont.addItem("Times New Roman");
        cbFont.addItem("MS Sans Serif");
        cbFont.addItem("Courier New");

        lblYourText.setBounds(10, 10, 100, 25);
        text.setBounds(10, 30, 500, 130);
        lblChooseColor.setBounds(10, 180, 150, 25);
        cbColor.setBounds(10, 200, 200, 25);

        lblChooseFont.setBounds(220, 180, 150, 25);
        cbFont.setBounds(220, 200, 200, 25);


        add(lblYourText);
        add(lblChooseColor);
        add(lblChooseFont);
        add(text);
        add(cbFont);
        add(cbColor);

        setVisible(true);
        setLocationRelativeTo(null);

        text.setFont(getFontByName(cbFont.getItemAt(0)));
        text.setForeground(getColorByName(cbColor.getItemAt(0)));

        cbColor.addItemListener((ItemEvent e) -> {
            Object item = e.getItem();
            text.setForeground(getColorByName((String) item));
        });

        cbFont.addItemListener((ItemEvent e) -> {
            Object item = e.getItem();
            text.setFont(getFontByName((String) item));
        });
    }

    private Color getColorByName(String name) {
        if (name.equals("Красный")) {
            return Color.RED;
        } else if (name.equals("Синий")) {
            return Color.BLUE;
        } else {
            return Color.BLACK;
        }
    }

    private Font getFontByName(String name) {
        return new Font(name, Font.PLAIN, 16);
    }
}