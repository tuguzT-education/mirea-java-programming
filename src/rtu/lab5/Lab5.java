package rtu.lab5;

import javax.swing.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Lab5 extends JFrame {
    private final JLabel label;
    private final ImageIcon[] imageIcons;

    Lab5() throws IOException {
        super("AnimatedFrame");
        setSize(500, 500);

        imageIcons = new ImageIcon[4];
        for (int i = 0; i < imageIcons.length; i++) {
            imageIcons[i] = new ImageIcon(ImageIO.read(new File(
                    "C:/Users/mi/Documents/IntelliJ Projects" +
                    "/RTU Java/src/rtu/lab5/frames/" + (i + 1) + ".png"))
                    .getScaledInstance(getWidth(), getHeight(), Image.SCALE_FAST));
        }
        label = new JLabel();
        label.setBounds(0, 0, getWidth(), getHeight());
        add(label);

        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        try {
            var frame = new Lab5();
            while (true) {
                for (int i = 0; i < frame.imageIcons.length; ++i) {
                    frame.label.setIcon(frame.imageIcons[i]);
                    Thread.sleep(150);
                }
                for (int i = frame.imageIcons.length - 1; i >= 0; --i) {
                    frame.label.setIcon(frame.imageIcons[i]);
                    Thread.sleep(150);
                }
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
