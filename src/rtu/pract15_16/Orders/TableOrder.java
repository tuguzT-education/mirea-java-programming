package rtu.pract15_16.Orders;

import rtu.pract15_16.Items.Item;

public class TableOrder implements Order {
    private Item[] items = new Item[10];
    private int size;
    private Customer customer;

    @Override
    public boolean add(Item item) {
        if (size == items.length) {
            final Item[] newItems = new Item[size * 2];
            System.arraycopy(items, 0, newItems, 0, size);
            items = newItems;
        }
        items[size++] = item;
        return true;
    }

    @Override
    public String[] itemsNames() {
        final String[] itemsNames = new String[size];
        for (int i = 0; i < size; ++i) {
            itemsNames[i] = items[i].getName();
        }
        return itemsNames;
    }

    @Override
    public int itemsQuantity() {
        return size;
    }

    @Override
    public int itemQuantity(String itemName) {
        int quantity = 0;
        for (Item item : items) {
            if (item.getName().equals(itemName)) {
                ++quantity;
            }
        }
        return quantity;
    }

    @Override
    public int itemQuantity(Item item) {
        int quantity = 0;
        for (Item _item : items) {
            if (item.equals(_item)) {
                ++quantity;
            }
        }
        return quantity;
    }

    @Override
    public Item[] getItems() {
        return items;
    }

    @Override
    public boolean remove(String itemName) {
        for (int i = 0; i < size; ++i) {
            if (items[i].getName().equals(itemName)) {
                System.arraycopy(items, i + 1,
                        items, i, size - i);
                --size;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(Item item) {
        for (int i = 0; i < size; ++i) {
            if (items[i].equals(item)) {
                System.arraycopy(items, i + 1,
                        items, i, size - i);
                --size;
                return true;
            }
        }
        return false;
    }

    @Override
    public int removeAll(String itemName) {
        int count = 0;
        while (remove(itemName)) {
            ++count;
        }
        return count;
    }

    @Override
    public int removeAll(Item item) {
        int count = 0;
        while (remove(item)) {
            ++count;
        }
        return count;
    }

    @Override
    public Item[] sortedItemsByCostDescription() {
        return items.clone();
    }

    @Override
    public int costTotal() {
        int sum = 0;
        for (Item item : items) {
            sum += item.getCost();
        }
        return sum;
    }

    @Override
    public Customer getCustomer() {
        return customer;
    }

    @Override
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
