package za.ac.cput.factory;
/*
CartItemFactory.java
CartItemFactory POJO class
Author: Thandolwethu P Mseleku
Date: 18 May 2025
*/
import za.ac.cput.domain.CartItem;
import za.ac.cput.util.Helper;

public class CartItemFactory {
    public static CartItem createCartItem(int cartItemID,int cartID,int productID,int quantity) {
        if(!Helper.isValidCartItemID(cartItemID) || !Helper.isValidProductID(productID) ||
                !Helper.isValidQuantity(quantity) ||! Helper.isValidCartID(cartID)) {
            return null;
        }
        return new CartItem.Builder().setCartItemID(cartItemID).
                setCartID(cartID).setProductID(productID).setQuantity(quantity).build();
    }
}
