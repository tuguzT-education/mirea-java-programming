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

        imageIcons = new ImageIcon[] {
                new ImageIcon(ImageIO.read(new File("C:/Users/mi/Documents/IntelliJ Projects" +
                        "/RTU Java/src/rtu/lab5/frames/cursed.png"))
                        .getScaledInstance(getWidth(), getHeight(), Image.SCALE_AREA_AVERAGING)),
                new ImageIcon(ImageIO.read(new File("C:/Users/mi/Documents/IntelliJ Projects" +
                        "/RTU Java/src/rtu/lab5/frames/timur.jpg"))
                        .getScaledInstance(getWidth(), getHeight(), Image.SCALE_AREA_AVERAGING))
        };
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
                for (var imageIcon : frame.imageIcons) {
                    frame.label.setIcon(imageIcon);
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException exception) {
                        System.out.println(exception.getMessage());
                        return;
                    }
                }
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
