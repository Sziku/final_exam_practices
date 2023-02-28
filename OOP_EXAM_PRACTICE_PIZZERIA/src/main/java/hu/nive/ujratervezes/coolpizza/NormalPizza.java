package hu.nive.ujratervezes.coolpizza;

import java.util.List;

public class NormalPizza extends Pizza {
    public NormalPizza(Topping... topping) {
        super(PizzaType.NORMAL, topping);
    }
}
