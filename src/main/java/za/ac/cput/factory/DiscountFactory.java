package za.ac.cput.factory;

import za.ac.cput.domain.Discount;
import za.ac.cput.util.Helper;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DiscountFactory {

    public static Discount createDiscount(String code, BigDecimal percentage, LocalDate startDate, LocalDate endDate){

        if(Helper.isNullOrEmpty(code)){
            return null;
        }
        if (percentage == null || percentage.compareTo(BigDecimal.ZERO) < 0 || percentage.compareTo(new BigDecimal("100")) > 0) {
            return null;
        }

        if (startDate == null || endDate == null || endDate.isBefore(startDate)) {
            return null;
        }

        return new Discount.Builder().setCode(code)
                .setPercentage(percentage)
                .setStartDate(startDate)
                .setEndDate(endDate)
                .build();

    }

}
