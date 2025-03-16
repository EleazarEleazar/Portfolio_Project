package com.example.elizar_project_1.controllers;

import com.example.elizar_project_1.models.CustomerReview;
import com.example.elizar_project_1.services.CustomerReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomerReviewController {

    private final CustomerReviewService customerReviewService;

    @Autowired
    public CustomerReviewController(CustomerReviewService customerReviewService) {
        this.customerReviewService = customerReviewService;
    }

    @GetMapping("/reviews")
    public String showReviews(Model model) {
        model.addAttribute("reviews", customerReviewService.getAllCustomersReview());
        return "reviews";
    }

    @PostMapping("/reviews/add")
    public String addReview(
            @RequestParam String title,
            @RequestParam String content,
            @RequestParam int rating) {

        CustomerReview customerReview = new CustomerReview(title, content, rating);

        customerReviewService.addCustomerReview(customerReview);
        return "redirect:/reviews";
    }
}
