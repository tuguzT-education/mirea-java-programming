package rtu.pract15_16.managers;

import rtu.pract15_16.orders.Order;
import rtu.pract15_16.items.Item;

public class RestaurantOrderManager implements OrderManager {
    private final Order[] orders;
    private int size;

    public static class IllegalTableNumberException extends RuntimeException {
        public IllegalTableNumberException (int tableNumber) {
            super("Table with number " + tableNumber + " does not exist");
        }
    }

    public static class OrderAlreadyAddedException extends Exception {
        public OrderAlreadyAddedException (int tableNumber) {
            super("Table with number " + tableNumber + " already has the order");
        }
    }

    public RestaurantOrderManager (int count) {
        orders = new Order[count];
    }

    public boolean add (int table, Order order) throws OrderAlreadyAddedException {
        if (table < 0 || table >= orders.length)
            throw new IllegalTableNumberException(table);
        if (orders[table] != null)
            throw new OrderAlreadyAddedException(table);

        orders[table] = order;
        ++size;
        return true;
    }

    public boolean addItem (int table, Item item) {
        if (table < 0 || table >= orders.length)
            throw new IllegalTableNumberException(table);
        if (orders[table] == null)
            throw new IllegalTableNumberException(table);

        orders[table].add(item);
        return true;
    }

    public boolean remove (int table) {
        if (table < 0 || table >= orders.length)
            throw new IllegalTableNumberException(table);

        orders[table] = null;
        --size;
        return true;
    }

    public boolean remove (Order order) {
        for (int i = 0; i < orders.length; ++i)
            if (orders[i] != null && orders[i].equals(order)) {
                remove(i);
                return true;
            }
        return false;
    }

    public int removeAll (int table) {
        int count = 0;
        while (remove(table))
            ++count;

        return count;
    }

    public int removeAll (Order order) {
        int count = 0;
        while (remove(order))
            ++count;

        return count;
    }

    public int freeTable () {
        for (int i = 0; i < orders.length; ++i)
            if (orders[i] == null)
                return i;
        return -1;
    }

    public int[] freeTables () {
        int[] result = new int[0];
        for (int i = 0; i < orders.length; ++i)
            if (orders[i] == null) {
                int[] newResult = new int[result.length + 1];
                System.arraycopy(result, 0, newResult, 0, result.length);
                newResult[result.length] = i;
                result = newResult;
            }
        return result;
    }

    public Order getOrder (int table) {
        if (table < 0 || table >= orders.length)
            throw new IllegalTableNumberException(table);

        return orders[table];
    }

    public int itemQuantity (String name) {
        int quantity = 0;
        for (Order order : orders)
            if (order != null)
                quantity += order.getQuantity(name);

        return quantity;
    }

    public int itemQuantity (Item item) {
        int quantity = 0;
        for (Order order : orders)
            if (order != null)
                quantity += order.getQuantity(item);

        return quantity;
    }

    public Order[] getOrders () {
        if (size == 0) {
            return new Order[0];
        }
        Order[] orders = new Order[size];
        int i = 0;
        for (Order order : this.orders)
            if (order != null)
                orders[i++] = order;

        return orders;
    }

    public int getTotalQuantity () {
        return size;
    }

    public double getTotalCost () {
        int summary = 0;
        for (Order order : orders)
            if (order != null)
                summary += order.getTotalCost();

        return summary;
    }
}