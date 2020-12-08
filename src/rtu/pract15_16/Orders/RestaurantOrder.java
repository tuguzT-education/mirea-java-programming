package rtu.pract15_16.orders;

import rtu.pract15_16.items.Item;

public class RestaurantOrder extends Order {
    private Item[] items;

    public RestaurantOrder () {
        size = 1;
        items = new Item[size];
    }

    public RestaurantOrder (Item[] items) {
        size = items.length;
        this.items = items;
    }

    public boolean add (Item item) {
        if (size == items.length) {
            final Item[] newItems = new Item[size * 2];
            System.arraycopy(items, 0, newItems, 0, size);
            items = newItems;
        }
        items[size++] = item;
        return true;
    }

    public boolean remove (String name) {
        for (int i = 0; i < size; ++i)
            if (items[i].getName().equals(name)) {
                System.arraycopy(items, i + 1, items, i, size - i);
                items[--size] = null;
                return true;
            }
        return false;
    }

    public boolean remove (Item item) {
        for (int i = 0; i < size; ++i)
            if (items[i].equals(item)) {
                System.arraycopy(items, i + 1, items, i, size - i);
                items[--size] = null;
                return true;
            }
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
        for (Item item : items) {
            boolean insert = true;
            for (String string : strings)
                if (string.equals(item.getName())) {
                    insert = false;
                    break;
                }
            if (insert) {
                final String[] newStrings = new String[strings.length + 1];
                System.arraycopy(strings, 0, newStrings, 0, strings.length);
                strings = newStrings;
                strings[strings.length - 1] = item.getName();
            }
        }
        return strings;
    }

    public Item[] getItems () {
        return items;
    }

    public int getTotalQuantity () {
        return size;
    }

    public int getQuantity (String name) {
        int quantity = 0;
        for (Item item : items)
            if (item.getName().equals(name))
                ++quantity;
        return quantity;
    }

    @Override
    public int getQuantity (Item item) {
        int quantity = 0;
        for (Item item_ : items)
            if (item_.equals(item))
                ++quantity;
        return quantity;
    }

    public double getTotalCost () {
        double sum = 0;
        for (Item item : items)
            sum += item.getCost();
        return sum;
    }
}