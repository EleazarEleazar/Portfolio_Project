package com.example.elizar_project_1.controllers;

import com.example.elizar_project_1.dto.ContactDTO;
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
                new ContactDTO("Почта", "JustExample@google.com"),
                new ContactDTO("Телефон", "+7 (999) 222-33-44"),
                new ContactDTO("Адрес", "город Шарм-Эль-Шейх, ул.ТрудаВПотеЛица")
        ));
        return "contact";
    }
}
