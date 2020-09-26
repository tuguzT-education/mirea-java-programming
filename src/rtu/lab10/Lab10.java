package rtu.lab10;

import java.util.LinkedList;

public class Lab10 {
    public static <E> LinkedList<E> toList(E[] array) {
        LinkedList<E> list = new LinkedList<>();
        for (E item : array) {
            list.add(item);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(toList(new String[]{"khdf'", "0", "hahah"}));
        System.out.println(toList(new Integer[]{-497, 58, 1843, -234}));
    }
}
