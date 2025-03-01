# Amazon.sa
Here's a simplified version of the README file:

---

# Online Store CLI System

## Overview

This is a simple command-line interface (CLI) system for managing an online store. Users can:
- View available products.
- Place orders by selecting products and quantities.
- View their order history.

---

## Requirements

- **Java 8** or higher.

---

## Setup Instructions

1. **Clone the Repository**:
   ```
   git clone <repository_url>
   cd <repository_name>
   ```

2. **Compile the Java Files**:
   ```
   javac *.java
   ```

3. **Run the Program**:
   ```
   java Main
   ```

---

## Features

- **View Products**: Displays a list of available products.
- **Place Order**: Allows users to select products, choose quantities, and place an order.
- **Order History**: Shows the user's previous orders.

---

## How It Works

### Product Types:
- **Product**: Base class with details like price and stock.
- **Electronics**: Inherits from Product, with an extra warranty property and a 10% discount.
- **Clothing**: Inherits from Product, with an extra size property and a 20% discount.

### Orders:
- **OrderDetails**: Contains information about individual products in an order.
- **Order**: Stores the entire order, including order details.

### Stock Management:
- Users can’t order more than the available stock. If stock is insufficient, an `OutOfStockException` is thrown.

---

## Example Usage

```
===== Welcome to the Online Store =====
1. View Products
2. Place an Order
3. View Order History
4. Exit
Please select an option: 1

===== Available Products =====
Product[ID=101, Name=Laptop, Price=$1000, Stock=50]
Product[ID=102, Name=T-shirt, Price=$30, Stock=100]

===== Welcome to the Online Store =====
1. View Products
2. Place an Order
3. View Order History
4. Exit
Please select an option: 2

Enter Product ID to add to your order (0 to finish): 101
Enter quantity: 2
Added Laptop (x2) to your order.
Enter Product ID to add to your order (0 to finish): 0

Order placed successfully! Total: $2000.0
```

---

## Files

- **Product.java**: Defines products and manages stock.
- **Electronics.java**: Subclass of Product for electronics.
- **Clothing.java**: Subclass of Product for clothing.
- **OrderDetails.java**: Details of each product in an order.
- **Order.java**: Stores order details.
- **OutOfStockException.java**: Custom exception for insufficient stock.
- **Main.java**: Main class to run the program and handle user input.

