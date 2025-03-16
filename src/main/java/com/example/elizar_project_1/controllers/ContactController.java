package com.example.elizar_project_1.controllers;

import com.example.elizar_project_1.models.Contact;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ContactController {

    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("title", "Буду рад знакомству!");
        model.addAttribute("description", "*Звонки принимаю с 12:00 до 17:00");
        model.addAttribute("contacts", List.of(
                new Contact("Почта", "JustExample@google.com"),
                new Contact("Телефон", "+7 (999) 222-33-44"),
                new Contact("Адрес", "город Шарм-Эль-Шейх, ул.ТрудаВПотеЛица")
        ));
        return "contact";
    }
}
