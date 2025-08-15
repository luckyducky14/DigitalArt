package za.ac.cput.factory;

import za.ac.cput.domain.Wishlist;
import za.ac.cput.domain.Product;
import za.ac.cput.domain.User;

import java.util.List;

public class WishlistFactory {

    public static Wishlist createWishlist(Long WishListID, User user, List<Product> products) {

        return new Wishlist.Builder()
                .setUser(user)
                .setProducts(products)
                .build();
    }
}

