package org.example;

import java.util.Objects;

public class Pet {
    private String name;
    private String species;
    private int age;
    private String current_owner;

    public Pet(String name, String species, int age, String current_owner) {
        this.name = name;
        this.species = species;
        this.age = age;
        this.current_owner = current_owner;
    }

    public Pet() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCurrent_owner() {
        return current_owner;
    }

    public void setCurrent_owner(String current_owner) {
        this.current_owner = current_owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return age == pet.age && Objects.equals(name, pet.name) && Objects.equals(species, pet.species) && Objects.equals(current_owner, pet.current_owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, species, age, current_owner);
    }
}
