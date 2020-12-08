package rtu.lab14_16.classes.lists;

import rtu.pract15_16.items.Dish;
import rtu.pract15_16.items.Drink;
import rtu.pract15_16.items.Item;
import rtu.pract15_16.orders.Order;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;

public class ItemListPanel extends ListPanel {
    private String[] itemNames = new String[0];
    private Order order;

    private final ItemListTableModel tableModel = new ItemListTableModel();
    private final JButton itemSortButton = new JButton("Item Sort");
    private final JTable table = new JTable(tableModel);

    public ItemListPanel () {
        super("List of order's Items (drinks and dishes)", 765, 405);

        table.setFont(FONT);
        table.setTableHeader(null);
        table.setRowSelectionAllowed(false);
        table.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JScrollPane scrollPane = new JScrollPane(table);
        innerPanel.add(scrollPane, BorderLayout.CENTER);
        scrollPane.setBounds(15, 100, 377, 625);

        itemSortButton.setBounds(185, 25, 85, 30);
        itemSortButton.setEnabled(false);
        innerPanel.add(itemSortButton);

        costLabel.setBounds(218, 65, 143, 30);
        quantityLabel.setBounds(15, 65, 203, 30);

        itemSortButton.addActionListener(actionEvent -> {
            Item[] items = order.getItemsSorted();
            for (int i = 0; i < itemNames.length; ++i) {
                itemNames[i] = items[i].getName();
            }
            tableModel.fireTableRowsUpdated(0, itemNames.length - 1);
        });

        addButton.addActionListener(actionEvent -> {
            String name, description;
            double cost;

            String string = JOptionPane.showInputDialog
                    ("Enter type of Item you want to add in Order:\nDrink or Dish.");
            if ("drink".equalsIgnoreCase(string)) {
                name = JOptionPane.showInputDialog("Enter name of the Drink: ");
                if (name == null) return;
                description = JOptionPane.showInputDialog("Enter description of the Drink: ");
                if (description == null) return;

                double alcoholByVolume;
                try {
                    cost = Double.parseDouble(JOptionPane.showInputDialog("Enter cost of the Drink: "));
                    alcoholByVolume = Double.parseDouble(JOptionPane.showInputDialog
                            ("Enter alcohol volume of the Drink:"));
                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(null, "Input was not a number!");
                    return;
                }

                Drink.DrinkType type;
                try {
                    type = Drink.DrinkType.valueOf(JOptionPane.showInputDialog
                            ("Enter type of the Drink: ").toUpperCase());
                } catch (IllegalArgumentException exception) {
                    JOptionPane.showMessageDialog(null,
                            "Input was not a type of the Drink!");
                    return;
                }

                try {
                    order.add(new Drink(cost, name, description, alcoholByVolume, type));
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, exception.getMessage());
                    return;
                }

                String[] newItemNames = new String[itemNames.length + 1];
                System.arraycopy(itemNames, 0, newItemNames,
                        0, itemNames.length);
                newItemNames[itemNames.length] = name;
                itemNames = newItemNames;

                costLabel.setText("Cost: " + order.getTotalCost());
                quantityLabel.setText("Quantity: " + itemNames.length);
                tableModel.fireTableRowsInserted(itemNames.length - 1, itemNames.length - 1);

                removeButton.setEnabled(true);
                quantityButton.setEnabled(true);
                if (itemNames.length > 1)
                    itemSortButton.setEnabled(true);
            } else if ("dish".equalsIgnoreCase(string)) {
                name = JOptionPane.showInputDialog("Enter name of the Dish: ");
                if (name == null) return;
                description = JOptionPane.showInputDialog("Enter description of the Dish: ");
                if (description == null) return;
                try {
                    cost = Double.parseDouble(JOptionPane.showInputDialog("Enter cost of the Dish: "));
                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(null, "Input was not a number!");
                    return;
                }

                boolean isHot, isVegetarian;
                try {
                    isHot = Boolean.parseBoolean(JOptionPane.showInputDialog("Enter if the Dish is hot: "));
                    isVegetarian = Boolean.parseBoolean(JOptionPane.showInputDialog
                            ("Enter if the Dish is vegetarian: "));
                } catch (Throwable throwable) {
                    JOptionPane.showMessageDialog(null, "Input was not a boolean!");
                    return;
                }

                Dish.DishType type;
                try {
                    type = Dish.DishType.valueOf(JOptionPane.showInputDialog
                            ("Enter type of the Dish: ").toUpperCase());
                } catch (IllegalArgumentException exception) {
                    JOptionPane.showMessageDialog(null,
                            "Input was not a type of the Dish!");
                    return;
                }

                try {
                    order.add(new Dish(cost, name, description, isHot, isVegetarian, type));
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, exception.getMessage());
                    return;
                }

                String[] newItemNames = new String[itemNames.length + 1];
                System.arraycopy(itemNames, 0, newItemNames,
                        0, itemNames.length);
                newItemNames[itemNames.length] = name;
                itemNames = newItemNames;

                costLabel.setText("Cost: " + order.getTotalCost());
                quantityLabel.setText("Quantity: " + itemNames.length);
                tableModel.fireTableRowsInserted(itemNames.length - 1, itemNames.length - 1);

                removeButton.setEnabled(true);
                quantityButton.setEnabled(true);
                if (itemNames.length > 1)
                    itemSortButton.setEnabled(true);
            } else if (string != null)
                JOptionPane.showMessageDialog(null, "You should input only \"Drink\" " +
                                "or \"Dish\"\nto add Item in Order!",
                        "Invalid input", JOptionPane.INFORMATION_MESSAGE);
        });

        removeButton.addActionListener(actionEvent -> {
            String name = JOptionPane.showInputDialog(
                    "Enter first name of customer of Order you want to remove: ");
            if (name == null)
                return;
            boolean found = false;
            for (int i = 0; i < itemNames.length && !found; ++i) {
                if (itemNames[i].equals(name)) {
                    found = true;
                    if (JOptionPane.showConfirmDialog(null,
                            "Are you sure you want to remove (FOREVER!)" +
                                    "\nan Item with name '" + name + "'?",
                            "Confirm your action", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        if (itemNames.length - (i + 1) >= 0)
                            System.arraycopy(itemNames, i + 1, itemNames, i,
                                    itemNames.length - (i + 1));
                        String[] newOrderManagersNames = new String[itemNames.length - 1];
                        System.arraycopy(itemNames, 0,
                                newOrderManagersNames, 0,
                                newOrderManagersNames.length);
                        itemNames = newOrderManagersNames;
                        order.remove(name);

                        costLabel.setText("Cost: " + order.getTotalCost());
                        quantityLabel.setText("Quantity: " + itemNames.length);
                        tableModel.fireTableRowsDeleted(itemNames.length, itemNames.length);
                    }
                }
            }

            if (!found)
                JOptionPane.showMessageDialog(null, "An Order with input name not found!",
                        "Nothing to remove", JOptionPane.INFORMATION_MESSAGE);
            if (itemNames.length == 0) {
                quantityButton.setEnabled(false);
                removeButton.setEnabled(false);
            }
            if (itemNames.length < 2)
                itemSortButton.setEnabled(false);
        });

        quantityButton.addActionListener(actionEvent -> {
            String name = JOptionPane.showInputDialog(
                    "Enter name of Item you want to find: ");
            if (name == null)
                return;

            JOptionPane.showMessageDialog(null,
                    "Quantity of Item to find is " + order.getQuantity(name));
        });
    }

    public void setOrder (Order order) {
        Item[] items;
        if (this.order != null) {
            items = this.order.getItems();
            if (items.length != 0)
                tableModel.fireTableRowsDeleted(0, items.length - 1);
        }

        this.order = order;
        if (order != null) {
            items = order.getItems();
            itemNames = new String[items.length];
            for (int i = 0; i < items.length; ++i)
                itemNames[i] = items[i].getName();
            tableModel.fireTableRowsInserted(0, items.length - 1);
            costLabel.setText("Cost: " + order.getTotalCost());
            quantityLabel.setText("Quantity: " + items.length);
        } else {
            if (itemNames.length > 0)
                tableModel.fireTableRowsDeleted(0, itemNames.length - 1);
            itemNames = new String[0];
            costLabel.setText("Cost: 0");
            quantityLabel.setText("Quantity: 0");
        }
    }

    protected class ItemListTableModel extends AbstractTableModel {
        public int getRowCount () {
            return itemNames.length;
        }

        public int getColumnCount () {
            return 1;
        }

        public Object getValueAt (int rowIndex, int columnIndex) {
            return itemNames[rowIndex];
        }
    }
}
