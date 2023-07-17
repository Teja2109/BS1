package com.example.bs.repository;

import com.example.bs.entity.MyBooks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyBookRepository extends JpaRepository<MyBooks, Integer> {

}