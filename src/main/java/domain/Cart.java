package domain;

/*
Cart.java
Cart POJO class
Author: Bekithemba Mrwetyana (222706066)
Date: 01 May 2025
*/

import java.util.List;

public class Cart {

    private int cartID;
    private int userID;
    private List<Product> items;

    private Cart(Builder builder) {
        this.cartID = builder.cartID;
        this.userID = builder.userID;
        this.items = builder.items;
    }

    public int getCartID() {
        return cartID;
    }

    public int getUserID() {
        return userID;
    }

    public List<Product> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartID=" + cartID +
                ", userID=" + userID +
                ", itemId=" + items +
                '}';
    }

    public static class Builder{

        private int cartID;
        private int userID;
        private List<Product> items;

        public Builder setCartID(int cartID) {
            this.cartID = cartID;
            return this;
        }

        public Builder setUserID(int userID) {
            this.userID = userID;
            return this;
        }

        public Builder setItems(List<Product> items) {
            this.items = items;
            return this;
        }

        public Builder copy(Cart cart){
            this.cartID = cart.cartID;
            this.userID = cart.userID;
            this.items = cart.items;
            return this;
        }

    }

}

