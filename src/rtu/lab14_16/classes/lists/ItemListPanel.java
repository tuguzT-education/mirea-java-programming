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
            double cost;

            String[] values = {"Drink", "Dish"};
            String string = (String) JOptionPane.showInputDialog(
                    null, "Choose type of Item you want to add in Order: ",
                    "Choose something", JOptionPane.QUESTION_MESSAGE,
                    null, values, values[0]
            );

            if (values[0].equals(string)) {

                Drink.DrinkType type = (Drink.DrinkType) JOptionPane.showInputDialog(
                        null, "Choose type of the Drink: ",
                        "Choose something", JOptionPane.QUESTION_MESSAGE,
                        null, Drink.DrinkType.values(), Drink.DrinkType.values()[0]
                );
                if (type == null) return;
                switch (type) {
                    case BEER:
                    case WINE:
                    case VODKA:
                    case BRANDY:
                    case CHAMPAGNE:
                    case WHISKEY:
                    case TEQUILA:
                    case RUM:
                    case VERMOUTH:
                    case LIQUOR:
                    case JAGERMEISTER:
                        JOptionPane.showMessageDialog(null,
                                "Alcohol is prohibited for underage people!");
                        return;
                }

                try {
                    cost = Double.parseDouble(JOptionPane.showInputDialog("Enter cost of the Drink: "));
                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(null, "Input was not a number!");
                    return;
                }

                try {
                    order.add(new Drink(cost, type.name(), type.name(), 0, type));
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, exception.getMessage());
                    return;
                }

                String[] newItemNames = new String[itemNames.length + 1];
                System.arraycopy(itemNames, 0, newItemNames,
                        0, itemNames.length);
                newItemNames[itemNames.length] = type.name();
                itemNames = newItemNames;

                costLabel.setText("Cost: " + order.getTotalCost());
                quantityLabel.setText("Quantity: " + itemNames.length);
                tableModel.fireTableRowsInserted(itemNames.length - 1, itemNames.length - 1);

                removeButton.setEnabled(true);
                quantityButton.setEnabled(true);
                if (itemNames.length > 1)
                    itemSortButton.setEnabled(true);
            } else if (values[1].equals(string)) {
                Dish.DishType type = (Dish.DishType) JOptionPane.showInputDialog(
                        null, "Choose type of the Dish: ",
                        "Choose something", JOptionPane.QUESTION_MESSAGE,
                        null, Dish.DishType.values(), Dish.DishType.values()[0]
                );
                if (type == null) return;

                try {
                    cost = Double.parseDouble(JOptionPane.showInputDialog("Enter cost of the Dish: "));
                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(null, "Input was not a number!");
                    return;
                }

                values = new String[] {"True", "False"};
                String result = (String) JOptionPane.showInputDialog(
                        null, "Is your Dish hot?",
                        "Choose something", JOptionPane.QUESTION_MESSAGE,
                        null, values, values[0]
                );
                if (result == null || result.isBlank()) return;
                boolean isHot = Boolean.parseBoolean(result);

                result = (String) JOptionPane.showInputDialog(
                        null, "Is your Dish vegetarian?",
                        "Choose something", JOptionPane.QUESTION_MESSAGE,
                        null, values, values[0]
                );
                if (result == null || result.isBlank()) return;
                boolean isVegetarian = Boolean.parseBoolean(result);

                try {
                    order.add(new Dish(cost, type.name(), type.name(), isHot, isVegetarian, type));
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, exception.getMessage());
                    return;
                }

                String[] newItemNames = new String[itemNames.length + 1];
                System.arraycopy(itemNames, 0, newItemNames,
                        0, itemNames.length);
                newItemNames[itemNames.length] = type.name();
                itemNames = newItemNames;

                costLabel.setText("Cost: " + order.getTotalCost());
                quantityLabel.setText("Quantity: " + itemNames.length);
                tableModel.fireTableRowsInserted(itemNames.length - 1, itemNames.length - 1);

                removeButton.setEnabled(true);
                quantityButton.setEnabled(true);
                if (itemNames.length > 1)
                    itemSortButton.setEnabled(true);
            }
        });

        removeButton.addActionListener(actionEvent -> {
            String name = (String) JOptionPane.showInputDialog(null,
                    "Choose name of Item to remove:", "Choose something",
                    JOptionPane.QUESTION_MESSAGE, null,
                    itemNames, itemNames[0]);
            if (name == null) return;

            for (int i = 0; i < itemNames.length; ++i) {
                if (itemNames[i].equals(name)) {
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
                        break;
                    }
                }
            }

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
            if (name == null || name.isBlank())
                return;

            JOptionPane.showMessageDialog(null,
                    "Quantity of Item to find is " + order.getQuantity(name));
        });
    }

    public void setOrder(Order order) {
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
        public int getRowCount() {
            return itemNames.length;
        }

        public int getColumnCount() {
            return 1;
        }

        public Object getValueAt(int rowIndex, int columnIndex) {
            return itemNames[rowIndex];
        }
    }
}
