package food.model;

import food.service.Discountable;

// Subclass representing a regular food order
public class RegularOrder extends FoodOrder implements Discountable {

    // Constructor passing fields to superclass constructor
    public RegularOrder(int orderId, String customerName, double amount) {
        super(orderId, customerName, amount);
    }

    // Overriding calculateDeliveryCharge for Regular Order (Rs. 80)
    @Override
    public double calculateDeliveryCharge() {
        return 80.0;
    }

    // Overriding applyDiscount from Discountable interface (10% discount)
    @Override
    public double applyDiscount() {
        return getAmount() * 0.10;
    }
}
