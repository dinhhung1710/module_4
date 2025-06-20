package com.example.ung_dung_muon_sach.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({OutOfBookException.class, InvalidCodeException.class})
    public String handleCustomExceptions(Exception ex, Model model) {
        model.addAttribute("message", ex.getMessage());
        return "error";
    }
}
