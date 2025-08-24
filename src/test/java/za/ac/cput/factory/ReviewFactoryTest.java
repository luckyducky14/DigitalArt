package za.ac.cput.factory;
/*Review FactoryTest.java
Review FactoryTest POJO class
Author: Thandolwethu P Mseleku
Date: 18 May 2025
*/
import org.junit.jupiter.api.*;
import za.ac.cput.domain.Category;
import za.ac.cput.domain.Product;
import za.ac.cput.domain.Review;
import za.ac.cput.domain.User;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class ReviewFactoryTest {

    private static final User user = new User.Builder()
            .setFirstName("Thando")
            .setLastName("Mseleku")
            .setPassword("password123")
            .build();

    private static final Category category = new Category.Builder()
            .setName("Animals").setDescription("zebras running in a jungle").build();

    private static final Product product = new Product.Builder()
            .setTitle("Digital Art")
            .setCategory(category)
            .setDescription("Potrait of zebras running in a jungle")
            .setPrice(10.000)
            .build();

    private static final Review review1 = ReviewFactory.createReview(
            5,
            "Amazing artwork!",
            LocalDate.now(),
            user,
            product
    );

    private static final Review review2 = ReviewFactory.createReview(
            0,
            "Bad artwork",
            LocalDate.of(2025, 8, 23),
            user,
            product
    );

    @Test
    @Order(1)
    void testCreateValidReview() {
        assertNotNull(review1, "Review1 should not be null");
        System.out.println("Review1: " + review1);
    }

    @Test
    @Order(2)
    void testCreateReviewWithInvalidRating() {
        assertNull(review2, "Review2 should be null due to invalid rating");
        System.out.println("Review2 creation failed due to invalid rating");
    }



    @Test
    @Order(4)
    @Disabled("Not yet implemented")
    void testCreateReviewThatNotYetImplemented() {

    }


  
}