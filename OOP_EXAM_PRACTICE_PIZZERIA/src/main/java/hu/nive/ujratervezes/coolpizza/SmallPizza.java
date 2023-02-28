package hu.nive.ujratervezes.coolpizza;

import java.util.List;

public class SmallPizza extends Pizza{
    public SmallPizza(Topping... topping) {
        super(PizzaType.SMALL, topping);
    }
}
