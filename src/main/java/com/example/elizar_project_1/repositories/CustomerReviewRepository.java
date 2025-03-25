package com.example.elizar_project_1.repositories;

import com.example.elizar_project_1.models.CustomerReview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerReviewRepository extends JpaRepository<CustomerReview, Long> {

    Optional<CustomerReview> findByRating(int rating);

    Optional<CustomerReview> findByTitle(String title);
}

