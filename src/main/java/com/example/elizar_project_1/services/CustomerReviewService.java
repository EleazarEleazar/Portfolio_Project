package com.example.elizar_project_1.services;

import com.example.elizar_project_1.models.CustomerReview;

import java.util.List;

public interface CustomerReviewService {

    List<CustomerReview> getAllCustomersReview();
    CustomerReview addCustomerReview(CustomerReview customerReview);

}
