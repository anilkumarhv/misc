package com.company;

import java.util.ArrayList;
//import java.util.Collections;
import java.util.Date;
import java.util.List;

/*
 * Immutable data structures have significant benefits, such as:
 * 1. No invalid state
 * 2. Thread safety
 * 3. Easier-to-understand code
 * 4. Easier-to-test code
 * 5. Can be used for value types
 *  ref
 * 1. https://dzone.com/articles/immutable-data-structures-in-java-2
 *
 * 2. https://dzone.com/articles/immutable-objects-in-java
 *
 * */
public final class Person {
    private final String name;
    private final List<Address> address;
    private final Date date;

    public Person(String name, List<Address> address, Date date) {
        this.name = name;
//        this.address = Collections.unmodifiableList(address);
        this.address = new ArrayList<>(address);
        this.date = new Date(date.getTime());
    }

    public String getName() {
        return name;
    }

    public List<Address> getAddress() {
        return new ArrayList<>(address);
    }

    public Date getDate() {
        return new Date(date.getTime());
    }
}

final class Address {
    private final String city;
    private final String country;

    public Address(String city, String country) {
        this.city = city;
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
