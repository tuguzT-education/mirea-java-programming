package rtu.lab13;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lab13 {
    private static final Pattern
            AVAILABLE = Pattern.compile("\\w"),
            NUMBER = Pattern.compile("\\d"),
            UPPERCASE = Pattern.compile("[A-Z]"),
            LOWERCASE = Pattern.compile("[a-z]");

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Чтобы пароль был надёжным, он должен состоять из :"
                + "\n\t- 8 и более символов"
                + "\n\t- символами являются цифры, английские буквы и знаки подчёркивания"
                + "\nи обязан содержать :"
                + "\n\t- одну заглавную букву"
                + "\n\t- одну прописную букву"
                + "\n\t- одну цифру");

        System.out.print("\nВведите надёжный пароль: ");
        if (input.hasNextLine()) {
            String password = input.nextLine();
            boolean isGood = false;

            if (password.length() >= 8) {
                Matcher available = AVAILABLE.matcher(password);

                if (available.find()) {
                    Matcher number = NUMBER.matcher(password),
                            uppercase = UPPERCASE.matcher(password),
                            lowercase = LOWERCASE.matcher(password);

                    if (number.find() && uppercase.find() && lowercase.find())
                        isGood = true;
                }
            }
            output(isGood);
        }
    }

    private static void output(boolean isGood) {
        System.out.println((isGood
                ? "\nВаш пароль надёжен! Поздравляем!"
                : "\nВаш пароль ненадёжен! Придумайте другой..."));
    }
}
