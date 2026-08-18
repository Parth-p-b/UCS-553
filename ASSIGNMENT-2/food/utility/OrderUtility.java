package food.utility;

import food.model.FoodOrder;
import food.model.PremiumOrder;
import food.service.Discountable;

// Utility class for validation and generating order summary
public class OrderUtility {

    // Validate that order amount is positive (> 0)
    public static boolean validateAmount(double amount) {
        return amount > 0;
    }

    // Validate that customer name is not null or empty
    public static boolean validateCustomerName(String customerName) {
        return customerName != null && !customerName.trim().isEmpty();
    }

    // Generate and display complete order summary
    public static void generateOrderSummary(FoodOrder order) {
        if (order == null) {
            System.out.println("Error: Order object is null!");
            return;
        }

        // Validate data members before generating bill summary
        if (!validateAmount(order.getAmount())) {
            System.out.println("Error: Invalid order amount (Must be > 0) for Order ID: " + order.getOrderId());
            return;
        }

        if (!validateCustomerName(order.getCustomerName())) {
            System.out.println("Error: Invalid customer name for Order ID: " + order.getOrderId());
            return;
        }

        double bill = order.getAmount();
        double deliveryCharge = order.calculateDeliveryCharge();
        double discount = 0.0;

        if (order instanceof Discountable) {
            discount = ((Discountable) order).applyDiscount();
        }

        double finalPayable = bill - discount + deliveryCharge;
        String orderType = (order instanceof PremiumOrder) ? "Premium Order" : "Regular Order";

        System.out.println("--------------------------------------------------");
        System.out.println("Order ID        : " + order.getOrderId());
        System.out.println("Customer Name   : " + order.getCustomerName());
        System.out.println("Order Type      : " + orderType);
        System.out.printf("Bill Amount     : Rs. %.2f\n", bill);
        System.out.printf("Discount        : Rs. %.2f\n", discount);
        System.out.printf("Delivery Charge : Rs. %.2f\n", deliveryCharge);
        System.out.printf("Final Payable   : Rs. %.2f\n", finalPayable);
        System.out.println("--------------------------------------------------");
    }
}
