package za.ac.cput.domain;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long discountId;
    private String code;
    private BigDecimal percentage;
    private LocalDate startDate;
    private LocalDate endDate;

    protected Discount() {}

    private Discount(Builder builder) {
        this.discountId = builder.discountId;
        this.code = builder.code;
        this.percentage = builder.percentage;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
    }

    public Long getDiscountId() { return discountId; }
    public String getCode() { return code;
    }
    public BigDecimal getPercentage() {
        return percentage;
    }
    public LocalDate getStartDate() {
        return startDate; }
    public LocalDate getEndDate() {
        return endDate; }

    public static class Builder {
        private Long discountId;
        private String code;
        private BigDecimal percentage;
        private LocalDate startDate;
        private LocalDate endDate;

        public Builder setDiscountId(Long discountId) {
            this.discountId = discountId;
            return this;
        }
        public Builder setCode(String code) {
            this.code = code;
            return this;
        }
        public Builder setPercentage(BigDecimal percentage) {
            this.percentage = percentage;
            return this;
        }
        public Builder setStartDate(LocalDate startDate) {
            this.startDate = startDate;
            return this;
        }
        public Builder setEndDate(LocalDate endDate) {
            this.endDate = endDate;
            return this;
        }

        public Builder copy(Discount discount){
            this.discountId = discount.discountId;
            this.code = discount.code;
            this.percentage = discount.percentage;
            this.startDate = discount.startDate;
            this.endDate = discount.endDate;
            return this;
        }

        public Discount build() {
            return new Discount(this); }
    }
}
