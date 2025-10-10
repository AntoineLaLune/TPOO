public class Item {

    public String name;
    public double price;
    public double taxRate;

    public Item (String name, double price, double taxRate) {
        this.name = name;
        this.price = price;
        this.taxRate = taxRate;
    }

    public double getTotalPrice() {
        this.price = this.price + this.price * this.taxRate;
        return this.price;
    }

    public double applyDiscount(double discount) {
        this.price = this.price - this.price * (discount/100);
        return this.price;
    }

    public void displayInfo() {
    }

}
