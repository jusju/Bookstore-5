package com.example.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.CategoryRepository;

@Controller
public class BookController {
	@Autowired
	private BookRepository repository;
	
	@Autowired
	private CategoryRepository crepository;

	// Get list of books from repository to bookList.html
	@RequestMapping("/booklist")
	public String getBookList(Model model) {
		model.addAttribute("bookList", repository.findAll());
		System.out.println("PROGRAM READS: " + repository.findAll());
		return "bookList";
	}

	// Map new book model to addBook.html
	@RequestMapping(value = "/add")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", crepository.findAll());
		return "addBook";
	}

	// Map form submit to save book to repository then redirect to show
	// bookList.html
	@PostMapping(value = "/save")
	public String save(Book book) {
		repository.save(book);
		return "redirect:/booklist";
	}

	// Map delete by id then redirect to list
	@GetMapping(value = "/delete/{id}")
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		repository.deleteById(bookId);
		return "redirect:../booklist";
	}

	// Map current book model to editBook.html
	@RequestMapping(value = "/edit/{id}")
	public String editBook(@PathVariable("id") Long bookId, Model model) {
		model.addAttribute("book", repository.findById(bookId));
		model.addAttribute("categories", crepository.findAll());
		return "editBook";
	}
}
