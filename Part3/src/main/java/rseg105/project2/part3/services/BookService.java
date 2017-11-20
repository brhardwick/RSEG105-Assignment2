package rseg105.project2.part3.services;

import java.util.List;

import rseg105.project2.part3.models.Book;

public interface BookService {
	List<Book> findAll();

	Book findByID(long Id);

	void deleteBook(Book book);

	void listBook(long id);

	Book insertBook(Book book);

	void listAllBooks();
}
