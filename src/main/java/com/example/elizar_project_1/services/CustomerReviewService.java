package com.example.elizar_project_1.services;

import com.example.elizar_project_1.models.CustomerReview;
import com.example.elizar_project_1.models.Project;

import java.util.List;

public interface CustomerReviewService {

    List<CustomerReview> getAllCustomersReview();

    CustomerReview getCustomerReviewById(Long id);

    CustomerReview addCustomerReview(CustomerReview customerReview);

    CustomerReview updateCustomerReview(CustomerReview customerReview);

    void deleteCustomerReviewById(Long id);

    // мои кастомные методы из репозитория
    CustomerReview findReviewByRating(int rating);

    CustomerReview findReviewByTitle(String title);

}
