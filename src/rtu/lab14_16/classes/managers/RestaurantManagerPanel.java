package rtu.lab14_16.classes.managers;

import rtu.lab14_16.classes.lists.ItemListPanel;
import rtu.lab14_16.classes.lists.OrderListPanel;
import rtu.pract15_16.managers.OrderManager;
import rtu.pract15_16.managers.RestaurantOrderManager;

import javax.swing.*;

public class RestaurantManagerPanel extends ManagerPanel {
    public RestaurantManagerPanel (OrderListPanel orderListPanel, ItemListPanel itemListPanel) {
        super(orderListPanel, itemListPanel, "Restaurant Managers", 10);

        addButton.addActionListener(actionEvent -> {
            String name = JOptionPane.showInputDialog("Enter name of new Restaurant Manager: ");
            if (name == null) return;
            int count;
            try {
                count = Integer.parseInt(JOptionPane.showInputDialog(
                        "Enter count of tables for Restaurant Manager: "));
            } catch (NumberFormatException exception) {
                JOptionPane.showMessageDialog(null, "Input was not a number!");
                return;
            }
            OrderManager[] newOrderManagers = new OrderManager[orderManagers.length + 1];
            System.arraycopy(orderManagers, 0, newOrderManagers, 0, orderManagers.length);
            newOrderManagers[orderManagers.length] = new RestaurantOrderManager(count);
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
