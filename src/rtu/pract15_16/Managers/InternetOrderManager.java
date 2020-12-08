package rtu.pract15_16.managers;

import rtu.pract15_16.orders.Order;
import rtu.pract15_16.items.Item;

public class InternetOrderManager implements OrderManager {
    private QueueNode head;
    private QueueNode tail;
    private int size;

    public boolean add (Order order) {
        if (head == null) {
            head = tail = new QueueNode(order, null, null);
            head.next = head.prev = head;
        } else if (head == tail) {
            tail = new QueueNode(order, head, head);
            head.next = head.prev = tail;
        } else {
            tail.next = new QueueNode(order, head, tail);
            tail = tail.next;
        }
        ++size;
        return true;
    }

    public Order remove () {
        if (tail == null)
            return null;
        Order order = head.value;
        if (head == tail)
            head = tail = null;
        else {
            head = head.next;
            tail.next = head;
        }
        --size;
        return order;
    }

    public Order order () {
        return (head == null) ? null : head.value;
    }

    public int itemQuantity (String name) {
        int quantity = 0;
        QueueNode node = head;
        for (int i = 0; i < size; ++i, node = node.next)
            quantity += node.value.getQuantity(name);

        return quantity;
    }

    public int itemQuantity (Item item) {
        int quantity = 0;
        QueueNode node = head;
        for (int i = 0; i < size; ++i, node = node.next)
            quantity += node.value.getQuantity(item);

        return quantity;
    }

    public Order[] getOrders () {
        if (size == 0)
            return new Order[0];

        final Order[] orders = new Order[size];
        QueueNode node = head;
        for (int i = 0; i < size; ++i, node = node.next)
            orders[i] = node.value;

        return orders;
    }

    public int getTotalQuantity () {
        return size;
    }

    public double getTotalCost () {
        int summary = 0;
        QueueNode node = head;
        for (int i = 0; i < size; ++i, node = node.next)
            summary += node.value.getTotalCost();

        return summary;
    }

    private static class QueueNode {
        QueueNode next, prev;
        Order value;

        QueueNode (Order value, QueueNode next, QueueNode prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
}