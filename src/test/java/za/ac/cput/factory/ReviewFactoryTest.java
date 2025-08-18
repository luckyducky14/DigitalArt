package za.ac.cput.factory;

import org.junit.jupiter.api.*;
import za.ac.cput.domain.Product;
import za.ac.cput.domain.Review;
import za.ac.cput.domain.User;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class ReviewFactoryTest {

    static User user = new User.Builder()
            .setFirstName("Thando")
            .setLastName("Mseleku")
            .setEmail("123@gmail.com")
            .setPassword("password123")
            .build();
    static Product product = new Product.Builder()
            .setProductID("P001")
            .setTitle("Digital Art")
            .setDescription("A beautiful digital painting")
            .setPrice(49.99)
            .setCategoryID("C001")
            .build();


    private static Review review1 = ReviewFactory.createReview(user,product,5,"Exceptional design",
            LocalDate.now());

    private static Review review2 = ReviewFactory.createReview(user,product,7, "Nice art!",
            LocalDate.now()
    );

    @Test
    @Order(1)
    void createReview() {
        assertNotNull(review1);
        System.out.println(review1.toString());
    }

    @Test
    @Order(2)
    void createReviewWithInvalidiRating(){
        assertNull(review2);
        System.out.println("Failed to create review due to invalid rating: "+review2);
    }

    @Test
    @Disabled
    @Order(3)
    void createReviewNotYetImplemented(){


    }
}