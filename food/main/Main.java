package food.main;

import food.model.FoodOrder;
import food.model.RegularOrder;
import food.model.PremiumOrder;
import food.utility.OrderUtility;

// Driver program for Online Food Delivery System
public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("       " + FoodOrder.getRestaurantName().toUpperCase() + " SYSTEM");
        System.out.println("==================================================\n");

        // i. Create at least six orders
        // ii. Store them using an array of FoodOrder
        FoodOrder[] orders = new FoodOrder[6];
        orders[0] = new RegularOrder(101, "Alice Smith", 450.0);
        orders[1] = new PremiumOrder(102, "Bob Johnson", 1200.0);
        orders[2] = new RegularOrder(103, "Charlie Brown", 300.0);
        orders[3] = new PremiumOrder(104, "Diana Prince", 850.0);
        orders[4] = new RegularOrder(105, "Ethan Hunt", 600.0);
        orders[5] = new PremiumOrder(106, "Fiona Gallagher", 1500.0);

        // iii. Display bill, iv. Display discount, v. Display delivery charge, vi. Display final payable amount
        System.out.println("=== ORDER SUMMARIES & BILL DETAILS ===");
        for (FoodOrder order : orders) {
            OrderUtility.generateOrderSummary(order);
        }

        // Display total static order count
        System.out.println();
        FoodOrder.displayTotalOrders();
        System.out.println("==================================================");
    }
}
