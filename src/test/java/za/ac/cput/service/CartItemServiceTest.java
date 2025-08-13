package za.ac.cput.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.CartItem;
import za.ac.cput.domain.Product;
import za.ac.cput.factory.CartItemFactory;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class CartItemServiceTest {
    @Autowired
    private ICartItemService service;
    static Cart cart = new Cart.Builder()
            .setCartID(123L)
            .build();

    static Product product = new Product.Builder()
            .setProductID("P456")
            .build();

private final CartItem cartItem = CartItemFactory.createCartItem(cart,product,10);

    
CartItemServiceTest(ICartItemService service){this.service=service;}


    @Test
    void a_create() {
        CartItem newCartItem = service.create(cartItem);
        assertNotNull(newCartItem);
        System.out.println(newCartItem);
    }

    ;

    @Test
    void b_read() {

        CartItem read = service.read(cartItem.getCartItemID());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void c_update() {
        CartItem newCartItem = new CartItem.Builder().copy(cartItem).setQuantity(50).build();
        CartItem updated = service.update(newCartItem);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    void d_getAll() {
        System.out.println(service.getAll());

    }
}