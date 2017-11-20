package rseg105.project2.part3.services;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rseg105.project2.part3.models.Author;
import rseg105.project2.part3.models.Book;
import rseg105.project2.part3.models.Category;
import rseg105.project2.part3.repositories.BookRepository;

@Service("BookService")
@Repository
@Transactional
public class BookServiceImpl implements BookService {

	private static Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);

	@Autowired
	private BookRepository bookRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Book> findAll() {
		List<Book> books = (List<Book>) bookRepository.findAll();
		return books;
	}

	@Override
	public Book findByID(long Id) {
		Book book = bookRepository.findOne(Id);
		return book;
	}

	@Transactional
	@Override
	public void listBook(long id) {
		printSingleBookWithDetails(this.findByID(id));
	}

	@Transactional
	@Override
	public void listAllBooks() {
		printBooksWithDetails(this.findAll());
	}

	public void printSingleBookWithDetails(Book book) {

		if (book == null) {
			logger.info("------------------------------");
			logger.info("Could not find the book");
			logger.info("------------------------------");
			return;

		}

		Set<Author> authors = book.getAuthors();
		Category category = book.getCategory();

		logger.info("------------------------------");
		logger.info("Book with detail:");
		logger.info("------------------------------");
		logger.info(book.toString());

		if (authors != null) {
			for (Author author : authors) {
				logger.info(author.toString());
			}
		}
		if (category != null) {
			logger.info(category.toString());
		}
		logger.info("          ---                 ");
	}

	public void printBooksWithDetails(List<Book> books) {

		logger.info("------------------------------");
		logger.info("Books with details:");
		logger.info("------------------------------");
		for (Book book : books) {

			Set<Author> authors = book.getAuthors();
			Category category = book.getCategory();

			logger.info(book.toString());
			if (authors != null) {
				for (Author author : authors) {
					logger.info(author.toString());
				}
			}

			if (category != null) {
				logger.info(category.toString());
			}
			logger.info("          ---                 ");
		}
	}

	@Override
	public void deleteBook(Book book) {
		bookRepository.delete(book);
	}

	@Override
	public Book insertBook(Book book) {
		return bookRepository.save(book);
		

	}

}
