package com.example.Bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	@Autowired
	private BookRepository repository;
	
	@Autowired
	private CategoryRepository crepository;

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean

	CommandLineRunner runner() {
		return args -> {
			//Add Category objects and save to db
			Category category1 = new Category("fantasy");
			Category category2 = new Category("war fiction");
			crepository.save(category1);
			crepository.save(category2);
		
			// Test Data
			Book book = new Book("Sheepfarmer’s Daughter", "Elizabeth Moon", "978-0-671-65416-0", 1988, 15.99, category1);
			repository.save(book);
			book = new Book("Divided Allegiance", "Elizabeth Moon", "978-0-671-69786-0", 1988, 15.99, category1);
			repository.save(book);
			book = new Book("Oath of Gold", "Elizabeth Moon", "978-0-671-69798-3", 1989, 15.99, category1);
			repository.save(book);
			book = new Book("Semper Fi", "W.E.B. Griffin", "0-515-08749-1", 1986, 9.99, category2);
			repository.save(book);
		};
	}

}
