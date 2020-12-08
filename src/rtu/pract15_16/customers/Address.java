package rtu.pract15_16.customers;

public class Address {
    public static final Address
            EMPTY_ADDRESS = new Address
                (0, "", "", 0, '\0', 0);

    private final int zipCode, buildingNumber, apartmentNumber;
    private final String cityName, streetName;
    private final char buildingLetter;

    public Address (int zipCode, String cityName, String streetName,
                    int buildingNumber, char buildingLetter, int apartmentNumber) {
        this.zipCode = zipCode;
        this.cityName = cityName;
        this.streetName = streetName;
        this.buildingNumber = buildingNumber;
        this.buildingLetter = buildingLetter;
        this.apartmentNumber = apartmentNumber;
    }

    public int getZipCode () {
        return zipCode;
    }

    public String getCityName () {
        return cityName;
    }

    public String getStreetName () {
        return streetName;
    }

    public int getBuildingNumber () {
        return buildingNumber;
    }

    public char getBuildingLetter () {
        return buildingLetter;
    }

    public int getApartmentNumber () {
        return apartmentNumber;
    }

    public String toString() {
        return "\nCustomer's address is City " + cityName +
                ", zip code " + zipCode + ", street " + streetName +
                ", building number is " + buildingNumber +
                ", building letter is '" + buildingLetter +
                "', apartment number is " + apartmentNumber;
    }
}