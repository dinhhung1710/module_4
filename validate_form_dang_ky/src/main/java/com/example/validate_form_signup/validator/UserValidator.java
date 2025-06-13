package com.example.validate_form_signup.validator;

import com.example.validate_form_signup.model.User;
import com.example.validate_form_signup.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    @Autowired
    private IUserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;

        // First name
        if (user.getFirstName() == null || user.getFirstName().trim().isEmpty()) {
            errors.rejectValue("firstName", "firstName.empty", "First name is required");
        } else if (user.getFirstName().length() < 3 || user.getFirstName().length() > 45) {
            errors.rejectValue("firstName", "firstName.length", "3–45 characters");
        }

        // Last name
        if (user.getLastName() == null || user.getLastName().trim().isEmpty()) {
            errors.rejectValue("lastName", "lastName.empty", "Last name is required");
        } else if (user.getLastName().length() < 2 || user.getLastName().length() > 45) {
            errors.rejectValue("lastName", "lastName.length", "2–45 characters");
        }

        // Password
        if (user.getPassword() == null || user.getPassword().trim().isEmpty()) {
            errors.rejectValue("password", "password.empty", "Password is required");
        } else if (user.getPassword().length() < 5 || user.getPassword().length() > 45) {
            errors.rejectValue("password", "password.length", "5–45 characters");
        }

        // Email
        if (user.getEmail() == null || user.getEmail().trim().isEmpty()) {
            errors.rejectValue("email", "email.empty", "Email is required");
        } else if (!user.getEmail().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            errors.rejectValue("email", "email.invalid", "Invalid email");
        } else if (userService.existsByEmail(user.getEmail())) {
            errors.rejectValue("email", "email.exists", "Email already used");
        }

        // Phone number
        if (user.getPhoneNumber() == null || user.getPhoneNumber().trim().isEmpty()) {
            errors.rejectValue("phoneNumber", "phone.empty", "Phone number is required");
        } else if (!user.getPhoneNumber().matches("^0[0-9]{9}$")) {
            errors.rejectValue("phoneNumber", "phone.invalid", "Must start with 0 and have 10 digits");
        } else if (userService.existsByPhoneNumber(user.getPhoneNumber())) {
            errors.rejectValue("phoneNumber", "phone.exists", "Phone number already used");
        }

        // Age
        if (user.getAge() < 18) {
            errors.rejectValue("age", "age.invalid", "Age must be at least 18");
        }
    }
}
