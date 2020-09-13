package rtu.lab7;

import java.util.Scanner;

public class Book {
    private final String name;
    private final Author author;

    public Book(String name, String authorName, Gender authorGender) {
        this.name = name;
        this.author = new Author(authorName, authorGender);
    }

    public Book(String name, Author author) {
        this.name = name;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public Author getAuthor() {
        return author;
    }

    public static Book getFromConsole() {
        Scanner scanner = new Scanner(System.in);
        return new Book(scanner.nextLine(), Author.getFromConsole());
    }

    @Override
    public String toString() {
        return "Book{name = '" + name + "', author = " + author + "}";
    }
}
