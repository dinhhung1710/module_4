package com.example.ung_dung_muon_sach.controller;

import com.example.ung_dung_muon_sach.model.Book;
import com.example.ung_dung_muon_sach.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String showList(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "list";
    }

    @GetMapping("/book/{id}")
    public String showDetail(@PathVariable int id, Model model) {
        model.addAttribute("book", bookService.findById(id));
        return "detail";
    }

    @PostMapping("/borrow/{id}")
    public String borrow(@PathVariable int id, RedirectAttributes redirect) {
        String code = bookService.borrowBook(id);
        redirect.addFlashAttribute("message", "Mượn thành công! Mã của bạn: " + code);
        return "redirect:/";
    }

    @GetMapping("/return")
    public String showReturnPage() {
        return "return";
    }

    @PostMapping("/return")
    public String returnBook(@RequestParam String code, RedirectAttributes redirect) {
        bookService.returnBook(code);
        redirect.addFlashAttribute("message", "Trả sách thành công.");
        return "redirect:/";
    }
}
