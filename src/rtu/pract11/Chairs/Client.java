package rtu.pract11.Chairs;

import java.util.Scanner;

public class Client {
    public Chair chair;

    public void sit() {
        if (chair instanceof VictorianChair)
            System.out.println("Возраст данного стула составляет " + ((VictorianChair) chair).getAge() + " лет.\n");

        if (chair instanceof MagicChair) {
            try {
                ((MagicChair) chair).doMagic();
            } catch (StackOverflowError e) {
                System.out.println("Сейчас будет мааааагия! Приготовьтесь...");
                e.printStackTrace();
            }
        }

        if (chair instanceof FunctionalChair) {
            int a = 0, b = 0, sum = 0;

            boolean isDone = false;
            while (!isDone) {
                try {
                    Scanner input = new Scanner(System.in);
                    System.out.println("Введите 2 числа: ");
                    a = input.nextInt();
                    b = input.nextInt();
                    sum = ((FunctionalChair) chair).sum(a, b);
                    isDone = true;
                } catch (Exception e) {
                    System.out.println("Ошибка ввода! Попробуйте ещё раз.");
                }
            }
            System.out.println("На ввод поступили числа " + a + " и " + b + ", вывод: " + sum + "\n");
        }
    }

    public void setChair(Chair chair) {
        this.chair = chair;
    }
}
