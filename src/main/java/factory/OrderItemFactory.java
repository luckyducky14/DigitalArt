package factory;
/*
OrderItemFactory.java
OrderItem Factory class
Author: Thimna Gogwana 222213973
Date: 18 May 2025
*/

import domain.OrderItem;
import util.Helper;

public class OrderItemFactory {

    public OrderItem create(int orderID, int productID, int quantity, double unitPrice) {
        validateCreationParameters(orderID, productID, quantity, unitPrice);

        return new OrderItem.Builder()
                .setOrderID(orderID)
                .setProductID(productID)
                .setQuantity(quantity)
                .setUnitPrice(unitPrice)
                .calculateSubTotal()
                .build();
    }

    public OrderItem createWithId(int itemID, int orderID, int productID,
                                  int quantity, double unitPrice) {
        validateCreationParameters(orderID, productID, quantity, unitPrice);
        if (!Helper.isValidOrderItemID(itemID)) {
            throw new IllegalArgumentException("Invalid OrderItem ID: " + itemID);
        }

        return new OrderItem.Builder()
                .setItemID(itemID)
                .setOrderID(orderID)
                .setProductID(productID)
                .setQuantity(quantity)
                .setUnitPrice(unitPrice)
                .calculateSubTotal()
                .build();
    }

    public OrderItem copy(OrderItem original) {
        if (original == null) {
            throw new IllegalArgumentException("Original OrderItem cannot be null");
        }
        Helper.validateOrderItem(original);

        return new OrderItem.Builder()
                .copy(original)
                .build();
    }

    public OrderItem updateQuantity(OrderItem original, int newQuantity) {
        if (original == null) {
            throw new IllegalArgumentException("Original OrderItem cannot be null");
        }
        if (!Helper.isValidQuantity(newQuantity)) {
            throw new IllegalArgumentException("Invalid quantity: " + newQuantity);
        }
        Helper.validateOrderItem(original);

        return new OrderItem.Builder()
                .copy(original)
                .setQuantity(newQuantity)
                .calculateSubTotal()
                .build();
    }

    public OrderItem updateUnitPrice(OrderItem original, double newUnitPrice) {
        if (original == null) {
            throw new IllegalArgumentException("Original OrderItem cannot be null");
        }
        if (!Helper.isValidUnitPrice(newUnitPrice)) {
            throw new IllegalArgumentException("Invalid unit price: " + newUnitPrice);
        }
        Helper.validateOrderItem(original);

        return new OrderItem.Builder()
                .copy(original)
                .setUnitPrice(newUnitPrice)
                .calculateSubTotal()
                .build();
    }

    private void validateCreationParameters(int orderID, int productID,
                                            int quantity, double unitPrice) {
        if (!Helper.isValidOrderID(orderID)) {
            throw new IllegalArgumentException("Invalid Order ID: " + orderID);
        }
        if (!Helper.isValidProductID(productID)) {
            throw new IllegalArgumentException("Invalid Product ID: " + productID);
        }
        if (!Helper.isValidQuantity(quantity)) {
            throw new IllegalArgumentException("Invalid quantity: " + quantity);
        }
        if (!Helper.isValidUnitPrice(unitPrice)) {
            throw new IllegalArgumentException("Invalid unit price: " + unitPrice);
        }
    }
}
