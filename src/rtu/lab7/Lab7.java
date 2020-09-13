package rtu.lab7;

import java.util.LinkedList;
import java.util.Scanner;

public class Lab7 {
    private static final LinkedList<Book> list = new LinkedList<>();

    public static void main(String[] args) {
        getBooksFromConsole();
        printBooks();

        removeBook();
        printBooks();

        setBook();
        printBooks();
    }

    public static void printBooks() {
        System.out.println("\nList of books:\n" + list);
    }

    public static void getBooksFromConsole() {
        for (int i = 0; i < 4; ++i) {
            System.out.println("Enter data about " + (i + 1) + " book " +
                    "(each string from the new line):");
            Book book;
            try {
                book = Book.getFromConsole();
            } catch (Exception exception) {
                System.out.println("Error while getting book data " +
                        "from the console! Try again!");
                --i;
                continue;
            }
            if (i % 2 == 0) {
                list.addFirst(book);
            } else {
                list.addLast(book);
            }
        }
    }

    public static void removeBook() {
        System.out.println("Enter index of book which will be " +
                "deleted from this list:");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            byte index = scanner.nextByte();
            if (index < 0 || index > list.size() - 1) {
                System.out.println("Wrong index! Try again:");
            } else {
                list.remove(index);
                break;
            }
        }
    }

    public static Book getBookFromConsole() {
        Book book;
        while (true) {
            try {
                book = Book.getFromConsole();
                break;
            } catch (Exception exception) {
                System.out.println("Error while getting book data " +
                        "from the console! Try again!");
            }
        }
        return book;
    }

    public static void setBook() {
        System.out.println("Enter index of book which will be replaced by new:");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            byte index = scanner.nextByte();
            if (index < 0 || index > list.size() - 1) {
                System.out.println("Wrong index! Try again:");
            } else {
                System.out.println("Enter new book:");
                list.set(index, getBookFromConsole());
                break;
            }
        }
    }
}
