package com.lab5;

import javax.swing.*;
import java.awt.*;

public class AnimatedFrame extends JFrame {
    private final JLabel label;
    private final ImageIcon[] imageIcons;

    AnimatedFrame() {
        super("AnimatedFrame");
        setSize(500, 500);

        imageIcons = new ImageIcon[] {
                new ImageIcon(new ImageIcon("C:\\Users\\mi\\Documents\\IntelliJ Projects" +
                        "\\RTU Java\\src\\com\\lab5\\frames\\cursed.png").getImage()
                        .getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH)),
                new ImageIcon(new ImageIcon("C:\\Users\\mi\\Documents\\IntelliJ Projects" +
                        "\\RTU Java\\src\\com\\lab5\\frames\\timur.jpg").getImage()
                        .getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH)),
        };
        label = new JLabel();
        label.setBounds(0, 0, getWidth(), getHeight());

        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(label);
    }

    public static void main(String[] args) {
        var frame = new AnimatedFrame();
        while (true) {
            for (var imageIcon : frame.imageIcons) {
                frame.label.setIcon(imageIcon);
                try {
                    Thread.sleep(300);
                } catch (Exception e) {
                    System.out.println("Couldn't wait for 300 milliseconds!");
                    System.exit(0);
                }
            }
        }
    }
}
