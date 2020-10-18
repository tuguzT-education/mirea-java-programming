package rtu.pract14;

import java.util.StringTokenizer;

public class Address {
    private String country;
    private String region;
    private String city;
    private String street;
    private String house;
    private String corpus;
    private String apartment;

    public Address(String country, String region, String city, String street,
                   String house, String corpus, String apartment) {
        this.country = country;
        this.region = region;
        this.city = city;
        this.street = street;
        this.house = house;
        this.corpus = corpus;
        this.apartment = apartment;
    }

    public Address(String info) throws Exception {
        final StringTokenizer tokenizer = new StringTokenizer(info, ",.;");
        int i = 0;
        while (tokenizer.hasMoreTokens()) {
            final String string = tokenizer.nextToken();
            final String trimmed = string.trim();
            if ((string.startsWith(" ") && string.endsWith(trimmed))
                    || string.equals(trimmed)) {
                switch (i) {
                    case 0:
                        country = trimmed;
                    case 1:
                        region = trimmed;
                    case 2:
                        city = trimmed;
                    case 3:
                        street = trimmed;
                    case 4:
                        house = trimmed;
                    case 5:
                        corpus = trimmed;
                    case 6:
                        apartment = trimmed;
                }
                ++i;
            } else {
                throw new Exception("Error: leading/trailing spaces!");
            }
        }
        if (i != 7) {
            throw new Exception("Too " + (i < 7 ? "few" : "much") + " arguments!");
        }
    }

    public String getCountry() {
        return country;
    }

    public String getRegion() {
        return region;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getHouse() {
        return house;
    }

    public String getCorpus() {
        return corpus;
    }

    public String getApartment() {
        return apartment;
    }

    @Override
    public String toString() {
        return "Address is: country '" + country +
                "', region '" + region + "', city '" + city +
                "', street '" + street + "', house '" + house +
                "', corpus '" + corpus + "', apartment '" + apartment + "'";
    }
}
