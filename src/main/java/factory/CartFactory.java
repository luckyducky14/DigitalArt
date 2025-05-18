package factory;

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

