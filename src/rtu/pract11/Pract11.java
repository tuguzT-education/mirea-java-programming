package rtu.pract11;

import rtu.pract11.Chairs.*;

public class Pract11 {
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
