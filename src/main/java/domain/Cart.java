package domain;

/*
Cart.java
Cart POJO class
Author: Bekithemba Mrwetyana (222706066)
Date: 01 May 2025
*/

import java.util.List;

public class Cart {

    private String cartID;
    private String userID;
    private CartItem cartItem;

    private Cart(Builder builder) {
        this.cartID = builder.cartID;
        this.userID = builder.userID;
        this.cartItem = builder.cartItem;
    }

    public String getCartID() {
        return cartID;
    }

    public String getUserID() {
        return userID;
    }

    public CartItem getCartItem() {
        return cartItem;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartID=" + cartID +
                ", userID=" + userID +
                ", cartItem=" + cartItem +
                '}';
    }

    public static class Builder{

        private String cartID;
        private String userID;
        private CartItem cartItem;

        public Builder setCartID(String cartID) {
            this.cartID = cartID;
            return this;
        }

        public Builder setUserID(String userID) {
            this.userID = userID;
            return this;
        }

        public Builder setCartItem(CartItem cartItem) {
            this.cartItem = cartItem;
            return this;
        }

        public Builder copy(Cart cart){
            this.cartID = cart.cartID;
            this.userID = cart.userID;
            this.cartItem = cart.cartItem;
            return this;
        }
        public Cart build(){
            return new Cart(this);
        }

    }

}

