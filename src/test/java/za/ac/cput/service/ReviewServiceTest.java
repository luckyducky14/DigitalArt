package za.ac.cput.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Product;
import za.ac.cput.domain.Review;
import za.ac.cput.domain.User;
import za.ac.cput.factory.ReviewFactory;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ReviewServiceTest {
    @Autowired
    private IReviewService reviewService;
   static User user = new User.Builder().setUserId(123L).setFirstName("Thando")
            .setLastName("Mseleku").setPassword("password").build();

    static Product product = new Product.Builder()
            .setProductID("P001")
            .setTitle("Digital Art")
            .setDescription("A beautiful digital painting")
            .setPrice(49.99)
            .setCategoryID("C001")
            .build();

    private static Review review1 =ReviewFactory.createReview(2,"Poor design",LocalDate.now(),user,product);
    @Test
    @Order(1)
    void create() {
        Review created = reviewService.create(review1);
        assertNotNull(created);
        assertNotNull(created);
    }

    @Test
    @Order(2)
    void read() {
        Review read = reviewService.read(review1.getReviewId());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    @Order(3)
    void update() {

        Review newReview = new Review.Builder().copy(review1).setComment("Bad design").build();
         Review updated = reviewService.update(newReview);
         assertEquals("Bad design", updated.getComment());
        System.out.println(updated);
    }

    @Test
    @Order(4)
    void delete() {
   reviewService.delete(review1.getReviewId());
   Review deleted = reviewService.read(review1.getReviewId());
    assertNull(deleted);
    System.out.println(" Review Deleted Successfully");

    }

    @Test
    @Order(5)
    void getAll() {
        System.out.println(reviewService.getAll());

    }
}