package rtu.pract10.p2.Chairs;

import java.util.Random;

public class ChairFactory implements AbstractChairFactory {
    public VictorianChair createVictorianChair() {
        return new VictorianChair(new Random().nextInt(150) + 100);
    }

    public MagicChair createMagicChair() {
        return new MagicChair();
    }

    public FunctionalChair createFunctionalChair() {
        return new FunctionalChair();
    }
}
