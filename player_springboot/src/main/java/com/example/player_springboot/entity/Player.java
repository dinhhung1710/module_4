package com.example.player_springboot.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Không để trống")
    @Size(min = 5, max = 50, message = "Tên phải từ 5 đến 50 ký tự")
    private String fullName;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dayOfBirth;

    @NotBlank(message = "Không để trống")
    private String experience;

    @NotBlank(message = "Không để trống")
    private String position;

    @NotBlank(message = "Không được để trống")
    @Pattern(
            regexp = "^(https?|ftp)://[^\\s/$.?#].[^\\s]*$",
            message = "Đường dẫn không hợp lệ"
    )
    private String avatar;

    @ManyToOne
    @JoinColumn(name = "team_id")
    @NotNull(message = "Cầu thủ phải thuộc về một đội tuyển")
    private Team team;
}
