public class Item {

    protected String name;
    protected double price;
    protected double taxRate;

    public Item (String name, double price, double taxRate) {
        this.name = name;
        this.price = price;
        this.taxRate = taxRate;
    }

    public double getTotalPrice() {
        return (this.price + this.price * this.taxRate);
    }

    public void applyDiscount(double discount) {
        this.price = this.price - this.price * (discount/100);
    }

    public void displayInfo() {
        System.out.println(this.price);
        System.out.println(this.getTotalPrice());
    }

}
