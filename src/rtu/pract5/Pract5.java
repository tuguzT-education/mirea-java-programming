package rtu.pract5;

public class Pract5 {
    public static void main(String[] args) {
        final long var = 1535728715496452361L;
        System.out.println("\nУпражнение 10: число " + var
                + ", записанное наоборот: " + Task10.getReversed(var));

        System.out.println("\nУпражнение 11: введите последовательность "
                + "натуральных чисел в одну строку,\n"
                + "которая заканчивается двумя нулями, и программа "
                + "выведет чило единиц в ней:");
        System.out.println(Task11.get());

        System.out.println("\nУпражнение 12: введите последовательность "
                + "натуральных чисел в одну строку,\n"
                + "которая заканчивается нулём, и программа "
                + "выведет нечётные числа в ней по порядку:");
        Task12.get();
    }
}
