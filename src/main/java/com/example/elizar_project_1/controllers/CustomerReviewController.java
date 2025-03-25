package com.example.elizar_project_1.controllers;

import com.example.elizar_project_1.models.CustomerReview;
import com.example.elizar_project_1.services.CustomerReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("reviews")
public class CustomerReviewController {

    private final CustomerReviewService customerReviewService;

    @Autowired
    public CustomerReviewController(CustomerReviewService customerReviewService) {
        this.customerReviewService = customerReviewService;
    }

    @GetMapping
    public String showReviews(Model model) {
        model.addAttribute("reviews", customerReviewService.getAllCustomersReview());
        return "reviews";
    }

    @GetMapping("/{id}")
    public String showReviewById(@PathVariable Long id, Model model) {
        CustomerReview customerReview = customerReviewService.getCustomerReviewById(id);
        if (customerReview == null) {
            return "redirect:/reviews";
        }
        model.addAttribute("review", customerReview);
        return "review-details";
    }

    @PostMapping("/add")
    public String addReview(
            @RequestParam String title,
            @RequestParam String content,
            @RequestParam int rating) {

        CustomerReview customerReview = new CustomerReview(title, content, rating);

        customerReviewService.addCustomerReview(customerReview);
        return "redirect:/reviews";
    }

    @PostMapping("/update")
    public String updateReview(
            @RequestParam Long id,
            @RequestParam String title,
            @RequestParam String content,
            @RequestParam int rating) {

        CustomerReview customerReview = new CustomerReview(id, title, content, rating);

        customerReviewService.updateCustomerReview(customerReview);
        return "redirect:/reviews";
    }

    @PostMapping("/delete")
    public String deleteReview(@RequestParam Long id) {
        customerReviewService.deleteCustomerReviewById(id);
        return "redirect:/reviews";
    }

    @GetMapping("/search-by-title")
    public String findReviewByTitle(Model model, @RequestParam String title) {
        model.addAttribute("review", customerReviewService.findReviewByTitle(title));

        return "review-details";
    }

    @GetMapping("/search-by-rating")
    public String findReviewByRating(Model model, @RequestParam int rating) {
        model.addAttribute("review", customerReviewService.findReviewByRating(rating));

        return "review-details";
    }
}
