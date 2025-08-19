package za.ac.cput.factory;
/*
CartItemFactory.java
CartItemFactory POJO class
Author: Thandolwethu P Mseleku
Date: 18 May 2025
*/
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.CartItem;
import za.ac.cput.domain.Product;
import za.ac.cput.domain.User;
import za.ac.cput.util.Helper;

public class CartItemFactory {
    public static CartItem createCartItem(Cart cart, Product product,User user, int quantity,double price) {
        if (quantity <= 0){
            return null;
            }

        return new CartItem.Builder()
                .setCart(cart)
                .setUser(user)
                .setProduct(product)
                .setQuantity(quantity)
                .setPrice(price)
                .build();
    }
}
