package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.*;
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
private static Cart cart;
private static User user;
private static Product product;

@Autowired
private TestRestTemplate restTemplate;
private static final String BASE_URL = "/cart_item/";

    @BeforeAll
    public static void setUp() {

         user = new User.Builder().setUserId(123L).setFirstName("Thando")
                .setLastName("Mseleku").setPassword("password").build();


         cart = new Cart.Builder()
                .setUserID(user)
                .build();

        product = new Product.Builder()
                .setProductID("P001")
                .setTitle("Digital Art")
                .setDescription("A beautiful digital painting")
                .setPrice(49.99)
                .setCategoryID("C001")
                .build();

        cartItem = CartItemFactory.createCartItem(cart,product,user,25,10.000);
    }
 @Test
    void a_create(){
        String url = BASE_URL + "/create";
     ResponseEntity<CartItem>postResponse = restTemplate.postForEntity(url, cartItem, CartItem.class);
     assertNotNull(postResponse);
     assertNotNull(postResponse.getBody());
     CartItem cartItemCreated = postResponse.getBody();
     assertEquals(cartItem.getCartItemID(), cartItemCreated.getCartItemID());
     System.out.println("cartItemCreated = " + cartItemCreated);

 }

 @Test
    void b_read(){
        String url = BASE_URL + "/read" + cartItem.getCartItemID();
        ResponseEntity<CartItem>response = this.restTemplate.getForEntity(url, CartItem.class);
        assertEquals(cartItem.getCartItemID(), response.getBody().getCartItemID());
     System.out.println("read =" + response.getBody());
 }

    @Test
 void c_update(){
        CartItem updatedCartItem = new CartItem.Builder().copy(cartItem).setQuantity(100).build();
        String url = BASE_URL + "/update";
        System.out.println("URL = " + url);

        ResponseEntity<CartItem> response = restTemplate.exchange(
                url,
                HttpMethod.PUT,
                new HttpEntity<>(updatedCartItem),
                CartItem.class
        );
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(100, response.getBody().getQuantity());
        cartItem = response.getBody();
     System.out.println("updated" +response.getBody());

 }


    @Test
    void d_getAll(){
        String url =BASE_URL + "/getAll";
        ResponseEntity<CartItem[]>response = this.restTemplate.getForEntity(url, CartItem[].class);
        assertNotNull(response.getBody());
        assertTrue(response.getBody().length > 0);
        System.out.println("Get All = " + response.getBody());

    }

    @Test
    @Disabled
    void e_delete(){
        String url = BASE_URL + "/delete/" + cartItem.getCartItemID();
        ResponseEntity<Void> deleteResponse = restTemplate.exchange(
                url,
                HttpMethod.DELETE,
                null,
                Void.class
        );


        assertEquals(HttpStatus.NO_CONTENT, deleteResponse.getStatusCode());
        System.out.println("Deleted: true " + cartItem);

        String readUrl = BASE_URL + "/read/" + cartItem.getCartItemID();
        ResponseEntity<CartItem> readResponse = restTemplate.getForEntity(readUrl, CartItem.class);


        assertNull(readResponse.getBody(), "CartItem should be deleted");

 }

}


