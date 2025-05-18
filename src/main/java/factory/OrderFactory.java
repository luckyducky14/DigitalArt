package factory;
/*
OrderFactory.java
Order Factory class
Author: Mpilonhle Zimela Mzimela 230197833
Date: 14 May 2025
*/




import domain.Order;
import domain.OrderItem;
import java.time.LocalDateTime;
import java.util.List;

public class OrderFactory {

    public static Order createOrder(int orderID, int userID, List<OrderItem> orderItems,
                                    double totalAmount, LocalDateTime orderDate,
                                    int paymentID, String paymentStatus) {
        return new Order.Builder()
                .setOrderID(orderID)
                .setUserID(userID)
                .setOrderItems(orderItems)
                .setTotalAmount(totalAmount)
                .setOrderDate(orderDate)
                .setPaymentID(paymentID)
                .setPaymentStatus(paymentStatus)
                .build();
    }
}

