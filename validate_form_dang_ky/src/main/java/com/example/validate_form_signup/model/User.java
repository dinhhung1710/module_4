package com.example.validate_form_signup.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity(name = "user")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Mật khẩu không được để trống")
    @Size(min = 6, message = "Mật khẩu phải có ít nhất 6 ký tự")
    private String password;

    @NotBlank(message = "Email không được để trống")
    @Email(message = "Email không đúng định dạng")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "Số điện thoại không được để trống")
    @Pattern(regexp = "^(0|\\+84)[0-9]{9}$", message = "Số điện thoại không hợp lệ")
    @Column(name = "phone_number", unique = true)
    private String phoneNumber;

    @Min(value = 18, message = "Tuổi phải từ 18 trở lên")
    @Max(value = 100, message = "Tuổi không quá 100")
    private int age;

    @NotBlank(message = "Họ không được để trống")
    @Size(max = 50, message = "Họ tối đa 50 ký tự")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "Tên không được để trống")
    @Size(max = 50, message = "Tên tối đa 50 ký tự")
    @Column(name = "last_name")
    private String lastName;
}
