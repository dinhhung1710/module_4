package com.example.ung_dung_muon_sach.service;

import com.example.ung_dung_muon_sach.exception.InvalidCodeException;
import com.example.ung_dung_muon_sach.exception.OutOfBookException;
import com.example.ung_dung_muon_sach.model.Book;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookService {
    private final Map<Integer, Book> books = new HashMap<>();
    private final Map<String, Integer> borrowCodes = new HashMap<>();

    public BookService() {
        books.put(1, new Book(1, "Java Core", 2));
        books.put(2, new Book(2, "Spring Boot", 3));
        books.put(3, new Book(3, "Database Fundamentals", 1));
    }

    public List<Book> findAll() {
        return new ArrayList<>(books.values());
    }

    public Book findById(Integer id) {
        return books.get(id);
    }

    public String borrowBook(int id) {
        Book book = books.get(id);
        if (book.getQuantity() <= 0) {
            throw new OutOfBookException("Sách đã hết!");
        }
        book.setQuantity(book.getQuantity() - 1);
        String code = String.format("%05d", new Random().nextInt(100000));
        borrowCodes.put(code, id);
        return code;
    }

    public void returnBook(String code) {
        Integer id = borrowCodes.remove(code);
        if (id == null) {
            throw new InvalidCodeException("Mã mượn không hợp lệ!");
        }
        Book book = books.get(id);
        book.setQuantity(book.getQuantity() + 1);
    }
}
