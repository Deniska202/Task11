package com.company.first;

import javax.swing.*;

public class Window extends JFrame {

    int value;
    int count;

    public Window(int value) {
        this.value = value;
        setLayout(null);
        setSize(240, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel lblAnswer = new JLabel("Ваш ответ");
        JLabel lblResult = new JLabel("Результат");

        JTextField tfInput = new JTextField();
        JLabel lblMessage = new JLabel();

        JButton btnAnswer = new JButton("Ответить");

        lblAnswer.setBounds(10, 10, 100, 25);
        lblResult.setBounds(120, 10, 100, 25);
        tfInput.setBounds(10, 40, 100, 25);
        lblMessage.setBounds(120, 40, 150, 25);
        btnAnswer.setBounds(10, 80, 100, 30);

        add(lblAnswer);
        add(lblResult);
        add(tfInput);
        add(lblMessage);
        add(btnAnswer);
        setVisible(true);
        setLocationRelativeTo(null);
        setListener(btnAnswer, tfInput, lblMessage);
    }

    private void setListener(JButton button, JTextField text, JLabel message) {
        button.addActionListener(e -> {
            try {
                int input = Integer.parseInt(text.getText());
                count += 1;
                if (input == value) {
                    message.setText("Равно");
                    JOptionPane.showMessageDialog(null, "Победа!");
                    setVisible(false);
                    System.exit(0);
                } else {
                    message.setText(value > input ? "Больше" : "Меньше");
                    if (count == 3) {
                        JOptionPane.showMessageDialog(null, "Поражение");
                        setVisible(false);
                        System.exit(0);
                    }
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Некорректное значение");
            }
        });
    }
}