package rtu.lab14_16.classes.lists;

import rtu.lab14_16.classes.AppPanel;

import javax.swing.*;

public class ListPanel extends AppPanel {
    protected final JLabel costLabel = new JLabel("Cost: 0", SwingConstants.CENTER);
    protected final JButton quantityButton = new JButton("Item Quantity");

    public ListPanel (String title, int x, int width) {
        super(title, x, 10, width, 740);
        addButton.setEnabled(false);

        quantityButton.setBounds(width - 125, 25, 110, 30);
        quantityButton.setEnabled(false);
        innerPanel.add(quantityButton);

        costLabel.setFont(FONT);
        innerPanel.add(costLabel);
    }
}