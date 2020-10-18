package rtu.pract15_16.Items;

public class Drink implements Alcoholable, Item {
    private final double alcoholVol;
    private final Type type;

    public Drink(double alcoholVol, Type type) {
        this.alcoholVol = alcoholVol;
        this.type = type;
    }

    @Override
    public double getAlcoholVol() {
        return alcoholVol;
    }

    public Type getType() {
        return type;
    }

    @Override
    public boolean isAlcoholDrink() {
        switch (type) {
            case JUICE:
            case COFFEE:
            case GREEN_TEA:
            case BLACK_TEA:
            case MILK:
            case WATER:
            case SODA:
                return false;
            default:
                return true;
        }
    }

    @Override
    public int getCost() {
        return isAlcoholDrink() ? 100 : 50;
    }

    @Override
    public String getName() {
        return type.name();
    }

    @Override
    public String getDescription() {
        return type.name();
    }

    public enum Type {
        BEER,
        WINE,
        VODKA,
        BRANDY,
        CHAMPAGNE,
        WHISKEY,
        TEQUILA,
        RUM,
        VERMOUTH,
        LIQUOR,
        JAGERMEISTER,
        JUICE,
        COFFEE,
        GREEN_TEA,
        BLACK_TEA,
        MILK,
        WATER,
        SODA,
    }
}
