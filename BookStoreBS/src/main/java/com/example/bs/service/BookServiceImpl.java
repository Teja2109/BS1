package com.example.bs.service;

import com.example.bs.entity.Book;
import com.example.bs.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public void saveBook(Book book) {
		bookRepository.save(book);
	}

	@Override
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	@Override
	public List<Book> getHumorBooks() {
		return bookRepository.findAll();
	}

	@Override
	public Book getBookById(int Id) {
		return bookRepository.findById(Id).get();
	}

	@Override
	public void deleteById(int Id) {
		bookRepository.deleteById(Id);
	}
}