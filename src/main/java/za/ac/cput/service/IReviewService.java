package za.ac.cput.service;

import za.ac.cput.domain.Review;

import java.util.List;
/*
IReviewService.java
IReviewService class
Author: Thandolwethu P Mseleku
Date: 16/07/2025
*/
public interface IReviewService extends IService<Review,Long> {
    List<Review> getAll();

}
