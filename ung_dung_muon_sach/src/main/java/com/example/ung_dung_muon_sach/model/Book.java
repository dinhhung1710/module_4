package com.example.ung_dung_muon_sach.model;

public class Book {
    private Integer id;
    private String title;
    private int quantity;

    public Book(Integer id, String title, int quantity) {
        this.id = id;
        this.title = title;
        this.quantity = quantity;
    }

    public Integer getId() { return id; }
    public String getTitle() { return title; }
    public int getQuantity() { return quantity; }

    public void setQuantity(int quantity) { this.quantity = quantity; }
}
