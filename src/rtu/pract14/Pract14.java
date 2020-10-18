package rtu.pract14;

public class Pract14 {
    public static void main(String[] args) {
        try {
            final Address[] addresses = {
                    new Address("Россия. Московская область. Москва. " +
                            "проспект Вернадского. дом 86. строение 1. комната 1104А"),
                    new Address("USA, Florida, Largo, " +
                            "Rocky Crest street, ?, ?, 4377"),
                    new Address("Россия; Волгоградская область; Волжский; " +
                            "улица Мира; дом 104; ?; квартира 68"),
                    new Address("Россия, Пермский край, Пермь, " +
                            "улица Крупской, дом 20, ?, квартира 12")
            };
            for (Address address : addresses) {
                System.out.println(address);
            }
        } catch (Exception exception) {
            System.err.println(exception.getMessage());
        }
    }
}
