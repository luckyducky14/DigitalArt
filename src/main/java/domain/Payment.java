package domain;

/*
Payment.java
Payment POJO class
Author: Bekithemba Mrwetyana (222706066)
Date: 04 May 2025
*/

import java.time.LocalDateTime;

public class Payment {


    private int paymentID;
    private LocalDateTime paymentDate;
    private double amount;
    private String status;
    private String method;

    // Constructors
    public Payment() {}

    public Payment(Builder builder) {
        this.paymentID = builder.paymentID;
        this.paymentDate = builder.paymentDate;
        this.amount = builder.amount;
        this.status = builder.status;
        this.method = builder.method;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public String getStatus() {
        return status;
    }

    public String getMethod() {
        return method;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentID=" + paymentID +
                ", paymentDate=" + paymentDate +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                ", method='" + method + '\'' +
                '}';
    }

    public static class Builder{

        private int paymentID;
        private LocalDateTime paymentDate;
        private double amount;
        private String status;
        private String method;

        public Builder setPaymentID(int paymentID) {
            this.paymentID = paymentID;
            return this;
        }

        public Builder setPaymentDate(LocalDateTime paymentDate) {
            this.paymentDate = paymentDate;
            return this;
        }

        public Builder setAmount(double amount) {
            this.amount = amount;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Builder setMethod(String method) {
            this.method = method;
            return this;
        }

        public Builder copy(Payment payment){
            this.paymentID = payment.paymentID;
            this.paymentDate = payment.paymentDate;
            this.amount = payment.amount;
            this.status = payment.status;
            this.method = payment.method;
            return this;
        }
        public Payment build(){
            return new Payment(this);
        }
    }
}
