package za.ac.cput.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import za.ac.cput.domain.enums.OrderStatus;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderID;

    private Long userID;
    private double totalAmount;
    private LocalDateTime orderDate;
    private Long paymentID;

    @Enumerated(EnumType.STRING)
    private OrderStatus paymentStatus;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "orderID", referencedColumnName = "orderID")
    private List<OrderItem> orderItems;

    protected Order() {}

    public Order(Builder builder) {
        this.orderID = builder.orderID;
        this.userID = builder.userID;
        this.orderItems = builder.orderItems;
        this.totalAmount = builder.totalAmount;
        this.orderDate = builder.orderDate;
        this.paymentID = builder.paymentID;
        this.paymentStatus = builder.paymentStatus;
    }

    public Long getOrderID() {
        return orderID;
    }

    public Long getUserID() {
        return userID;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public Long getPaymentID() {
        return paymentID;
    }

    public OrderStatus getPaymentStatus() {
        return paymentStatus;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", userID=" + userID +
                ", orderItems=" + orderItems +
                ", totalAmount=" + totalAmount +
                ", orderDate=" + orderDate +
                ", paymentID=" + paymentID +
                ", paymentStatus=" + paymentStatus +
                '}';
    }

    public static class Builder {

        private Long orderID;
        private Long userID;
        private List<OrderItem> orderItems;
        private double totalAmount;
        private LocalDateTime orderDate;
        private Long paymentID;
        private OrderStatus paymentStatus;

        public Builder setOrderID(Long orderID) {
            this.orderID = orderID;
            return this;
        }

        public Builder setUserID(Long userID) {
            this.userID = userID;
            return this;
        }

        public Builder setOrderItems(List<OrderItem> orderItems) {
            this.orderItems = orderItems;
            return this;
        }

        public Builder setTotalAmount(double totalAmount) {
            this.totalAmount = totalAmount;
            return this;
        }

        public Builder setOrderDate(LocalDateTime orderDate) {
            this.orderDate = orderDate;
            return this;
        }

        public Builder setPaymentID(Long paymentID) {
            this.paymentID = paymentID;
            return this;
        }

        public Builder setPaymentStatus(OrderStatus paymentStatus) {
            this.paymentStatus = paymentStatus;
            return this;
        }

        public Builder copy(Order order) {
            this.orderID = order.orderID;
            this.userID = order.userID;
            this.orderItems = order.orderItems;
            this.totalAmount = order.totalAmount;
            this.orderDate = order.orderDate;
            this.paymentID = order.paymentID;
            this.paymentStatus = order.paymentStatus;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }
}
