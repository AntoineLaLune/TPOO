public class Item {

    // Attributs
    protected String name;
    protected double price;
    protected double initial_price;
    protected double taxRate;

    // Constructeur
    public Item (String name, double price, double taxRate) {
        this.name = name;
        this.price = price;
        this.initial_price = price;
        this.taxRate = taxRate;
    }

    public double getTotalPrice() {
        return (this.price + this.price * this.taxRate);
    }
    public void applyDiscount(double discount) {
        this.price = this.initial_price - this.initial_price * (discount/100);
    }
    public void displayInfo() {
        if (this.price == this.initial_price) {
            System.out.println("Price: " + this.price);
            System.out.println("Price after tax: " + this.getTotalPrice());
        } else {
            System.out.println("Price on discount: " + this.price);
            System.out.println("Price on discount after tax: " + this.getTotalPrice());
        }
    }
}
