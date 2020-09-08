package com.lab1;

public class Test {
    int getSumForLoop(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; ++i) {
            sum += array[i];
        }
        return sum;
    }

    int getSumWhileLoop(int[] array) {
        int sum = 0, i = 0;
        while (i < array.length) {
            sum += array[i];
            ++i;
        }
        return sum;
    }

    int getSumDoWhileLoop(int[] array) {
        int sum = 0, i = 0;
        do {
            sum += array[i];
            ++i;
        } while (i < array.length);
        return sum;
    }

    double[] getHarmonic(int count) {
        double[] array = new double[count];
        for (int i = 0; i < count; i++) {
            array[i] = 1.0 / (i + 1);
        }
        return array;
    }
}
