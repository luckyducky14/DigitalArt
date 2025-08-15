package za.ac.cput.factory;

import za.ac.cput.domain.Order;
import za.ac.cput.domain.OrderItem;
import za.ac.cput.domain.enums.OrderStatus;

import java.time.LocalDateTime;
import java.util.List;

public class OrderFactory {

    public static Order createOrder(Long orderID, Long userID, List<OrderItem> orderItems,
                                    double totalAmount, LocalDateTime orderDate,
                                    Long paymentID, OrderStatus paymentStatus) {
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

