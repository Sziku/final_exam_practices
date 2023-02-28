package org.example;

public class Main {
    public static void main(String[] args) {

        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= 15; i++) {
            if (i % 2 == 0 && i % 3 == 0) {
                result.append(i > 10 ? "a b " : "c ");
            }
        }
        System.out.println(result.toString());

    }
}