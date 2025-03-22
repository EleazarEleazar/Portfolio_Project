package com.example.elizar_project_1.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CustomerReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "rating")
    private int rating;

    public CustomerReview(String title, String content, int rating) {
        this.title = title;
        this.content = content;
        this.rating = rating;
    }

    public void setRating(int rating) {
        if (rating >= 0 && rating <= 10) {
            this.rating = rating;
        } else {
            throw new IllegalArgumentException("Rating must be between 0 and 10");
        }
    }

}
