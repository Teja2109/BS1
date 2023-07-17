package com.example.bs.service;

import com.example.bs.entity.Book;

import java.util.List;

public interface BookService {
    void saveBook(Book book);
    List<Book> getAllBooks();
    List<Book> getHumorBooks();
    Book getBookById(int Id);
    void deleteById(int Id);
}