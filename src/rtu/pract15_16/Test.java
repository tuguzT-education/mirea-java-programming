package rtu.pract15_16;

import rtu.pract15_16.managers.RestaurantOrderManager;
import rtu.pract15_16.orders.InternetOrder;
import rtu.pract15_16.orders.Order;
import rtu.pract15_16.items.Dish;
import rtu.pract15_16.items.Drink;
import rtu.pract15_16.items.Item;
import rtu.pract15_16.customers.Address;
import rtu.pract15_16.customers.Customer;

import java.util.Scanner;

public class Test {
    private static final Scanner scanner = new Scanner(System.in);
    private static RestaurantOrderManager tableOrdersManager;

    private static int nextInt() {
        while (true)
            try {
                return scanner.nextInt();
            } catch (Throwable throwable) {
                System.out.print("Input error! Try again: ");
                scanner.nextLine();
            }
    }

    private static double nextDouble() {
        while (true)
            try {
                return scanner.nextDouble();
            } catch (Throwable throwable) {
                System.out.print("Input error! Try again: ");
                scanner.nextLine();
            }
    }

    private static boolean nextBoolean() {
        while (true)
            try {
                return scanner.nextBoolean();
            } catch (Throwable throwable) {
                System.out.print("Input error! Try again: ");
                scanner.nextLine();
            }
    }

    private static char nextChar() {
        while (true)
            try {
                return scanner.next(".").charAt(0);
            } catch (Throwable throwable) {
                System.out.print("Input error! Try again: ");
                scanner.nextLine();
            }
    }

    public static void main (String[] args) {
        System.out.print("Enter count of tables of restaurant: ");
        tableOrdersManager = new RestaurantOrderManager(nextInt());

        System.out.print("Enter count of orders to add: ");
        int count = nextInt();
        for (int i = 0; i < count; ++i)
            addOrder();

        Order[] orders = tableOrdersManager.getOrders();
        for (Order order : orders)
            System.out.println("\n" + order);
    }

    private static void addOrder() {
        System.out.print("Enter table number to add new order: ");
        int tableNumber = nextInt();

        try {
            Order order = nextOrder();
            tableOrdersManager.add(--tableNumber, order);
            System.out.print("\n\tDo you want to add items in order?\n\tEnter Y if you want to: ");
            if (Character.toString(nextChar()).equalsIgnoreCase("y")) {
                System.out.print("\tEnter count of items to add: ");
                int count = nextInt();
                for (int i = 0; i < count; ++i)
                    order.add(nextItem());
            }
        } catch (Exception exception) {
            System.out.print(exception.getMessage() + "\nTry again:");
            addOrder();
        }
    }

    private static InternetOrder nextOrder() {
        InternetOrder internetOrder = new InternetOrder();
        System.out.println("\nEnter information about customer:");
        internetOrder.setCustomer(nextCustomer());
        return internetOrder;
    }

    private static Customer nextCustomer() {
        System.out.print("\tEnter customer's first name: ");
        String firstName = scanner.next();

        System.out.print("\tEnter customer's last name: ");
        String lastName = scanner.next();

        System.out.print("\tEnter customer's age: ");
        int age = nextInt();

        return new Customer(firstName, lastName, age, nextAddress());
    }

    private static Address nextAddress() {
        System.out.print("\tEnter city name: ");
        String cityName = scanner.next();

        System.out.print("\tEnter zip code: ");
        int zipCode = nextInt();

        System.out.print("\tEnter street name: ");
        String streetName = scanner.next();

        System.out.print("\tEnter building number: ");
        int buildingNumber = nextInt();

        System.out.print("\tEnter building letter: ");
        char buildingLetter = nextChar();

        System.out.print("\tEnter apartment number: ");
        int apartmentNumber = nextInt();

        return new Address(zipCode, cityName, streetName,
                buildingNumber, buildingLetter, apartmentNumber);
    }

    private static Item nextItem() {
        System.out.print("\n\t\tWhat kind of item do you want to add? Drink or dish?\n" +
                "\t\tIf you want to add drink, enter Y, otherwise any other symbol: ");
        if (Character.toString(nextChar()).equalsIgnoreCase("y"))
            return nextDrink();
        else
            return nextDish();
    }

    private static Drink nextDrink() {
        try {
            System.out.print("\n\t\tEnter information about this drink:\n\t\t\tEnter cost of the drink: ");
            double cost = nextDouble();

            System.out.print("\t\t\tEnter name of the drink: ");
            String name = scanner.next();

            System.out.print("\t\t\tEnter description of the drink: ");
            String description = scanner.next();

            System.out.print("\t\t\tEnter alcohol volume of the drink: ");
            double alcoholVolume = nextDouble();

            System.out.print("\t\t\tEnter type of the drink: ");
            Drink.DrinkType type;
            while (true)
                try {
                    type = Drink.DrinkType.valueOf(scanner.next().toUpperCase());
                    break;
                } catch (IllegalArgumentException exception) {
                    System.out.print(exception.getMessage() + "\n\t\tTry again: ");
                }
            return new Drink(cost, name, description, alcoholVolume, type);
        } catch (Exception exception) {
            System.out.print(exception.getMessage() + "\n\t\tTry again:");
            return nextDrink();
        }
    }

    private static Dish nextDish () {
        try {
            System.out.print("\n\t\tEnter information about this dish:\n\t\t\tEnter cost of the dish: ");
            double cost = nextDouble();

            System.out.print("\t\t\tEnter name of the dish: ");
            String name = scanner.next();

            System.out.print("\t\t\tEnter its description: ");
            String description = scanner.next();

            System.out.print("\t\t\tEnter if the dish is hot: ");
            boolean isHot = nextBoolean();

            System.out.print("\t\t\tEnter if the dish is vegetarian: ");
            boolean isVegetarian = nextBoolean();

            System.out.print("\t\t\tEnter type of the dish: ");
            Dish.DishType type;
            while (true)
                try {
                    type = Dish.DishType.valueOf(scanner.next().toUpperCase());
                    break;
                } catch (IllegalArgumentException exception) {
                    System.out.print(exception.getMessage() + "\n\t\tTry again: ");
                }
            return new Dish(cost, name, description, isHot, isVegetarian, type);
        } catch (Exception exception) {
            System.out.print(exception.getMessage() + "\n\t\tTry again:");
            return nextDish();
        }
    }
}