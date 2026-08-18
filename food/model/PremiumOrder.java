package food.model;

import food.service.Discountable;

// Subclass representing a premium food order
public class PremiumOrder extends FoodOrder implements Discountable {

    // Constructor passing fields to superclass constructor
    public PremiumOrder(int orderId, String customerName, double amount) {
        super(orderId, customerName, amount);
    }

    // Overriding calculateDeliveryCharge for Premium Order (Rs. 50)
    @Override
    public double calculateDeliveryCharge() {
        return 50.0;
    }

    // Overriding applyDiscount from Discountable interface (15% discount)
    @Override
    public double applyDiscount() {
        return getAmount() * 0.15;
    }
}
