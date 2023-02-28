package hu.nive.ujratervezes.coolpizza;

public class Topping {
    private double price;
    private boolean isSpicy;

    public Topping(double price, boolean isSpicy) {
        this.price = price;
        this.isSpicy = isSpicy;
    }

    public double getPrice() {
        return price;
    }

    public boolean isSpicy() {
        return isSpicy;
    }
}
