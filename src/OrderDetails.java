public class OrderDetails {

        private int orderDetailID;
        private int productID;
        private int quantity;
        private double subTotal;

        public OrderDetails(int orderDetailID, int productID, int quantity, double subTotal) {
            this.orderDetailID = orderDetailID;
            this.productID = productID;
            this.quantity = quantity;
            this.subTotal = subTotal;
        }

        public double getSubTotal() {
            return subTotal;
        }

        @Override
        public String toString() {
            return "OrderDetail[ID=" + orderDetailID + ", ProductID=" + productID + ", Quantity=" + quantity + ", SubTotal=" + subTotal + "]";
        }
    }

