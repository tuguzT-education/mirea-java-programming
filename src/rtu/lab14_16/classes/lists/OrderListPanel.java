package rtu.lab14_16.classes.lists;

import rtu.pract15_16.customers.Address;
import rtu.pract15_16.customers.Customer;
import rtu.pract15_16.managers.InternetOrderManager;
import rtu.pract15_16.managers.OrderManager;
import rtu.pract15_16.managers.RestaurantOrderManager;
import rtu.pract15_16.orders.InternetOrder;
import rtu.pract15_16.orders.Order;
import rtu.pract15_16.orders.RestaurantOrder;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Pattern;

public class OrderListPanel extends ListPanel {
    private String[] orderNames = new String[0];
    private OrderManager orderManager;

//    private final JLabel tableLabel = new JLabel("Tables: -", SwingConstants.CENTER);
    private final OrderListTableModel tableModel = new OrderListTableModel();
//    private final JButton freeTableButton = new JButton("Free Table");
    private final JTable table = new JTable(tableModel);

    public OrderListPanel (ItemListPanel itemListPanel) {
        super("List of manager's Orders (from restaurant or internet)", 330, 420);

        table.setFont(FONT);
        table.setTableHeader(null);
        table.setRowSelectionAllowed(false);
        table.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JScrollPane scrollPane = new JScrollPane(table);
        innerPanel.add(scrollPane, BorderLayout.CENTER);
        scrollPane.setBounds(15, 100, 392, 625);

        quantityLabel.setBounds(15, 65, 140, 30);
        costLabel.setBounds(155, 65, 125, 30);

//        tableLabel.setFont(FONT);
//        innerPanel.add(tableLabel);
//        tableLabel.setBounds(295, 65, 110, 30);

//        freeTableButton.setBounds(185, 25, 100, 30);
//        freeTableButton.setEnabled(false);
//        innerPanel.add(freeTableButton);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                itemListPanel.setOrder(orderManager.getOrders()[table.getSelectedRow()]);
                itemListPanel.addButton.setEnabled(true);
            }
        });

        addButton.addActionListener(actionEvent -> {
            Customer customer = getCustomer();
            if (customer == null)
                return;

            Order order;
            if (orderManager instanceof InternetOrderManager) {
                InternetOrderManager internetOrderManager = (InternetOrderManager) orderManager;
                order = new InternetOrder();
                internetOrderManager.add(order);
            } else {
                RestaurantOrderManager restaurantOrderManager = (RestaurantOrderManager) orderManager;
                int tableNumber;
                try {
                    tableNumber = Integer.parseInt(JOptionPane.showInputDialog("Enter table number:"));
                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(null, "Input was not a number!");
                    return;
                }

                try {
                    order = new RestaurantOrder();
                    restaurantOrderManager.add(tableNumber, order);
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, exception.getMessage());
                    return;
                }
            }
            order.setCustomer(customer);

            String[] newOrderNames = new String[orderNames.length + 1];
            System.arraycopy(orderNames, 0, newOrderNames,
                    0, orderNames.length);
            newOrderNames[orderNames.length] = customer.getFirstName() + ' ' +
                    customer.getSecondName() + ", age " + customer.getAge();
            orderNames = newOrderNames;

            quantityLabel.setText("Quantity: " + orderNames.length);
            costLabel.setText("Cost: " + orderManager.getTotalCost());
            tableModel.fireTableRowsInserted(orderNames.length - 1, orderNames.length - 1);

            quantityButton.setEnabled(true);
            removeButton.setEnabled(true);
        });

        removeButton.addActionListener(actionEvent -> {
            if (orderManager instanceof RestaurantOrderManager) {
                String firstName = JOptionPane.showInputDialog(
                        "Enter first name of customer of Order you want to remove: ");
                if (firstName == null)
                    return;
                String secondName = JOptionPane.showInputDialog(
                        "Enter second name of customer of Order you want to remove: ");
                if (secondName == null)
                    return;

                int age;
                try {
                    age = Integer.parseInt(JOptionPane.showInputDialog("Enter age of customer who made an Order: "));
                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(null, exception.getMessage());
                    return;
                }

                boolean found = false;
                String name = firstName + ' ' + secondName + ", age " + age;
                for (int i = 0; i < orderNames.length && !found; ++i) {
                    if (orderNames[i].equals(name)) {
                        found = true;
                        RestaurantOrderManager restaurantOrderManager = (RestaurantOrderManager) orderManager;
                        if (JOptionPane.showConfirmDialog(null,
                                "Are you sure you want to remove (FOREVER!)" +
                                        "\nan Order with Customer '" + name + "'?",
                                "Confirm your action", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                            if (orderNames.length - (i + 1) >= 0)
                                System.arraycopy(orderNames, i + 1, orderNames, i,
                                        orderNames.length - (i + 1));
                            String[] newOrderManagersNames = new String[orderNames.length - 1];
                            System.arraycopy(orderNames, 0,
                                    newOrderManagersNames, 0,
                                    newOrderManagersNames.length);
                            orderNames = newOrderManagersNames;
                            restaurantOrderManager.remove(i);

                            quantityLabel.setText("Quantity: " + orderNames.length);
                            costLabel.setText("Cost: " + orderManager.getTotalCost());
                            tableModel.fireTableRowsDeleted(orderNames.length, orderNames.length);
                        }
                    }
                }

                if (!found)
                    JOptionPane.showMessageDialog(null, "An Order with input name not found!",
                            "Nothing to remove", JOptionPane.INFORMATION_MESSAGE);
            } else {
                InternetOrderManager internetOrderManager = (InternetOrderManager) orderManager;
                Customer customer = internetOrderManager.order().getCustomer();
                String name = customer.getFirstName() + ' ' + customer.getSecondName() +
                        ", age " + customer.getAge();
                if (JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to remove (FOREVER!)" +
                                "\nan Order with Customer '" + name + "'?",
                        "Confirm your action", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    if (orderNames.length - 1 >= 0)
                        System.arraycopy(orderNames, 1, orderNames, 0,
                                orderNames.length - 1);
                    String[] newOrderManagersNames = new String[orderNames.length - 1];
                    System.arraycopy(orderNames, 0,
                            newOrderManagersNames, 0,
                            newOrderManagersNames.length);
                    orderNames = newOrderManagersNames;
                    internetOrderManager.remove();

                    quantityLabel.setText("Quantity: " + orderNames.length);
                    costLabel.setText("Cost: " + orderManager.getTotalCost());
                    tableModel.fireTableRowsDeleted(orderNames.length, orderNames.length);
                }
            }
            if (orderNames.length == 0) {
                quantityButton.setEnabled(false);
                removeButton.setEnabled(false);
            }
        });

        quantityButton.addActionListener(actionEvent -> {
            String name = JOptionPane.showInputDialog(
                    "Enter name of Item you want to find: ");
            if (name == null)
                return;

            int quantity = 0;
            for (int i = 0; i < orderNames.length; ++i)
                quantity += orderManager.getOrders()[i].getQuantity(name);

            JOptionPane.showMessageDialog(null, "Quantity of Item to find is " + quantity);
        });
    }

    private Customer getCustomer() {
        String firstName = JOptionPane.showInputDialog("Enter first name of customer who made an Order: ");
        if (firstName == null)
            return null;
        String secondName = JOptionPane.showInputDialog("Enter second name of customer who made an Order: ");
        if (secondName == null)
            return null;
        int age;
        try {
            age = Integer.parseInt(JOptionPane.showInputDialog("Enter age of customer who made an Order: "));
        } catch (NumberFormatException exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage());
            return null;
        }
        Address address = getAddress();
        if (address == null) {
            return null;
        }
        return new Customer(firstName, secondName, age, address);
    }

    public Address getAddress () {
        int zipCode, buildingNumber, apartmentNumber;
        String cityName, streetName;
        char buildingLetter;

        try {
            zipCode = Integer.parseInt(JOptionPane.showInputDialog("Enter address's zip code: "));
        } catch (NumberFormatException exception) {
            JOptionPane.showMessageDialog(null, "Input was not a number!");
            return null;
        }

        cityName = JOptionPane.showInputDialog("Enter address's city name: ");
        if (cityName == null) return null;
        streetName = JOptionPane.showInputDialog("Enter address's street name: ");
        if (streetName == null) return null;

        try {
            buildingNumber = Integer.parseInt(JOptionPane.showInputDialog("Enter address's building number: "));
        } catch (NumberFormatException exception) {
            JOptionPane.showMessageDialog(null, "Input was not a number!");
            return null;
        }

        String ch = JOptionPane.showInputDialog("Enter address's building letter: ");
        if (Pattern.matches(".", ch)) {
            buildingLetter = ch.charAt(0);
        } else {
            JOptionPane.showMessageDialog(null, "Input was not a letter!");
            return null;
        }

        try {
            apartmentNumber = Integer.parseInt(JOptionPane.showInputDialog("Enter address's apartment number: "));
        } catch (NumberFormatException exception) {
            JOptionPane.showMessageDialog(null, "Input was not a number!");
            return null;
        }

        return new Address(zipCode, cityName, streetName,
                buildingNumber, buildingLetter, apartmentNumber);
    }

    public void setOrderManager (OrderManager orderManager) {
        Order[] orderManagerOrders;
        if (this.orderManager != null) {
            orderManagerOrders = this.orderManager.getOrders();
            if (orderManagerOrders.length != 0)
                tableModel.fireTableRowsDeleted(0, orderManagerOrders.length - 1);
        }

        this.orderManager = orderManager;
        if (orderManager != null) {
            orderManagerOrders = orderManager.getOrders();
            orderNames = new String[orderManagerOrders.length];
            for (int i = 0; i < orderManagerOrders.length; ++i) {
                Customer customer = orderManagerOrders[i].getCustomer();
                orderNames[i] = customer.getFirstName() + ' ' + customer.getSecondName() +
                        ", age " + customer.getAge();
            }
            tableModel.fireTableRowsInserted(0, orderManagerOrders.length - 1);
            quantityLabel.setText("Quantity: " + orderManagerOrders.length);
            costLabel.setText("Cost: " + orderManager.getTotalCost());
        } else {
            if (orderNames.length > 0)
                tableModel.fireTableRowsDeleted(0, orderNames.length - 1);
            orderNames = new String[0];
            costLabel.setText("Cost: 0");
            quantityLabel.setText("Quantity: 0");
        }
    }

    protected class OrderListTableModel extends AbstractTableModel {
        public int getRowCount () {
            return orderNames.length;
        }

        public int getColumnCount () {
            return 1;
        }

        public Object getValueAt (int rowIndex, int columnIndex) {
            return orderNames[rowIndex];
        }
    }
}
