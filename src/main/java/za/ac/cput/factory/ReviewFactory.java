package za.ac.cput.factory;

import za.ac.cput.domain.Product;
import za.ac.cput.domain.Review;
import za.ac.cput.domain.User;
import za.ac.cput.util.Helper;

import java.time.LocalDate;
/*
ReviewFactory.java
ReviewFactory class
Author: Thandolwethu P Mseleku
Date: 16/07/2025
*/

public class ReviewFactory {
    public static Review createReview(int rating,String comment, LocalDate reviewDate,User user, Product product) {

       if(rating <1 || rating > 5   || Helper.isNullOrEmpty(comment)) {

           return null;
       }
        return  new Review.Builder().setUser(user).setProduct(product).setRating(rating).
                setComment(comment).setReviewDate(reviewDate).build();
    }
}
