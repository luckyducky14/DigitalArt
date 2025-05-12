package factory;

import domain.Payment;

import java.time.LocalDateTime;

public class PaymentFactory {

    public static Payment createPayment(int paymentID, LocalDateTime paymentDate, double amount, String status, String method){

        if (amount <= 0 || status == null || method == null){
            return null;
        }

        return new Payment.Builder()
                .setPaymentID(paymentID)
                .setPaymentDate(paymentDate)
                .setAmount(amount)
                .setStatus(status)
                .setMethod(method)
                .build();
    }

}
