package hu.nive.ujratervezes.coolpizza;

import java.util.List;

public class BigPizza extends Pizza{
    public BigPizza(Topping... topping) {
        super(PizzaType.BIG, topping);
    }
}
