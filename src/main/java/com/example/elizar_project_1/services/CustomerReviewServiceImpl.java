package com.example.elizar_project_1.services;

import com.example.elizar_project_1.models.CustomerReview;
import com.example.elizar_project_1.repositories.CustomerReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerReviewServiceImpl implements CustomerReviewService {

    private final CustomerReviewRepository customerReviewRepository;

    @Autowired
    public CustomerReviewServiceImpl(CustomerReviewRepository customerReviewRepository) {
        this.customerReviewRepository = customerReviewRepository;
    }


    @Override
    public List<CustomerReview> getAllCustomersReview() {
        return customerReviewRepository.findAll();
    }

    @Override
    public CustomerReview addCustomerReview(CustomerReview customerReview) {
        if (customerReview.getRating() < 0 || customerReview.getRating() > 10) {
            throw new IllegalArgumentException("Rating must be between 0 and 10");
        }
        return customerReviewRepository.save(customerReview);
    }

    @Override
    public CustomerReview getCustomerReviewById(Long id) {

        return customerReviewRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Customer review not found"));
    }

    @Override
    public CustomerReview updateCustomerReview(CustomerReview customerReview) {
        if (!customerReviewRepository.existsById(customerReview.getId())) {
            throw new IllegalArgumentException("Review for updating not found");
        }
        return customerReviewRepository.save(customerReview);
    }

    @Override
    public void deleteCustomerReviewById(Long id) {
        if (!customerReviewRepository.existsById(id)) {
            throw new IllegalArgumentException("Review for deletion not found");
        }
        customerReviewRepository.deleteById(id);
    }

    //мои кастомные методы
    @Override
    public CustomerReview findReviewByRating(int rating) {

        return customerReviewRepository.findByRating(rating)
                .orElseThrow(() -> new IllegalArgumentException("No reviews found with that rating"));
    }

    @Override
    public CustomerReview findReviewByTitle(String title) {

        return customerReviewRepository.findByTitle(title)
                .orElseThrow(() -> new IllegalArgumentException("No reviews found with that title"));
    }
}
