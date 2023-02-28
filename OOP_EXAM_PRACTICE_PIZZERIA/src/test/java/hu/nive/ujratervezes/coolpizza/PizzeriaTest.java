package hu.nive.ujratervezes.coolpizza;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PizzeriaTest {

    private Pizza createSmallPizzaOne(){
        return new SmallPizza(new Topping(30, false));
    }

    private Pizza createSmallPizzaTwo(){
        return new SmallPizza(new Topping(25, true));
    }

    private Pizza createNormalPizzaWithOneTopping(){
        return new NormalPizza(new Topping(30, false));
    }

    private Pizza createNormalPizzaWithTwoTopping(){
        return new NormalPizza(new Topping(30, false), new Topping(30, true));
    }

    private Pizza createNormalPizzaWithThreeTopping(){
        return new NormalPizza(new Topping(30, false),
                new Topping(30, true), new Topping(40, true));
    }

    private Pizza createBigPizzaOne(){
        return new BigPizza(new Topping(25, false), new Topping(25, false),
                new Topping(25, false), new Topping(25, false));
    }

    private Pizza createBigPizzaTwo(){
        return new BigPizza(new Topping(10, false), new Topping(10, false),
                new Topping(10, true), new Topping(10, false));
    }

    @Test
    void addPizzaTest(){
        Pizzeria testPizzera = new Pizzeria();
        Pizza pizza1 = createSmallPizzaOne();

        testPizzera.addNewPizza(pizza1);

        assertTrue(testPizzera.getPizzaList().contains(pizza1));
    }

    @Test
    void getPizzaListTest(){
        Pizzeria testPizzera = new Pizzeria();
        Pizza pizza1 = createSmallPizzaOne();
        Pizza pizza2 = createNormalPizzaWithOneTopping();
        Pizza pizza3 = createBigPizzaOne();

        testPizzera.addNewPizza(pizza1);
        testPizzera.addNewPizza(pizza2);
        testPizzera.addNewPizza(pizza3);

        assertEquals(3, testPizzera.getPizzaList().size());
    }

    @Test
    void removePizzaTest(){
        Pizzeria testPizzera = new Pizzeria();
        Pizza pizza1 = createSmallPizzaOne();
        Pizza pizza2 = createNormalPizzaWithOneTopping();
        Pizza pizza3 = createBigPizzaOne();

        testPizzera.addNewPizza(pizza1);
        testPizzera.addNewPizza(pizza2);
        testPizzera.addNewPizza(pizza3);
        testPizzera.removePizza(pizza2);

        assertEquals(2, testPizzera.getPizzaList().size());
        assertFalse(testPizzera.getPizzaList().contains(pizza2));
    }

    @Test
    void calculateAveragePriceOfPizzasTest(){
        Pizzeria testPizzera = new Pizzeria();
        Pizza pizza1 = createNormalPizzaWithOneTopping();
        Pizza pizza2 = createNormalPizzaWithOneTopping();
        Pizza pizza3 = createNormalPizzaWithOneTopping();

        testPizzera.addNewPizza(pizza1);
        testPizzera.addNewPizza(pizza2);
        testPizzera.addNewPizza(pizza3);

        assertEquals(180, testPizzera.calculateAveragePriceOfPizzas());
    }

    @Test
    void calculateAveragePriceOfPizzasWhenPizzaListIsEmpty(){
        Pizzeria testPizzera = new Pizzeria();

        assertEquals(0, testPizzera.calculateAveragePriceOfPizzas());
    }

    @Test
    void getToppingPriceTest(){
        Topping topping = new Topping(50, false);

        assertEquals(50, topping.getPrice());
    }

    @Test
    void getPizzaTypeSmallPizzaTest(){
        Pizza pizza = createSmallPizzaTwo();

        assertEquals(PizzaType.SMALL, pizza.getType());
    }

    @Test
    void getPizzaTypeNormalPizzaTest(){
        Pizza pizza = createNormalPizzaWithOneTopping();

        assertEquals(PizzaType.NORMAL, pizza.getType());
    }

    @Test
    void getPizzaTypeBigPizzaTest(){
        Pizza pizza = createBigPizzaOne();

        assertEquals(PizzaType.BIG, pizza.getType());
    }

    @Test
    void getToppingsTest(){
        Topping topping1 = new Topping(30,false);
        Topping topping2 = new Topping(20,true);

        List<Topping> toppings = new ArrayList<>(){{
            add(topping1);
            add(topping2);
        }};

        Pizza pizza = new NormalPizza(topping1, topping2);

        assertEquals(toppings, pizza.getToppings());
    }

    @Test
    void pizzaPriceTest(){
        assertEquals(250, createNormalPizzaWithThreeTopping().getPrice());
    }

    @Test
    void pizzaIsSpicyTest(){
        assertFalse(createBigPizzaOne().isSpicy());
        assertTrue(createBigPizzaTwo().isSpicy());
    }

    @Test
    void getListOfPizzasByTypeTest(){
        Pizzeria testPizzera = new Pizzeria();
        Pizza pizza1 = createSmallPizzaOne();
        Pizza pizza2 = createNormalPizzaWithOneTopping();
        Pizza pizza3 = createNormalPizzaWithTwoTopping();
        Pizza pizza4 = createNormalPizzaWithThreeTopping();
        Pizza pizza5 = createBigPizzaOne();
        Pizza pizza6 = createBigPizzaTwo();

        testPizzera.addNewPizza(pizza1);
        testPizzera.addNewPizza(pizza2);
        testPizzera.addNewPizza(pizza3);
        testPizzera.addNewPizza(pizza4);
        testPizzera.addNewPizza(pizza5);
        testPizzera.addNewPizza(pizza6);

        assertEquals(List.of(pizza1), testPizzera.getListOfPizzasByType(PizzaType.SMALL));
        assertEquals(List.of(pizza2, pizza3, pizza4), testPizzera.getListOfPizzasByType(PizzaType.NORMAL));
        assertEquals(List.of(pizza5, pizza6), testPizzera.getListOfPizzasByType(PizzaType.BIG));
    }

    @Test
    void countSpicyPizzasTest(){
        Pizzeria testPizzera = new Pizzeria();
        Pizza pizza1 = createSmallPizzaOne();
        Pizza pizza2 = createNormalPizzaWithOneTopping();
        Pizza pizza3 = createNormalPizzaWithTwoTopping();
        Pizza pizza4 = createNormalPizzaWithThreeTopping();
        Pizza pizza5 = createBigPizzaOne();
        Pizza pizza6 = createBigPizzaTwo();
        Pizza pizza7 = createSmallPizzaTwo();

        testPizzera.addNewPizza(pizza1);
        testPizzera.addNewPizza(pizza2);
        testPizzera.addNewPizza(pizza3);
        testPizzera.addNewPizza(pizza4);
        testPizzera.addNewPizza(pizza5);
        testPizzera.addNewPizza(pizza6);
        testPizzera.addNewPizza(pizza7);

        assertEquals(4, testPizzera.countSpicyPizzas());
    }
}