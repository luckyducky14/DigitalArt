package util;

import domain.OrderItem;
import domain.Product;

import java.util.UUID;

public class Helper {
    public static boolean isValidCartItemID(int cartItemID) {
        return cartItemID >= 0;
    }

    public static boolean isValidCartID(int cartID) {
        return cartID >= 0;
    }

    public static boolean isValidProductID(int productID) {
        return productID >0;
    }

    public static boolean isValidQuantity(int quantity) {
        return quantity >0;
    }
    public static boolean isValidOrderItemID(int orderItemID) {
        return orderItemID > 0; // Typically starts from 1
    }

    public static boolean isValidOrderID(int orderID) {
        return orderID > 0; // Typically starts from 1
    }

    public static boolean isValidUnitPrice(double unitPrice) {
        return unitPrice >= 0.0 && unitPrice <= 999999.99; // Reasonable price range
    }

    public static boolean isValidSubTotal(double subTotal) {
        return subTotal >= 0.0 && subTotal <= 9999999.99; // Higher limit for summed values
    }

    public static boolean isValidOrderItem(OrderItem orderItem) {
        return orderItem != null &&
                isValidOrderItemID(orderItem.getItemID()) &&
                isValidOrderID(orderItem.getOrderID()) &&
                isValidProductID(orderItem.getProductID()) &&
                isValidQuantity(orderItem.getQuantity()) &&
                isValidUnitPrice(orderItem.getUnitPrice()) &&
                isValidSubTotal(orderItem.getSubTotal()) &&
                Math.abs(orderItem.getSubTotal() - (orderItem.getUnitPrice() * orderItem.getQuantity())) < 0.001; // Verify calculation
    }

    public static void validateOrderItem(OrderItem orderItem) {
        if (!isValidOrderItem(orderItem)) {
            throw new IllegalArgumentException("Invalid OrderItem: " + orderItem);
        }
    }
    public static boolean isValidProductID(String productID) {
        return productID != null && !productID.trim().isEmpty() && productID.matches("prod-\\d+");
    }

    public static boolean isValidTitle(String title) {
        return title != null && !title.trim().isEmpty() && title.length() <= 100;
    }

    public static boolean isValidDescription(String description) {
        return description != null && !description.trim().isEmpty() && description.length() <= 500;
    }

    public static boolean isValidPrice(double price) {
        return price >= 0.0 && price <= 999999.99;
    }

    public static boolean isValidCategoryID(String categoryID) {
        return categoryID != null && !categoryID.trim().isEmpty() && categoryID.matches("cat-\\d+");
    }

    public static boolean isValidProduct(Product product) {
        return product != null &&
                isValidProductID(product.getProductID()) &&
                isValidTitle(product.getTitle()) &&
                (product.getDescription() == null || isValidDescription(product.getDescription())) &&
                isValidPrice(product.getPrice()) &&
                (product.getCategoryID() == null || isValidCategoryID(product.getCategoryID()));
    }
     public static String generateId() {
        return UUID.randomUUID().toString();
     }

     public static boolean isNullOrEmpty(String str) {
        if (str.isEmpty() || str == null)
            return true;
        return false;
     }
}
