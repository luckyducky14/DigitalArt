package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Discount;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DiscountFactoryTest {

    @Test
    void createValidDiscount() {
        Discount discount = DiscountFactory.createDiscount(
                "SUMMER25",
                new BigDecimal("25"),
                LocalDate.of(2025, 8, 1),
                LocalDate.of(2025, 8, 31)
        );

        assertNotNull(discount);
        assertEquals("SUMMER25", discount.getCode());
        assertEquals(new BigDecimal("25"), discount.getPercentage());
        assertEquals(LocalDate.of(2025, 8, 1), discount.getStartDate());
        assertEquals(LocalDate.of(2025, 8, 31), discount.getEndDate());
    }
}