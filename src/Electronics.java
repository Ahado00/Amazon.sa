public class Electronics extends Product {
    private double warrantyPeriod; // in years

    public Electronics(int productID, String name, double price, int stockQuantity, double warrantyPeriod) {
        super(productID, name, "Electronics", price, stockQuantity);
        this.warrantyPeriod = warrantyPeriod;
    }

    @Override
    public double calculateDiscount() {
        return 0.1;  // Electronics get a 10% discount
    }

    @Override
    public String toString() {
        return super.toString() + ", Warranty=" + warrantyPeriod + " years";
    }
}
