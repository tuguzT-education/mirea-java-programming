package rtu.pract15_16.customers;

import static rtu.pract15_16.customers.Address.EMPTY_ADDRESS;

public class Customer {
    private static final Customer
            MATURE_UNKNOWN_CUSTOMER = new Customer
                ("Unknown", "Unknown", 18, EMPTY_ADDRESS),
            NOT_MATURE_UNKNOWN_CUSTOMER = new Customer
                ("Unknown", "Unknown", 0, EMPTY_ADDRESS);

    private final String firstName, secondName;
    private final int age;
    private final Address address;

    public Customer (String firstName, String secondName, int age, Address address) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.address = address;
    }

    public String getFirstName () {
        return firstName;
    }

    public String getSecondName () {
        return secondName;
    }

    public int getAge () {
        return age;
    }

    public Address getAddress () {
        return address;
    }

    public String toString () {
        return "\nCustomer's first name is '" + firstName +
                "', second name is '" + secondName +
                "', age is " + age + '.' + address.toString();
    }
}