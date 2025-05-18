package factory;
/*
OrderItemFactory.java
OrderItem Factory class
Author: Thimna Gogwana 222213973
Date: 14 May 2025
*/

import domain.OrderItem;

public class OrderItemFactory {

    public static OrderItem createOrderItem(int itemID, int orderID, int productID,
                                            int quantity, double unitPrice) {
        return new OrderItem.Builder()
                .setItemID(itemID)
                .setOrderID(orderID)
                .setProductID(productID)
                .setQuantity(quantity)
                .setUnitPrice(unitPrice)
                .calculateSubTotal()
                .build();
    }

    public static OrderItem createOrderItemWithSubtotal(int itemID, int orderID, int productID,
                                                        int quantity, double unitPrice, double subTotal) {
        return new OrderItem.Builder()
                .setItemID(itemID)
                .setOrderID(orderID)
                .setProductID(productID)
                .setQuantity(quantity)
                .setUnitPrice(unitPrice)
                .setSubTotal(subTotal)
                .build();
    }

    public static OrderItem copyOrderItem(OrderItem original) {
        return new OrderItem.Builder()
                .copy(original)
                .build();
    }
}
