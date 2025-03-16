package com.example.elizar_project_1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Добро пожаловать на мой сайт!");
        model.addAttribute("description", "Вы на главной странице моего портфолио.");
        model.addAttribute("links", List.of(
                "Главная",
                "Мой Блог",
                "Контакты",
                "Отзывы"));
        return "home";
    }

}
