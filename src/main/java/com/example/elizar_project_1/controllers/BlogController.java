package com.example.elizar_project_1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogController {

    @GetMapping("/blog")
    public String blog(Model model) {
        model.addAttribute("twitter", "https://x.com/elonmusk");
        model.addAttribute("facebook", "https://www.facebook.com/BillGates/");
        return "blog";
    }
}
