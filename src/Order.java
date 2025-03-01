import java.util.List;

public class Order {
    private int orderID;
    private int userID;
    private List<OrderDetails> orderDetailsList;

    public Order(int orderID, int userID, List<OrderDetails> orderDetailsList) {
        this.orderID = orderID;
        this.userID = userID;
        this.orderDetailsList = orderDetailsList;
    }

    public void addOrderDetails(OrderDetails orderDetails) {
        orderDetailsList.add(orderDetails);
    }

    public double calculateTotal() {
        double total = 0;
        for (OrderDetails details : orderDetailsList) {
            total += details.getSubTotal();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Order[ID=" + orderID + ", UserID=" + userID + ", Total=" + calculateTotal() + ", OrderDetails=" + orderDetailsList + "]";
    }
}
