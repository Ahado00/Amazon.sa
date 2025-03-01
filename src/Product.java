public class Product {
    private int productID;
    private String name;
    private String category;
    private double price;
    private int stockQuantity;

    public Product(int productID, String name, String category, double price, int stockQuantity) {
        this.productID = productID;
        this.name = name;
        this.category = category;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public int getProductID() {
        return productID;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void reduceStock(int quantity) throws OutOfStockException {
        if (quantity > stockQuantity) {
            throw new OutOfStockException("Not enough stock for " + name);
        }
        stockQuantity -= quantity;
    }

    public double calculateDiscount() {
        return 0;  // No discount for basic product
    }

    @Override
    public String toString() {
        return "Product[ID=" + productID + ", Name=" + name + ", Category=" + category + ", Price=" + price + ", Stock=" + stockQuantity + "]";
    }
}
