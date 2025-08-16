package za.ac.cput.factory;
/*
CartFactory.java
Cart Factory class
Author: Bekithemba Mrwetyana 222706066
Date: 17 May 2025
*/
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.CartItem;
import za.ac.cput.domain.User;
import za.ac.cput.util.Helper;

import java.util.List;

public class CartFactory {

    public static Cart createCart(User user, List<CartItem> cartItems) {
//        if (Helper.isNullOrEmpty(cartItems)) {
//            return null;
//        }
//        if (quantity < 0){
//            return null;
//        }
//        if (cartIterms <= 0){
//            return null;
//        }
        // Basic validation

        if (cartItems == null) {
            throw new IllegalArgumentException("Cart items list cannot be null.");
        }

        return new Cart.Builder()
                .setCartItem(cartItems)
                .build();
    }
}

