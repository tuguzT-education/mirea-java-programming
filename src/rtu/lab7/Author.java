package rtu.lab7;

import java.util.Scanner;

public class Author {
    private final String name;
    private final Gender gender;

    public Author(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public static Author getFromConsole() {
        Scanner scanner = new Scanner(System.in);
        return new Author(scanner.nextLine(), Gender.valueOf(scanner.nextLine()));
    }

    @Override
    public String toString() {
        return "Author{name = '" + name + "', gender = " + gender + "}";
    }
}
