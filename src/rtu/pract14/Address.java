package rtu.pract14;

import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class Address {
    private static final Pattern PATTERN = Pattern.compile(".");

    private String country;
    private String region;
    private String city;
    private String street;
    private String house;
    private String corpus;
    private String apartment;

    public Address(String info) throws Exception {
        if (!PATTERN.matcher(info).find()) {
            throw new Exception();
        }
        final StringTokenizer tokenizer = new StringTokenizer(info, ",.;");
        while (tokenizer.hasMoreTokens()) {
            System.out.println(tokenizer.nextToken());
        }
    }

    @Override
    public String toString() {
        return "Address{country = '" + country +
                "', region = '" + region + "', city = '" + city +
                "', street = '" + street + "', house = '" + house +
                "', corpus = '" + corpus + "', apartment = '" + apartment + "'}";
    }
}
