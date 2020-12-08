package rtu.pract15_16.managers;

import rtu.pract15_16.orders.Order;
import rtu.pract15_16.items.Item;

public interface OrderManager {
    int itemQuantity (String name);
    int itemQuantity (Item item);

    Order[] getOrders ();
    int getTotalQuantity ();
    double getTotalCost ();
}