package org.example;

public class WithName {
    private String name;

    public WithName(String name) {
        this.name = name;
    }

    public void modifyName(String name) {
        return this.name;
    }

    public static void main(String[] args) {
        System.out.println(new WithName("John Doe").modifyName("Jack Doe"));
    }
}
