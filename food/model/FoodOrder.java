package food.model;

// Abstract base class representing a food order
public abstract class FoodOrder {
    // Private data members (Encapsulation)
    private int orderId;
    private String customerName;
    private double amount;

    // Static member common to all orders
    private static String restaurantName = "Tasty Bites Delivery";

    // Static object counter tracking total FoodOrder instances created
    private static int totalOrders = 0;

    // Constructor
    public FoodOrder(int orderId, String customerName, double amount) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.amount = amount;
        totalOrders++; // Increment counter whenever a new object is created
    }

    // Abstract method to calculate delivery charge (overridden by subclasses)
    public abstract double calculateDeliveryCharge();

    // Static method to display total orders created
    public static void displayTotalOrders() {
        System.out.println("Total Food Orders Created: " + totalOrders);
    }

    // Static getters and setters for restaurantName
    public static String getRestaurantName() {
        return restaurantName;
    }

    public static void setRestaurantName(String name) {
        restaurantName = name;
    }

    public static int getTotalOrders() {
        return totalOrders;
    }

    // Getters and Setters for instance variables
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
