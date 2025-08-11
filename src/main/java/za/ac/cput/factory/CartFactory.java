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

    public static Cart createCart(String cartID, User userID, List<CartItem> cartItems) {
        if (Helper.isNullOrEmpty(cartID)) {
            return null;
        }

        return new Cart.Builder()
                .setCartItem(cartItems)
                .setCartID(cartID)
                .setUserID(userID)
                .build();
    }
}

