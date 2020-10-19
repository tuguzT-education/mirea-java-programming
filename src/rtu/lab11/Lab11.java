package rtu.lab11;

import java.io.IOException;

public class Lab11 {
    private static void testSolution () {
        Exercise5 solution = new Exercise5();

        System.out.println("\tnewArrayList method:\n"
                + solution.newArrayList(1, 4, 0, -23.9, 930.5, -26372));

        System.out.println("\tnewHashSet method:\n"
                + solution.newHashSet("hello", "rofl", "goodbye", "congratulations", "idk"));

        Object[] values = {"good morning", 12, -0.453, 'f'};
        System.out.println("\tnewHashMap method:\n"
                + solution.newHashMap(values, 2342, 2576, 2346, 9013, 5031));
    }

    private static void testCatalogue () throws IOException {
        Exercise4.saveCatalog("C:\\Users\\mi\\Documents\\" +
                "IntelliJ Projects\\RTU Java\\src\\rtu\\lab11");
        System.out.println("\n" + Exercise4.getCatalog());
    }

    public static void main (String[] args) throws IOException {
        testSolution();
        System.out.print("\n--------------------\n");
        testCatalogue();
    }
}
