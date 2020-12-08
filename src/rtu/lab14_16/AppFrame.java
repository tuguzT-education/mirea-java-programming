package rtu.lab14_16;

import rtu.lab14_16.classes.lists.*;
import rtu.lab14_16.classes.managers.*;

import javax.swing.*;

public class AppFrame extends JFrame {
    public AppFrame () {
        super("Orders Manager");
        setLayout(null);
        setSize(1200, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        ItemListPanel itemListPanel = new ItemListPanel();
        OrderListPanel orderListPanel = new OrderListPanel(itemListPanel);
        RestaurantManagerPanel restaurantManagerPanel =
                new RestaurantManagerPanel(orderListPanel, itemListPanel);
        InternetManagerPanel internetManagerPanel =
                new InternetManagerPanel(orderListPanel, itemListPanel);

        add(restaurantManagerPanel);
        add(internetManagerPanel);
        add(orderListPanel);
        add(itemListPanel);

        setResizable(false);
        setVisible(true);
    }

    public static void main (String[] args) {
        new AppFrame();
    }
}