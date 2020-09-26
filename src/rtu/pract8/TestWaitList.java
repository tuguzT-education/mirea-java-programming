package rtu.pract8;

public class TestWaitList {
    public static void main(String[] args) {
        WaitList<String> usual = new WaitList<>();
        BoundedWaitList<String> bounded = new BoundedWaitList<>(5);

        UnfairWaitList<String> unfair = new UnfairWaitList<>();
        UnfairWaitList<String> unfair_copy = new UnfairWaitList<>();

        initialize(usual, bounded, unfair, unfair_copy);
        print(usual, bounded, unfair);

        remove(unfair, unfair_copy, usual, bounded);
        print(usual, bounded, unfair, unfair_copy);
    }

    @SafeVarargs
    private static void remove(UnfairWaitList<String> unfair,
                               UnfairWaitList<String> unfair_copy,
                               WaitList<String>... waitLists) {
        String writing = "Writing number 2";

        for (WaitList<String> waitList : waitLists)
            waitList.remove(writing);

        // Проверка метода remove(E element) класса UnfairWaitList
        unfair.add(writing);
        unfair.remove(writing);

        // Проверка метода moveToBack(E element) класса UnfairWaitList
        unfair_copy.add("Writing number 0");
        unfair_copy.moveToBack(writing);
    }

    @SafeVarargs
    private static void initialize(WaitList<String>... waitLists) {
        for (int i = 0; i < 8; i++) {
            String writing = "Writing number " + (i + 1);
            for (WaitList<String> waitList : waitLists)
                waitList.add(writing);
        }
    }

    @SafeVarargs
    private static void print(WaitList<String>... waitLists) {
        System.out.println("\n");
        for (WaitList<String> waitList : waitLists)
            System.out.println(waitList.toString());
    }
}
