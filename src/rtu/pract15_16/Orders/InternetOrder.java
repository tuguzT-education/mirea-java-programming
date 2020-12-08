package rtu.pract15_16.orders;

import rtu.pract15_16.items.Item;

public class InternetOrder extends Order {
    private ListNode head, tail;

    public InternetOrder () {}

    public InternetOrder (Item[] items) {
        this();
        for (Item item : items)
            add(item);
    }

    public boolean add (Item item) {
        if (item != null) {
            if (head == null) {
                head = new ListNode(null, null, item);
                head.prev = head.next = head;
                tail = head;
            } else {
                ListNode node = new ListNode(head, tail, item);
                head.prev = tail.next = node;
                tail = node;
            }
            size++;
            return true;
        }
        return false;
    }

    public boolean remove (String name) {
        if (name != null && size != 0) {
            if (head.item.getName().equals(name)) {
                removeFirst();
                return true;
            } else {
                ListNode delete = null, node = head;
                for (int i = 0; i < size; ++i, node = node.next)
                    if (node.item.getName().equals(name))
                        delete = node;
                if (delete != null) {
                    if (delete == tail)
                        removeLast();
                    else {
                        delete.prev.next = delete.next;
                        delete.next.prev = delete.prev;
                        this.size--;
                    }
                    return true;
                } else
                    return false;
            }
        } else
            return false;
    }

    public boolean remove (Item item) {
        if (item != null && size != 0) {
            if (head.item.equals(item)) {
                removeFirst();
                return true;
            } else {
                ListNode delete = null, node = head;
                for (int i = 0; i < size; ++i, node = node.next)
                    if (node.item.equals(item))
                        delete = node;
                if (delete != null) {
                    if (delete == tail)
                        removeLast();
                    else {
                        delete.prev.next = delete.next;
                        delete.next.prev = delete.prev;
                        this.size--;
                    }
                    return true;
                }
                return false;
            }
        } else
            return false;
    }

    public int removeAll (String name) {
        int count = 0;
        while (remove(name))
            ++count;
        return count;
    }

    public int removeAll (Item item) {
        int count = 0;
        while (remove(item))
            ++count;
        return count;
    }

    public String[] getNames () {
        String[] strings = new String[0];
        ListNode node = head;
        for (int i = 0; i < size; ++i, node = node.next) {
            boolean insert = true;
            for (String string : strings)
                if (string.equals(node.item.getName())) {
                    insert = false;
                    break;
                }
            if (insert) {
                String[] temp = new String[strings.length + 1];
                System.arraycopy(strings, 0, temp, 0, strings.length);
                strings = temp;
                strings[strings.length - 1] = node.item.getName();
            }
        }
        return strings;
    }

    public Item[] getItems () {
        Item[] copy = new Item[size];
        ListNode node = head;
        for (int i = 0; i < size; ++i, node = node.next)
            copy[i] = node.item;
        return copy;
    }

    public int getTotalQuantity () {
        return size;
    }

    public int getQuantity (String name) {
        int quantity = 0;
        ListNode node = head;
        for (int i = 0; i < size; ++i, node = node.next)
            if (node.item.getName().equals(name))
                ++quantity;
        return quantity;
    }

    @Override
    public int getQuantity (Item item) {
        int quantity = 0;
        ListNode node = head;
        for (int i = 0; i < size; ++i, node = node.next)
            if (node.item.equals(item))
                ++quantity;
        return quantity;
    }

    public double getTotalCost () {
        double sum = 0;
        ListNode node = head;
        for (int i = 0; i < size; ++i, node = node.next)
            sum += node.item.getCost();
        return sum;
    }

    private void removeFirst () {
        if (size == 0)
            return;
        if (this.size == 1) {
            head = tail = null;
            size = 0;
        } else {
            ListNode newFirst = head.next;
            newFirst.prev = tail;
            tail.next = newFirst;
            head = newFirst;
            this.size--;
        }
    }

    private void removeLast () {
        if (size == 0)
            return;

        if (this.size == 1) {
            head = tail = null;
            size = 0;
        } else {
            ListNode newLast = tail.prev;
            newLast.next = head;
            head.prev = newLast;
            tail = newLast;
            this.size--;
        }
    }

    private static class ListNode {
        private ListNode next, prev;
        private final Item item;

        public ListNode (ListNode next, ListNode prev, Item item) {
            this.next = next;
            this.prev = prev;
            this.item = item;
        }
    }
}