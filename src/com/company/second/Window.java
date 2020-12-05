package com.company.second;

import javax.swing.*;
import java.awt.*;

import static com.company.second.Area.*;

public class Window extends JFrame {

    public Window() {
        setSize(700, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label1 = new JLabel("NORTHWEST");
        label1.setBounds(16, 0, 100, 25);
        JLabel label2 = new JLabel("WEST");
        label2.setBounds(16, 200, 100, 25);
        JLabel label3 = new JLabel("SOUTHWEST");
        label3.setBounds(16, 400, 100, 25);
        JLabel label4 = new JLabel("NORTH");
        label4.setBounds(216, 0, 100, 25);
        JLabel label5 = new JLabel("CENTER");
        label5.setBounds(216, 200, 100, 25);
        JLabel label6 = new JLabel("SOUTH");
        label6.setBounds(216, 400, 100, 25);
        JLabel label7 = new JLabel("NORTHEAST");
        label7.setBounds(416, 0, 100, 25);
        JLabel label8 = new JLabel("EAST");
        label8.setBounds(416, 200, 100, 25);
        JLabel label9 = new JLabel("SOUTHEAST");
        label9.setBounds(416, 400, 100, 25);

        add(label1);
        add(label2);
        add(label3);
        add(label4);
        add(label5);
        add(label6);
        add(label7);
        add(label8);
        add(label9);

        Rectangle r = new Rectangle();
        add(r);
        setVisible(true);
        setLocationRelativeTo(null);
        Timer time = new Timer(2000, e -> {
            Point point = MouseInfo.getPointerInfo().getLocation();

            double x = point.getX() - getBounds().getLocation().x;
            double y = point.getY() - getBounds().getLocation().y;
            Area area = calculateLocation(x, y);
            switch (area) {
                case SZAO -> JOptionPane.showMessageDialog(null, "Добро пожаловать в СЗАО");
                case ZAO -> JOptionPane.showMessageDialog(null, "Добро пожаловать в ЗАО");
                case UZAO -> JOptionPane.showMessageDialog(null, "Добро пожаловать в ЮЗАО");
                case SAO -> JOptionPane.showMessageDialog(null, "Добро пожаловать в САО");
                case CAO -> JOptionPane.showMessageDialog(null, "Добро пожаловать в ЦАО");
                case UAO -> JOptionPane.showMessageDialog(null, "Добро пожаловать в ЮАО");
                case SVAO -> JOptionPane.showMessageDialog(null, "Добро пожаловать в СВАО");
                case VAO -> JOptionPane.showMessageDialog(null, "Добро пожаловать в ВАО");
                case UVAO -> JOptionPane.showMessageDialog(null, "Добро пожаловать в ЮВАО");
                default -> System.out.println("out of bounds");
            }
        });
        time.start();
    }

    private Area calculateLocation(double x, double y) {
        if (0 <= x && x < 200) {
            if (0 <= y && y <= 200) {
                return SZAO;
            } else if (200 < y && y <= 400) {
                return ZAO;
            } else if (400 < y && y <= 600) {
                return UZAO;
            }
        } else if (200 < x && x <= 400) {
            if (0 <= y && y <= 200) {
                return SAO;
            } else if (200 < y && y <= 400) {
                return CAO;
            } else if (400 < y && y <= 600) {
                return UAO;
            }
        } else if (400 < x && x <= 600) {
            if (0 <= y && y <= 200) {
                return SVAO;
            } else if (200 < y && y < 400) {
                return VAO;
            } else if (400 < y && y <= 600) {
                return UVAO;
            }
        }
        return OTHER;
    }

}