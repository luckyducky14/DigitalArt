package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.CartItem;
import za.ac.cput.domain.Review;
import za.ac.cput.repository.CartItemRepository;
import za.ac.cput.repository.ReviewRepository;

import java.util.List;
/*
ReviewService.java
ReviewService POJO class
Author: Thandolwethu P Mseleku
Date: 16/07/2025
*/
@Service
public class ReviewService implements IReviewService  {

    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Review create(Review review) {return reviewRepository.save(review);

    }

    @Override
    public Review read(Long reviewId) {
        return reviewRepository.findById(reviewId).orElse(null);
    }

    @Override
    public Review update(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public void delete(Long reviewId) {
    this.reviewRepository.deleteById(reviewId);

    }

    @Override
    public List<Review> getAll() {
        return this.reviewRepository.findAll();


    }

    public List<Review> findByProductID(Long productID) {
        return reviewRepository.findReviewByProduct_ProductID(productID);
    }
}
