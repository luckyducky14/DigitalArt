package factory;

import domain.Payment;
import util.Helper;

import java.time.LocalDate;

public class PaymentFactory {

    public static Payment createPayment(String paymentID, LocalDate paymentDate, double amount, String status, String method){

        if(amount <= 0 || Helper.isNullOrEmpty(status) || Helper.isNullOrEmpty(method)){
            return null;
        }
        
        return new Payment.Builder()
                .setPaymentID(paymentID)
                .setAmount(amount)
                .setStatus(status)
                .setMethod(method)
                .build();
    }
    public static Payment createPayment(LocalDate paymentDate, double amount, String status, String method){
        if(amount <= 0 || Helper.isNullOrEmpty(status) || Helper.isNullOrEmpty(method)){
            return null;
        }
        if(paymentDate == null){
            return null;
        }

        LocalDate now = LocalDate.now();
        return new Payment.Builder()
                .setPaymentDate(now)
                .setAmount(amount)
                .setStatus(status)
                .setMethod(method)
                .build();

    }


}
