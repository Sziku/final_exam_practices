package hu.nive.ujratervezes.coolpizza;

import java.util.ArrayList;
import java.util.List;

public class Pizzeria {
    private List<Pizza> pizzas = new ArrayList<>();

    public List<Pizza> getPizzaList() {
        return pizzas;
    }

    public double calculateAveragePriceOfPizzas() {
        return pizzas.stream().mapToDouble(Pizza::getPrice).average().orElse(0.0);
    }

    public int countSpicyPizzas() {
        return (int) pizzas.stream().filter(Pizza::isSpicy).count();
    }

    public List<Pizza> getListOfPizzasByType(PizzaType type) {
        return pizzas.stream().filter(pizza -> pizza.getType().equals(type)).toList();
    }

    public void addNewPizza(Pizza pizza) {
        pizzas.add(pizza);
    }

    public void removePizza(Pizza pizza) {
        pizzas.remove(pizza);
    }
}
