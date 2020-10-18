package rtu.pract15_16.Orders;

import rtu.pract15_16.Items.Item;

public interface Order {
    boolean add(Item item);

    String[] itemsNames();

    int itemsQuantity();

    int itemQuantity(String itemName);

    int itemQuantity(Item item);

    Item[] getItems();

    boolean remove(String itemName);

    boolean remove(Item item);

    int removeAll(String itemName);

    int removeAll(Item item);

    Item[] sortedItemsByCostDescription();

    int costTotal();

    Customer getCustomer();

    void setCustomer(Customer customer);
}
