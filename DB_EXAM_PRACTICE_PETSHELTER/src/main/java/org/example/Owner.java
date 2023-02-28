package org.example;

import java.util.Objects;

public class Owner {
    private String name;
    private String city;
    private int max_number_of_pets;

    public Owner(String name, String city, int max_number_of_pets) {
        this.name = name;
        this.city = city;
        this.max_number_of_pets = max_number_of_pets;
    }

    public Owner() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getMax_number_of_pets() {
        return max_number_of_pets;
    }

    public void setMax_number_of_pets(int max_number_of_pets) {
        this.max_number_of_pets = max_number_of_pets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Owner owner = (Owner) o;
        return max_number_of_pets == owner.max_number_of_pets && Objects.equals(name, owner.name) && Objects.equals(city, owner.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, city, max_number_of_pets);
    }
}
