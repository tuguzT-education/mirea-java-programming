package rtu.lab12;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Lab12 {
    private static final String STRING = "abcdefghijklmnopqrstuv18340";
    private static final Pattern PATTERN = Pattern.compile(STRING);

    public static void main(String[] args) {
        System.out.print("Enter new string: ");

        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        System.out.println("Input string "
                + (PATTERN.matcher(string).find() ? "matches" : "does not match")
                + " string '" + STRING + "'");
    }
}
