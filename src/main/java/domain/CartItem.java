package domain;

import jakarta.persistence.*;

/*
CartItem.java
CartItem POJO class
Author: Thandolwethu P Mseleku
Date: 25/05/2025
*/

@Entity
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartItemID;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cartID")
    private Cart cart;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "productID")
    private Product product;

    private int quantity;

    protected CartItem() {
    }

    public CartItem(Builder builder) {
        this.cartItemID = builder.cartItemID;
        this.cart = builder.cart;
        this.product = builder.product;
        this.quantity = builder.quantity;
    }

    public int getCartItemID() {
        return cartItemID;
    }

    public Cart getCart() {
        return cart;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public static class Builder {
        private int cartItemID;
        private Cart cart;
        private Product product;
        private int quantity;

        public Builder setCartItemID(int cartItemID) {
            this.cartItemID = cartItemID;
            return this;
        }

        public Builder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder setProduct(Product product) {
            this.product = product;
            return this;
        }

        public Builder setCart(Cart cart) {
            this.cart = cart;
            return this;
        }

        public Builder copy(CartItem cartItem) {
            this.cartItemID = cartItem.cartItemID;
            this.cart = cartItem.cart;
            this.product = cartItem.product;

            this.quantity = cartItem.quantity;
            return this;

        }

        public CartItem build() {
            return new CartItem(this);
        }
    }
}
