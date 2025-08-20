package za.ac.cput.domain;
import jakarta.persistence.*;

import java.util.List;
/*
Product.java
Product POJO class
Author: Thimna Gogwana (222213973)
Date: 25 May 2025
*/
@Entity
@Table(name ="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productID;
    private Long categoryID;
    private String title;
    private String description;
    private double price;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @OneToMany(mappedBy = "product")
    private List<OrderItem> orderItems;

    protected Product() {
    }

    private Product(Builder builder) {
        this.productID = builder.productID;
        this.categoryID = builder.categoryID;
        this.title = builder.title;
        this.description = builder.description;
        this.price = builder.price;
    }

    public Long getProductID() { return productID; }
    public Long getCategoryID() { return categoryID; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", categoryID=" + categoryID +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }

    public static class Builder {
        private Long productID;
        private Long categoryID;
        private String title;
        private String description;
        private double price;

        public Builder setProductID(Long productID) {
            this.productID = productID;
            return this;
        }

        public Builder setCategoryID(Long categoryID) {
            this.categoryID = categoryID;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public Builder copy(Product product) {
            this.productID = product.productID;
            this.categoryID = product.categoryID;
            this.title = product.title;
            this.description = product.description;
            this.price = product.price;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }
}

