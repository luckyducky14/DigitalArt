package za.ac.cput.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "inventory")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inventoryID;

    @OneToOne
    @JoinColumn(name = "productID", referencedColumnName = "productID")
    private Product product;

    private int quantity;
    private LocalDateTime lastUpdated;

    protected Inventory() {}

    public Inventory(Builder builder) {
        this.inventoryID = builder.inventoryID;
        this.product = builder.product;
        this.quantity = builder.quantity;
        this.lastUpdated = builder.lastUpdated;
    }

    // Getters
    public Long getInventoryID() { return inventoryID; }
    public Product getProduct() { return product; }
    public int getQuantity() { return quantity; }
    public LocalDateTime getLastUpdated() { return lastUpdated; }

    // Builder
    public static class Builder {
        private Long inventoryID;
        private Product product;
        private int quantity;
        private LocalDateTime lastUpdated;

        public Builder setInventoryID(Long inventoryID) { this.inventoryID = inventoryID; return this; }
        public Builder setProduct(Product product) { this.product = product; return this; }
        public Builder setQuantity(int quantity) { this.quantity = quantity; return this; }
        public Builder setLastUpdated(LocalDateTime lastUpdated) { this.lastUpdated = lastUpdated; return this; }

        public Builder copy(Inventory inventory) {
            this.inventoryID = inventory.inventoryID;
            this.product = inventory.product;
            this.quantity = inventory.quantity;
            this.lastUpdated = inventory.lastUpdated;
            return this;
        }

        public Inventory build() { return new Inventory(this); }
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "inventoryID=" + inventoryID +
                ", product=" + product +
                ", quantity=" + quantity +
                ", lastUpdated=" + lastUpdated +
                '}';
    }
}
