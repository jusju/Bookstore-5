package com.example.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;


@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookRepositoryTest {
	
	@Autowired
	private BookRepository brepository;
	
	@Test
	public void initialBooksAreReturned() {
		List<Book> books = brepository.findByTitle("Oath of Gold");
		
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getAuthor()).isEqualTo("Elizabeth Moon");
	}
	
	@Test 
	public void createNewBook() {
		Book book = new Book("The Da Vinci Code", "Dan Brown", "0-385-50420-9", 2003, 15.99, new Category("Mystery"));
		brepository.save(book);
		assertThat(book.getId()).isNotNull();
	}
}
