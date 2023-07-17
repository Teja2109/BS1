package com.example.bs.service;

import com.example.bs.entity.MyBooks;

import java.util.List;

public interface MyBookListService {
    void save(MyBooks book);
    List<MyBooks> getMyAllBooks();
    void deleteById(int Id);
}