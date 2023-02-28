package hu.nive.ujratervezes.coolpizza;

import java.util.ArrayList;
import java.util.List;

public class Pizza {

    private PizzaType type;
    private List<Topping> toppings;

    public Pizza(PizzaType type, List<Topping> toppings) {
        this.type = type;
        this.toppings = toppings;
    }

    public Pizza(PizzaType type, Topping ... topping) {
        this.type = type;
        toppings = new ArrayList<>(List.of(topping));

    }

    public PizzaType getType() {
        return type;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public double getPrice(){
        return type.basePrice + toppings.stream().mapToDouble(Topping::getPrice).sum() * type.toppingMultiplier;
    }

    public boolean isSpicy(){
        return toppings.stream().anyMatch(Topping::isSpicy);
    }
}
