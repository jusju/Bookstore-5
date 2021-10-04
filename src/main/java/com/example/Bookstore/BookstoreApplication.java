package com.example.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;
import com.example.Bookstore.domain.User;
import com.example.Bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Autowired
	private BookRepository repository;

	@Autowired
	private CategoryRepository crepository;

	@Autowired
	private UserRepository urepository;

	@Bean
	CommandLineRunner runner() {
		return args -> {
			// Add Category objects and save to db
			Category category1 = new Category("fantasy");
			Category category2 = new Category("war fiction");
			crepository.save(category1);
			crepository.save(category2);

			// Test Data
			Book book = new Book("Sheepfarmer’s Daughter", "Elizabeth Moon", "978-0-671-65416-0", 1988, 15.99,
					category1);
			repository.save(book);
			book = new Book("Divided Allegiance", "Elizabeth Moon", "978-0-671-69786-0", 1988, 15.99, category1);
			repository.save(book);
			book = new Book("Oath of Gold", "Elizabeth Moon", "978-0-671-69798-3", 1989, 15.99, category1);
			repository.save(book);
			book = new Book("Semper Fi", "W.E.B. Griffin", "0-515-08749-1", 1986, 9.99, category2);
			repository.save(book);

			// Create users: admin/admin user/user
			User user1 = new User("user", "USER", "$2a$10$Ho3mcGwGAiE/y896/SeEvus89L7SNS8h8EHqvO2UGjqYc2JARr..K");
			User user2 = new User("admin", "ADMIN", "$2a$10$lrthSAfYPE5eFJTFNJeWOej.wUST/FrUUKfq71Bxz4xxcmNLy4cvW");
			urepository.save(user1);
			urepository.save(user2);

			log.info("fetch all books");
			for (Book fbook : repository.findAll()) {
				log.info(fbook.toString());
			}

		};
	}

}
