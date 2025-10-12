public class Item {

    // Attributs
    protected String name;
    protected double price;
    protected double price_discount;
    protected double taxRate;

    // Constructeur
    public Item (String name, double price, double taxRate) {
        this.name = name;
        this.price = price;
        this.price_discount = 0;
        this.taxRate = taxRate;
    }

    public double getTotalPrice() {
        return (this.price + this.price * this.taxRate);
    }
    public void applyDiscount(double discount) {
        this.price_discount = this.price - this.price * (discount/100);
    }
    public void displayInfo() {
        System.out.println("Price :" + this.price);
        System.out.println("Price on discount :" + this.price_discount);
        System.out.println("Price after tax :" + this.getTotalPrice());
    }
}
