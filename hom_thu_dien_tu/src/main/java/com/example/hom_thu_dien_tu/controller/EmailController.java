package com.example.hom_thu_dien_tu.controller;

import com.example.cau_hinh_hom_thu_dien_tu.model.Email;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmailController {
    @GetMapping("/settings")
    public String showSettings(Model model) {
        Email email = new Email();
        email.setLanguages("English");
        email.setPageSize(25);
        email.setSpamsFilter(false);
        email.setSignature("Thor\nKing, Asgard");

        model.addAttribute("email", email);
        model.addAttribute("languages", new String[]{"English", "Vietnamese", "Japanese", "Chinese"});
        model.addAttribute("pageSizes", new int[]{5, 10, 15, 25, 50, 100});

        return "settings";
    }

    @PostMapping("/update")
    public String updateSettings(@ModelAttribute("email") Email email, Model model) {
        model.addAttribute("email", email);
        return "result";
    }
}
