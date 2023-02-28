# **GYAKORLÓ OOP FELADAT**

Ebben a feladatban egy pizzériát kell modelezned ahol különféle pizzákat lehet kapni.

Minden osztályodat a **hu.nive.ujratervezes.coolpizza** packagben kell létrehozni.
A Main osztály main metódusában próbálhatod ki a kódodat, illetve használd az előre megírt teszteseteket az algoritmusod kipróbálására!

## Feladatleírás

Implementáld az alábbi leírás szerinti programot:

## **hu.nive.ujratervezes.coolpizza.Pizza**
**Tulajdonságai:**  
`PizzaType type` ami a pizza méretét határozza meg. Konstruktor segítségével beállítható kell legyen. Tartozik hozzá egy getter.  
`List<Topping> toppings` ami a pizzára kerülő feltétek listája. Konstruktor segítségével beállítható kell legyen. Tartozik hozzá egy getter.
**Metódusai:**  
`double getPrice()` ami a pizza teljes összegét adja vissza.  
Egy pizza ára: pizzatípus alap ára + feltétek ára * pizzatípus feltétszórzója  
`boolean isSpicy()` ami megmondja, hogy csípős-e az adott pizza. Egy pizza akkor csípős, ha legalább egy feltétje csípős.
## **hu.nive.ujratervezes.coolpizza.PizzaType**
Egy enum ami a small, normal és big értékeket veheti fel.  
Ennek az enumnak van egy `int basePrice` változója, amiben tárolja hogy a különböző méretű pizzáknak mennyi az alap ára  
és egy `double toppingMultiplier` ami megadja, hogy a pizza feltéteinek mennyivel kell megszorozni az árát az adott pizzán.  
Ezek az adatok getterrel lekérdezhetők.  
basePrice: small = 100, normal = 150, big = 200. toppingsMultiplier: small = 0.9, normal = 1.0, big = 1.1
## **hu.nive.ujratervezes.coolpizza.SmallPizza**
Az összes SmallPizza egyben Pizza is és PizzaType típusú változója mindig small értéket kap. Konstruktora kötelezően csak 1 feltétet vár.
## **hu.nive.ujratervezes.coolpizza.NormalPizza**
Az összes NormalPizza egyben Pizza is és PizzaType típusú változója mindig normal értéket kap. Konstruktora kötelezően vagy 1, 2 vagy 3 darab feltétet vár el.
## **hu.nive.ujratervezes.coolpizza.BigPizza**
Az összes BigPizza egyben Pizza is és PizzaType típusú változója mindig big értéket kap. Konstruktora kötelezően 4 feltétet vár.
## **hu.nive.ujratervezes.coolpizza.Topping**
**Tulajdonságai:**  
`double price` ami a feltét ára. Konstruktor segítségével beállítható kell legyen. Tartozik hozzá egy getter.  
`boolean isSpicy` ami megmondja, hogy csípős-e az adott feltét. Konstruktor segítségével beállítható kell legyen. Tartozik hozzá egy getter.
## **hu.nive.ujratervezes.coolpizza.Pizzeria**
**Tulajdonsága:**  
`List<Pizza> pizzas` a boltban aznap eladott pizzák listája. Tartozik hozzá egy getter.  
**Metodusai:**  
`double calculateAveragePriceOfPizzas()` vissza adja az átlag árát az eladott pizzáknak.  
`int countSpicyPizzas()` vissza adja, hogy hány darab csípős pizzát adtak el aznap.  
`List<Pizza> getListOfPizzasByType(PizzaType type)` visszaadja a  paraméterben meghatározott típusú pizzákat, amiket aznap eladtak.  
`void addNewPizza(Pizza pizza)` a paraméterben kapott pizzát hozzáadja az aznapi eladásokhoz.  
`void removePizza(Pizza pizza)` a paraméterben kapott pizzát eltávolítja az eladások közül, ha szerepelt.
