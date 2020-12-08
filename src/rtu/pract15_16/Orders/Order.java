package rtu.pract15_16.orders;

import rtu.pract15_16.customers.Customer;
import rtu.pract15_16.items.Item;

public abstract class Order {
    protected Customer customer;
    protected int size;

    public abstract boolean add (Item item);
    public abstract boolean remove (String name);
    public abstract boolean remove (Item item);
    public abstract int removeAll (String name);
    public abstract int removeAll (Item item);

    public abstract String[] getNames ();
    public abstract Item[] getItems ();
    public final Item[] getItemsSorted () {
        Item[] items = getItems();
        SortComparables.sort(items);
        return items;
    }

    public abstract int getTotalQuantity ();
    public abstract int getQuantity (String name);
    public abstract int getQuantity (Item item);

    public abstract double getTotalCost ();

    public final void setCustomer (Customer customer) {
        this.customer = customer;
    }

    public final Customer getCustomer () {
        return customer;
    }

    public String toString() {
        StringBuilder string = new StringBuilder("\tOrder:" + customer.toString() + ".\n\tItems of this order:");
        Item[] items = getItems();
        for (Item item : items)
            string.append(item.toString());
        return string.toString();
    }
}