package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.CartItem;
import za.ac.cput.domain.Product;
import za.ac.cput.factory.CartItemFactory;
/*
CartItemControllerTest.java
CartItemControllerTest POJO class
Author: Thandolwethu P Mseleku
Date: 07 Aug 2025
*/
import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CartItemControllerTest {

    private static CartItem cartItem;

    @Autowired
    private TestRestTemplate restTemplate;
    private static final String BASE_URL = "http://localhost:8080/cartItem/";

    @BeforeAll
    public static void setUp() {
         Cart cart = new Cart.Builder()
                .setCartID("C123")
                .build();

         Product product = new Product.Builder()
                .setProductID("P456")
                .build();

        cartItem = CartItemFactory.createCartItem(cart,product,5);
    }
 @Test
    void a_create(){
        String url = BASE_URL + "create";
     ResponseEntity<CartItem>postResponse = restTemplate.postForEntity(url, cartItem, CartItem.class);
     assertNotNull(postResponse);
     assertNotNull(postResponse.getBody());
     assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
     CartItem cartItemCreated = postResponse.getBody();
     assertEquals(cartItem.getCartItemID(), cartItemCreated.getCartItemID());
     System.out.println("cartItemCreated = " + cartItemCreated);
     cartItem = cartItemCreated;
 }

 @Test
    void b_read(){
        String url = BASE_URL + "read" + cartItem.getCartItemID();
        System.out.println("url = " + url);
        ResponseEntity<CartItem>response = restTemplate.getForEntity(url, CartItem.class);
        assertEquals(cartItem.getCartItemID(), response.getBody().getCartItemID());
     System.out.println(response.getBody());
 }
 @Test

 void c_update(){
        CartItem updatedCartItem = new CartItem.Builder().copy(cartItem).setQuantity(100).build();
        String url = BASE_URL + "update";
        restTemplate.put(url, updatedCartItem);
        ResponseEntity<CartItem>response = restTemplate.getForEntity(BASE_URL + "read" + cartItem.getCartItemID(), CartItem.class);
        assertNotNull(response.getBody());
     System.out.println(response.getBody());
     cartItem = response.getBody();
     System.out.println("updated data = " + cartItem);
 }
 @Test
 @Disabled
    void d_delete(){

        String url = BASE_URL + "delete" + cartItem.getCartItemID();
     System.out.println(" URL = " + url);

     restTemplate.delete(url);

     ResponseEntity<CartItem>response = restTemplate.getForEntity(BASE_URL + "read" + cartItem.getCartItemID(), CartItem.class);
     assertNull(response.getBody());
     System.out.println("Deleted: true");
 }

 @Test
    void e_getAll(){
        String url =BASE_URL + "/getAll";
     System.out.println("URL = " + url);
     ResponseEntity<CartItem[]>response = restTemplate.getForEntity(url, CartItem[].class);
     assertNotNull(response.getBody());
     System.out.println("All cart items: ");
     for (CartItem cartItem : response.getBody()) {
         System.out.println(cartItem);
     }
 }

}