package za.ac.cput.domain;

/*
Cart.java
Cart POJO class
Author: Bekithemba Mrwetyana (222706066)
Date: 01 May 2025
*/

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long cartID; // put it as a Long

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private List<CartItem> cartItems;

    protected Cart(){}

    public Cart(Builder builder) {
        this.cartID = builder.cartID;
        this.user = builder.userID;
        this.cartItems = builder.cartItems;
    }

    public Long getCartID() {
        return cartID;
    }

    public User getUserID() {
        return user;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartID=" + cartID +
                ", userID=" + user +
                ", cartItem=" + cartItems +
                '}';
    }

    public static class Builder{

        private Long cartID;
        private User userID;
        private List<CartItem> cartItems;

        public Builder setCartID(Long cartID) {
            this.cartID = cartID;
            return this;
        }

        public Builder setUserID(User user) {
            this.userID = userID;
            return this;
        }

        public Builder setCartItem(List<CartItem> cartItems) {
            this.cartItems = cartItems;
            return this;
        }

        public Builder copy(Cart cart){
            this.cartID = cart.cartID;
            this.userID = cart.user;
            this.cartItems = cart.cartItems;
            return this;
        }
        public Cart build(){
            return new Cart(this);
        }

    }

}

