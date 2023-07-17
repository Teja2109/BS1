package com.example.bs.controller;

import com.example.bs.entity.Book;
import com.example.bs.entity.MyBooks;
import com.example.bs.service.BookService;
import com.example.bs.service.MyBookListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;

	@Autowired
	private MyBookListService myBookListService;

	@GetMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("/book_category")
	public String bookCategory() {
		return "bookCategory";
	}

	@GetMapping("/humor_books")
	public String humor() {
		return "humor";
	}

	@GetMapping("/thriller_books")
	public String thriller() {
		return "thriller";
	}

	@GetMapping("/fiction_books")
	public String fiction() {
		return "fiction";
	}

	@GetMapping("/action_books")
	public String action() {
		return "action";
	}

	@GetMapping("/romance_books")
	public String romance() {
		return "romance";
	}

	@GetMapping("/register_book")
	public String registerBook() {
		return "registerBook";
	}

	@GetMapping("available_books")
	public ModelAndView getAllBooks() {
		List<Book> list = bookService.getAllBooks();
		ModelAndView m = new ModelAndView();
		m.setViewName("bookList");
		m.addObject("book", list);
		return m;
	}
	@PostMapping("/saveBook")
	public String saveBook(@ModelAttribute Book book) {
		bookService.saveBook(book);
		return "redirect:/available_books";
	}

	@GetMapping("/my_books")
	public String myBooks(Model model) {
		List<MyBooks> myBooks = myBookListService.getMyAllBooks();
		model.addAttribute("book", myBooks);
		return "myBooks";
	}

	@RequestMapping("/myList/{id}")
	public String getMyList(@PathVariable("id") int Id) {
		Book book = bookService.getBookById(Id);
		MyBooks myBook = new MyBooks(book.getId(), book.getName(), book.getAuthor(), book.getPrice());
		myBookListService.save(myBook);
		return "redirect:/my_books";
	}

	@RequestMapping("/editBook/{id}")
	public String editBook(@PathVariable("id") int Id, Model model) {
		Book book = bookService.getBookById(Id);
		model.addAttribute("book", book);
		return "editBook";
	}

	@RequestMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable("id") int Id) {
		bookService.deleteById(Id);
		return "redirect:/available_books";
	}
}