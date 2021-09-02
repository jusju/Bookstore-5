package com.example.Bookstore.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Bookstore.domain.Book;

@Controller
public class BookController {
	
	@RequestMapping("/index")
	public String getBook(Model model) {
		List<Book> bookList = new ArrayList<Book>();
		Book book1 = new Book("Brandon sanderson", "Words of Radiance", 2014, "ISBN-9780765365286", 15.99);
		bookList.add(book1);
		model.addAttribute("bookList", bookList);
		return "bookList";
	}
}
