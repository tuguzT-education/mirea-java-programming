package rtu.pract11.Chairs;

public interface AbstractChairFactory {
    VictorianChair createVictorianChair();
    MagicChair createMagicChair();
    FunctionalChair createFunctionalChair();
}
