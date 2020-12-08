package rtu.lab14_16.classes;

import javax.swing.*;
import java.awt.*;

public class AppPanel extends JPanel {
    protected static final Font FONT = new Font("Times new roman", Font.BOLD, 15);

    public final JButton removeButton = new JButton("Remove"), addButton = new JButton("Add");
    protected final JLabel quantityLabel = new JLabel("Quantity: 0", SwingConstants.CENTER);
    protected final JPanel innerPanel = new JPanel(new BorderLayout());

    protected AppPanel (String title, int x, int y, int width, int height) {
        super(new BorderLayout());

        innerPanel.setLayout(null);
        innerPanel.setBorder(BorderFactory.createTitledBorder(title));

        addButton.setBounds(15, 25, 60, 30);
        removeButton.setBounds(85, 25, 90, 30);
        removeButton.setEnabled(false);
        innerPanel.add(removeButton);
        innerPanel.add(addButton);

        quantityLabel.setFont(FONT);
        innerPanel.add(quantityLabel);

        add(innerPanel, BorderLayout.CENTER);
        setBounds(x, y, width, height);
    }
}