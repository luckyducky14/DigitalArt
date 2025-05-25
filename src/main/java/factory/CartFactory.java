package factory;
/*
CartFactory.java
Cart Factory class
Author: Bekithemba Mrwetyana 222706066
Date: 17 May 2025
*/
import domain.Cart;
import domain.CartItem;
import util.Helper;

public class CartFactory {

    public static Cart createCart(String cartID, String userID, CartItem cartItem) {
        if (Helper.isNullOrEmpty(cartID) || Helper.isNullOrEmpty(userID)){
            return null;
        }
        if (cartItem == null) {
            return null;
        }
        return new Cart.Builder()
                .setCartItem(cartItem)
                .setCartID(cartID)
                .setUserID(userID)
                .build();
    }
}

