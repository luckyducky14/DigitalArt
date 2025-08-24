package za.ac.cput.service;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.*;
import za.ac.cput.factory.ReviewFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ReviewServiceTest {

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    private User savedUser;
    private Category savedCategory;
    private Product savedProduct;
    private Review savedReview;

    @BeforeAll
    void setup() {

        savedUser = userService.create(new User.Builder()
                .setFirstName("Thando")
                .setLastName("Mseleku")
                .setPassword("password123")
                .setLastLogin(LocalDateTime.now())
                .setCreateDate(LocalDate.of(2025,05,24))
                .build());

        assertNotNull(savedUser, "User must be saved successfully");


        savedCategory = categoryService.create(new Category.Builder()
                .setName("Paintings")
                .setDescription("Digital Painting Category")
                .build());

        assertNotNull(savedCategory, "Category must be saved successfully");


        savedProduct = productService.create(new Product.Builder()
                .setTitle("Sunset Art")
                .setDescription("A beautiful digital sunset painting")
                .setPrice(59.99)
                .setCategory(savedCategory)
                .build());

        assertNotNull(savedProduct, "Product must be saved successfully");
    }

    @Test
    @Order(1)
    void testCreateReview() {
        Review review = ReviewFactory.createReview(
                5,
                "I am impressed with this art,definetly buying soonn again!",
                LocalDate.now(),
                savedUser,
                savedProduct
        );

        assertNotNull(review, "Factory returned null; check rating, comment, user, and product");

        savedReview = reviewService.create(review);

        assertNotNull(savedReview, " review must not be null");
        assertNotNull(savedReview.getReviewId(), "Review ID should be generated");
        assertEquals(5, savedReview.getRating());

        System.out.println("Created Review: " + savedReview);
    }

    @Test
    @Order(2)
    @Transactional
    void testReadReview() {
        assertNotNull(savedReview, "savedReview must exist before reading");

        Review review = reviewService.read(savedReview.getReviewId());

        assertNotNull(review, "Review read should not be null");
        assertEquals("Amazing quality artwork!", review.getComment());

        System.out.println("Read Review: " + review);
    }

    @Test
    @Order(3)
    @Transactional
    void testUpdateReview() {
        assertNotNull(savedReview, "savedReview must exist before update");

        Review updatedReview = new Review.Builder()
                .copy(savedReview)
                .setRating(4)
                .setComment("Great art, but shipping was slow")
                .build();

        savedReview = reviewService.update(updatedReview);

        assertNotNull(savedReview, "Updated review must not be null");
        assertEquals(4, savedReview.getRating());
        assertEquals("Great art, but shipping was slow", savedReview.getComment());

        System.out.println("Updated Review: " + savedReview);
    }

    @Test
    @Order(4)
    @Transactional
    void testGetAllReviews() {
        List<Review> allReviews = reviewService.getAll();

        assertFalse(allReviews.isEmpty(), "Review list should not be empty");
        assertTrue(allReviews.stream().anyMatch(r -> r.getReviewId().equals(savedReview.getReviewId())));

        System.out.println("All Reviews: " + allReviews);
    }

    @Test
    @Order(5)
    void testDeleteReview() {
        assertNotNull(savedReview, "savedReview must exist before deletion");

        reviewService.delete(savedReview.getReviewId());

        Review deleted = reviewService.read(savedReview.getReviewId());
        assertNull(deleted, "Deleted review should not be found");

        System.out.println("Deleted Review with ID: " + savedReview.getReviewId());
    }

}
