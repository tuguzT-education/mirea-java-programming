package rtu.pract7.druncard;

import java.util.Scanner;

public class Drunkard {
    private final Player first = new Player();
    private final Player second = new Player();

    public Drunkard() throws IllegalArgumentException {
        Scanner scanner = new Scanner(System.in);
        byte[] array = new byte[10];

        System.out.print("Enter 5 cards of the 1st player: ");
        for (int i = 0; i < 5; ++i) {
            array[i] = scanner.nextByte();
            if (array[i] < 0 || array[i] > 9) {
                throw new IllegalArgumentException("Parameter must match this range: [0, 9]");
            }
            first.addCardDown(new Card(array[i]));
        }

        System.out.print("Enter 5 cards of the 2nd player: ");
        for (int i = 5; i < 10; ++i) {
            array[i] = scanner.nextByte();
            if (array[i] < 0 || array[i] > 9) {
                throw new IllegalArgumentException("Parameter must match this range: [0, 9]");
            }
            second.addCardDown(new Card(array[i]));
        }

        checkArray(array);
    }

    private void checkArray(final byte[] array) throws IllegalArgumentException {
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < 10; ++j) {
                if (i == j) {
                    continue;
                }
                if (array[i] == array[j]) {
                    throw new IllegalArgumentException("Parameters mustn't have been repeated");
                }
            }
        }
    }

    public void play() {
        for (byte i = 1; i <= 106; ++i) {
            Card cardFirst = first.popFromPack();
            Card cardSecond = second.popFromPack();

            if (cardFirst.compareTo(cardSecond) < 0) {
                second.addCardsDown(cardFirst, cardSecond);
            } else if (cardFirst.compareTo(cardSecond) > 0) {
                first.addCardsDown(cardFirst, cardSecond);
            }

            if (first.isEmptyPack()) {
                System.out.println("second " + i);
                return;
            }
            if (second.isEmptyPack()) {
                System.out.println("first " + i);
                return;
            }
        }
        System.out.println("botva");
    }
}
