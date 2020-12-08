package rtu.lab14_16.classes.managers;

import rtu.lab14_16.classes.lists.ItemListPanel;
import rtu.lab14_16.classes.lists.OrderListPanel;
import rtu.pract15_16.managers.InternetOrderManager;
import rtu.pract15_16.managers.OrderManager;

import javax.swing.*;

public class InternetManagerPanel extends ManagerPanel {
    public InternetManagerPanel (OrderListPanel orderListPanel, ItemListPanel itemListPanel) {
        super(orderListPanel, itemListPanel, "Internet Managers", 385);

        addButton.addActionListener(actionEvent -> {
            String name = JOptionPane.showInputDialog("Enter name of new Internet Manager: ");
            if (name == null) return;

            OrderManager[] newOrderManagers = new OrderManager[orderManagers.length + 1];
            System.arraycopy(orderManagers, 0, newOrderManagers, 0, orderManagers.length);
            newOrderManagers[orderManagers.length] = new InternetOrderManager();
            orderManagers = newOrderManagers;

            String[] newOrderManagersNames = new String[orderManagersNames.length + 1];
            System.arraycopy(orderManagersNames, 0, newOrderManagersNames,
                    0, orderManagersNames.length);
            newOrderManagersNames[orderManagersNames.length] = name;
            orderManagersNames = newOrderManagersNames;

            removeButton.setEnabled(true);
            quantityLabel.setText("Quantity: " + orderManagers.length);
            tableModel.fireTableRowsInserted(orderManagersNames.length - 1, orderManagersNames.length - 1);
        });
    }
}
