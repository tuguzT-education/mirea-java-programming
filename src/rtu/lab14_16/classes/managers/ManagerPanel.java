package rtu.lab14_16.classes.managers;

import rtu.lab14_16.classes.AppPanel;
import rtu.lab14_16.classes.lists.ItemListPanel;
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

    public ManagerPanel (OrderListPanel orderListPanel,
                         ItemListPanel itemListPanel, String title, int y) {
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
            String name = (String) JOptionPane.showInputDialog(null,
                    "Choose name of Item to remove:", "Choose something",
                    JOptionPane.QUESTION_MESSAGE, null,
                    orderManagersNames, orderManagersNames[0]);
            if (name == null) return;

            for (int i = 0; i < orderManagersNames.length; ++i) {
                if (orderManagersNames[i].equals(name)) {
                    if (JOptionPane.showConfirmDialog(null,
                            "Are you sure you want to remove (FOREVER!)" +
                                    "\nan Item with name '" + name + "'?",
                            "Confirm your action", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        if (orderManagersNames.length - (i + 1) >= 0)
                            System.arraycopy(orderManagersNames, i + 1, orderManagersNames, i,
                                    orderManagersNames.length - (i + 1));
                        String[] newOrderManagersNames = new String[orderManagersNames.length - 1];
                        System.arraycopy(orderManagersNames, 0,
                                newOrderManagersNames, 0,
                                newOrderManagersNames.length);
                        orderManagersNames = newOrderManagersNames;

                        if (orderManagers.length - (i + 1) >= 0)
                            System.arraycopy(orderManagers, i + 1,
                                    orderManagers, i,
                                    orderManagers.length - (i + 1));
                        OrderManager[] newOrderManagers = new OrderManager[orderManagers.length - 1];
                        System.arraycopy(orderManagers, 0,
                                newOrderManagers, 0,
                                newOrderManagers.length);
                        orderManagers = newOrderManagers;

                        quantityLabel.setText("Quantity: " + orderManagersNames.length);
                        tableModel.fireTableRowsDeleted(orderManagersNames.length, orderManagersNames.length);
                        orderListPanel.setOrderManager(null);
                        itemListPanel.setOrder(null);
                        break;
                    }
                }
            }
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
