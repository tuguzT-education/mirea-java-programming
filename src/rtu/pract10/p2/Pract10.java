package rtu.pract10.p2;

import rtu.pract10.p2.Chairs.*;

public class Pract10 {
    public static void main(String[] args) {
        ChairFactory factory = new ChairFactory();
        Client client = new Client();

        VictorianChair victorianChair = factory.createVictorianChair();
        FunctionalChair functionalChair = factory.createFunctionalChair();
        MagicChair magicChair = factory.createMagicChair();

        client.setChair(victorianChair);
        client.sit();

        client.setChair(functionalChair);
        client.sit();

        client.setChair(magicChair);
        client.sit();
    }
}
