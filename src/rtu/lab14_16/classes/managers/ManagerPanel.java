package rtu.lab14_16.classes.managers;

import rtu.lab14_16.classes.AppPanel;
import rtu.lab14_16.classes.lists.ItemListPanel;
import rtu.lab14_16.classes.lists.ListPanel;
import rtu.lab14_16.classes.lists.OrderListPanel;
import rtu.pract15_16.managers.OrderManager;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ManagerPanel extends AppPanel {
    protected OrderManager[] orderManagers = new OrderManager[0];
    protected String[] orderManagersNames = new String[0];

    protected final ManagerTableModel tableModel = new ManagerTableModel();
    protected final JTable table = new JTable(tableModel);
    protected final OrderListPanel orderListPanel;
    protected final ItemListPanel itemListPanel;

    public ManagerPanel (OrderListPanel orderListPanel, ItemListPanel itemListPanel, String title, int y) {
        super(title, 15, y, 300, 365);
        this.orderListPanel = orderListPanel;
        this.itemListPanel = itemListPanel;

        quantityLabel.setBounds(185, 25, 95, 30);
        table.setFont(FONT);
        table.setTableHeader(null);
        table.setRowSelectionAllowed(false);
        table.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JScrollPane scrollPane = new JScrollPane(table);
        innerPanel.add(scrollPane, BorderLayout.CENTER);
        scrollPane.setBounds(15, 60, 272, 290);

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                orderListPanel.setOrderManager(orderManagers[table.getSelectedRow()]);
                itemListPanel.setOrder(null);
                orderListPanel.addButton.setEnabled(true);
            }
        });

        removeButton.addActionListener(actionEvent -> {
            String name = JOptionPane.showInputDialog("Enter name of Manager you want to remove: ");
            boolean found = false;

            for (int i = 0; i < orderManagersNames.length && !found; ++i)
                if (orderManagersNames[i].equals(name)) {
                    found = true;
                    if (JOptionPane.showConfirmDialog(null,
                            "Are you sure you want to remove (FOREVER!)\na Manager with name '" + name + "'?",
                            "Confirm your action", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        if (orderManagersNames.length - (i + 1) >= 0)
                            System.arraycopy(orderManagersNames, i + 1,
                                    orderManagersNames, i,
                                    orderManagersNames.length - (i + 1));
                        String[] newOrderManagersNames = new String[orderManagersNames.length - 1];
                        System.arraycopy(orderManagersNames, 0,
                                newOrderManagersNames, 0,
                                newOrderManagersNames.length);
                        orderManagersNames = newOrderManagersNames;
                        tableModel.fireTableRowsDeleted(orderManagersNames.length, orderManagersNames.length);

                        if (orderManagers.length - (i + 1) >= 0)
                            System.arraycopy(orderManagers, i + 1,
                                    orderManagers, i,
                                    orderManagers.length - (i + 1));
                        OrderManager[] newOrderManagers = new OrderManager[orderManagers.length - 1];
                        System.arraycopy(orderManagers, 0,
                                newOrderManagers, 0,
                                newOrderManagers.length);
                        orderManagers = newOrderManagers;

                        quantityLabel.setText("Quantity: " + orderManagers.length);
                        tableModel.fireTableRowsDeleted(orderManagers.length, orderManagers.length);
                        orderListPanel.setOrderManager(null);
                        itemListPanel.setOrder(null);
                    }
                }
            if (!found && name != null)
                JOptionPane.showMessageDialog(null, "An Order Manager with " +
                                "input name not found!", "Nothing to remove", JOptionPane.INFORMATION_MESSAGE);
            if (orderManagersNames.length == 0)
                removeButton.setEnabled(false);
        });
    }

    protected class ManagerTableModel extends AbstractTableModel {
        public int getRowCount() {
            return orderManagersNames.length;
        }

        public int getColumnCount () {
            return 1;
        }

        public Object getValueAt (int rowIndex, int columnIndex) {
            return orderManagersNames[rowIndex];
        }
    }
}