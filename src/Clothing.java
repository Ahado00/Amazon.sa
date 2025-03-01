public class Clothing extends Product {
    private String size;

    public Clothing(int productID, String name, double price, int stockQuantity, String size) {
        super(productID, name, "Clothing", price, stockQuantity);
        this.size = size;
    }

    @Override
    public double calculateDiscount() {
        return 0.2;  // Clothing gets a 20% discount
    }

    @Override
    public String toString() {
        return super.toString() + ", Size=" + size;
    }
}
