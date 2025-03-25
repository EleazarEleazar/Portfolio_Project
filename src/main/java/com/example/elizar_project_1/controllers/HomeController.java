package com.example.elizar_project_1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Добро пожаловать в моё портфолио");
        model.addAttribute("description",
                "Я разработчик с опытом " +
                "создания современных веб-приложений. " +
                "Здесь вы можете ознакомиться " +
                "с моими проектами и профессиональным опытом.");
        return "home";
    }
}