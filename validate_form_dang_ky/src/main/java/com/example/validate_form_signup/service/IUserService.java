package com.example.validate_form_signup.service;

import com.example.validate_form_signup.model.User;

public interface IUserService {
    void save(User user);
    User findByEmail(String email);
    boolean existsByEmail(String email);
    boolean existsByPhoneNumber(String phone);
}
