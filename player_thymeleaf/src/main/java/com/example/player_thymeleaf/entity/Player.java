package com.example.player_thymeleaf.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String fullName;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dayOfBirth;

    private String experience;

    private String position;

    private String avatar;

    public Player(int id, String fullName, LocalDate dayOfBirth, String experience, String position, String avatar) {
        this.id = id;
        this.fullName = fullName;
        this.dayOfBirth = dayOfBirth;
        this.experience = experience;
        this.position = position;
        this.avatar = avatar;
    }

    public Player() {
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getFullName() {return fullName;}
    public void setFullName(String fullName) {this.fullName = fullName;}

    public LocalDate getDayOfBirth() {return dayOfBirth;}
    public void setDayOfBirth(LocalDate dayOfBirth) {this.dayOfBirth = dayOfBirth;}

    public String getExperience() {return experience;}
    public void setExperience(String experience) {this.experience = experience;}

    public String getPosition() {return position;}
    public void setPosition(String position) {this.position = position;}

    public String getAvatar() {return avatar;}
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
