package com.example.player_springboot.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Không được để trống")
    @Size(min = 5, max = 50, message = "Tên phải từ 5 đến 50 kí tự")
    private String name;

    @NotBlank(message = "Không được để trống")
    private String country;

    @NotBlank(message = "Không được để trống")
    private String coach;

    @OneToMany(mappedBy = "team")
    private List<Player> players;
}
