package domain;

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

        public int getCartID() {
            return cartID;
        }

        public int getUserID() {
            return userID;
        }

        public List<Product> getItems() {
            return items;
        }

        public Builder copy(Cart cart){
            this.cartID = cart.cartID;
            this.userID = cart.userID;
            this.items = cart.items;
            return this;
        }

    }

}

