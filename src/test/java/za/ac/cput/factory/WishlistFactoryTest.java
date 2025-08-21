package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Product;
import za.ac.cput.domain.User;
import za.ac.cput.domain.Wishlist;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WishlistFactoryTest {

    @Test
    void createWishlist() {
        Wishlist wishlist = WishlistFactory.createWishlist(1L, null, null);
        assertNotNull(wishlist);
        assertEquals(1L, wishlist.getWishlistID());
        assertNull(wishlist.getUser());
        assertNull(wishlist.getProducts());
    }

    @Test
    void createWishlistWithNullValues() {
        Wishlist wishlist = WishlistFactory.createWishlist(null, null, null);
        assertNotNull(wishlist);
        assertNull(wishlist.getWishlistID());
        assertNull(wishlist.getUser());
        assertNull(wishlist.getProducts());
    }

    @Test
    void createWishlistWithEmptyProductList() {
        List<Product> emptyProducts = new ArrayList<>();
        Wishlist wishlist = WishlistFactory.createWishlist(1L, null, emptyProducts);
        assertNotNull(wishlist);
        assertEquals(1L, wishlist.getWishlistID());
        assertNull(wishlist.getUser());
        assertEquals(0, wishlist.getProducts().size());
    }

    @Test
    void createWishlistWithValidUserAndProducts() {
        User user = new User.Builder()
                .setUserId(1L)
                .setFirstName("John")
                .setLastName("Doe")
                .build();

        Product product = new Product.Builder()
                .setProductID(123L)
                .setTitle("Test Product")
                .setDescription("Sample product")
                .setPrice(50.0)
                .build();

        List<Product> products = new ArrayList<>();
        products.add(product);

        Wishlist wishlist = WishlistFactory.createWishlist(1L, user, products);

        assertNotNull(wishlist);
        assertEquals(1L, wishlist.getWishlistID());
        assertEquals(user, wishlist.getUser());
        assertEquals(1, wishlist.getProducts().size());
        assertEquals(product, wishlist.getProducts().get(0));
    }
}

