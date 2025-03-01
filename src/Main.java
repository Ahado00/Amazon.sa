import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    static HashMap<Integer, Order> userOrders = new HashMap<>();
    static List<Product> productList = new ArrayList<>();
    static int currentOrderID = 1;  // To generate unique order IDs

    public static void main(String[] args) {
        // Sample products
        productList.add(new Electronics(101, "Laptop", 1000, 50, 2));
        productList.add(new Clothing(102, "T-shirt", 30, 100, "M"));
        productList.add(new Electronics(103, "Smartphone", 800, 30, 1));
        productList.add(new Clothing(104, "Jeans", 40, 150, "L"));

        Scanner scanner = new Scanner(System.in);
        int userID = 501;  // For this example, we're assuming a fixed user ID

        while (true) {
            System.out.println("\n===== Welcome to the Online Store =====");
            System.out.println("1. View Products");
            System.out.println("2. Place an Order");
            System.out.println("3. View Order History");
            System.out.println("4. Exit");
            System.out.print("Please select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    viewProducts();
                    break;
                case 2:
                    placeOrder(scanner, userID);
                    break;
                case 3:
                    viewOrderHistory(userID);
                    break;
                case 4:
                    System.out.println("Thank you for visiting. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Method to view available products
    private static void viewProducts() {
        System.out.println("\n===== Available Products =====");
        for (Product product : productList) {
            System.out.println(product);
        }
    }

    // Method to place an order
    private static void placeOrder(Scanner scanner, int userID) {
        System.out.println("\n===== Place an Order =====");
        List<OrderDetails> orderDetailsList = new ArrayList<>();
        Order order = new Order(currentOrderID++, userID, orderDetailsList);

        while (true) {
            System.out.print("Enter Product ID to add to your order (0 to finish): ");
            int productID = scanner.nextInt();

            if (productID == 0) {
                break;
            }

            Product product = getProductByID(productID);
            if (product == null) {
                System.out.println("Product not found. Please try again.");
                continue;
            }

            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();

            try {
                product.reduceStock(quantity);
                double subTotal = product.getPrice() * quantity * (1 - product.calculateDiscount());
                OrderDetails orderDetails = new OrderDetails(orderDetailsList.size() + 1, productID, quantity, subTotal);
                order.addOrderDetails(orderDetails);
                System.out.println("Added " + product.getName() + " (x" + quantity + ") to your order.");
            } catch (OutOfStockException e) {
                System.out.println(e.getMessage());
            }
        }

        userOrders.put(userID, order);
        System.out.println("Order placed successfully! Total: $" + order.calculateTotal());
    }

    // Method to get product by ID
    private static Product getProductByID(int productID) {
        for (Product product : productList) {
            if (product.getProductID() == productID) {
                return product;
            }
        }
        return null;
    }

    // Method to view order history
    private static void viewOrderHistory(int userID) {
        if (!userOrders.containsKey(userID)) {
            System.out.println("\nNo orders found.");
        } else {
            System.out.println("\n===== Your Order History =====");
            Order order = userOrders.get(userID);
            System.out.println(order);
        }
    }
}
