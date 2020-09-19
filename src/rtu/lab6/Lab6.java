package rtu.lab6;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Lab6 extends JFrame {
    Lab6() {
        super("Lab 6");
        setSize(500, 500);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        JButton[] labels = {
                new JButton(BorderLayout.NORTH),
                new JButton(BorderLayout.WEST),
                new JButton(BorderLayout.CENTER),
                new JButton(BorderLayout.EAST),
                new JButton(BorderLayout.SOUTH)
        };
        for (var label : labels) {
            label.setVerticalAlignment(JButton.CENTER);
            label.setHorizontalAlignment(JButton.CENTER);
        }

        labels[0].addMouseListener(new MouseListener("Добро пожаловать в ..."));
        add(labels[0], BorderLayout.NORTH);

        labels[1].addMouseListener(new MouseListener("Добро пожаловать в Джидда"));
        add(labels[1], BorderLayout.WEST);

        labels[2].addMouseListener(new MouseListener("Добро пожаловать в Мир"));
        add(labels[2], BorderLayout.CENTER);

        labels[3].addMouseListener(new MouseListener("Добро пожаловать в Дахране"));
        add(labels[3], BorderLayout.EAST);

        labels[4].addMouseListener(new MouseListener("Добро пожаловать Абха"));
        add(labels[4], BorderLayout.SOUTH);

        validate();
    }

    public static void main(String[] args) {
        new Lab6();
    }

    public class MouseListener extends MouseAdapter {
        private final String message;

        public MouseListener(final String message) {
            this.message = message;
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            if (isFocused()) {
                JOptionPane.showMessageDialog(null, null,
                        message, JOptionPane.INFORMATION_MESSAGE);
            }
            super.mouseEntered(e);
        }
    }
}
