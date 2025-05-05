package domain;
/*
 OrderItem.java
 OrderItem POJO class
 Author : Thimna Gogwana 222213973
 Date: 05 May 2025
*/
public class OrderItem {
    private int itemID;
    private int orderID;
    private int productID;
    private int quantity;
    private double unitPrice;
    private double subTotal;

    private OrderItem(Builder builder) {
        this.itemID = builder.itemID;
        this.orderID = builder.orderID;
        this.productID = builder.productID;
        this.quantity = builder.quantity;
        this.unitPrice = builder.unitPrice;
        this.subTotal = builder.subTotal;
    }

    public int getItemID() {
        return itemID;
    }

    public int getOrderID() {
        return orderID;
    }

    public int getProductID() {
        return productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public double getSubTotal() {
        return subTotal;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "itemID=" + itemID +
                ", orderID=" + orderID +
                ", productID=" + productID +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                ", subTotal=" + subTotal +
                '}';
    }

    public static class Builder {

        private int itemID;
        private int orderID;
        private int productID;
        private int quantity;
        private double unitPrice;
        private double subTotal;

        public Builder setItemID(int itemID) {
            this.itemID = itemID;
            return this;
        }

        public Builder setOrderID(int orderID) {
            this.orderID = orderID;
            return this;
        }

        public Builder setProductID(int productID) {
            this.productID = productID;
            return this;
        }

        public Builder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder setUnitPrice(double unitPrice) {
            this.unitPrice = unitPrice;
            return this;
        }

        public Builder calculateSubTotal() {
            this.subTotal = this.unitPrice * this.quantity;
            return this;
        }

        public Builder setSubTotal(double subTotal) {
            this.subTotal = subTotal;
            return this;
        }

        public Builder copy(OrderItem item) {
            this.itemID = item.itemID;
            this.orderID = item.orderID;
            this.productID = item.productID;
            this.quantity = item.quantity;
            this.unitPrice = item.unitPrice;
            this.subTotal = item.subTotal;
            return this;
        }

        public OrderItem build() {
            return new OrderItem(this);
        }
    }
}













