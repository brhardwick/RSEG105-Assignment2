package rseg105.project2.part2.app;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import rseg105.project2.part2.services.*;
import rseg105.project2.part2.models.*;

public class Driver {
	public static Logger logger = LoggerFactory.getLogger(Driver.class);

	private GenericXmlApplicationContext ctx;
	private BookService bookServices;
	private CategoryService categoryServices;

	public Driver() {
		ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/app-context-annotation.xml");

		ctx.refresh();
		bookServices = ctx.getBean("BookService", BookService.class);
		categoryServices = ctx.getBean("CategoryService", CategoryService.class);
	}

	public void listAllBooks() {
		printAllBooks(bookServices.getAll());
	}

	public void listAllBooksWithDetail() {

		printAllBooksWithAuthors(bookServices.getAll());

	}

	public void listSpecificBookWithDetail(int id) {
		printSingleBookWithDetails(bookServices.getByID(id));
	}

	public int insertNewBook() {

		Book ToAdd = new Book();

		ToAdd.setTitle("A New Book with a Science category");
		ToAdd.setCategory(categoryServices.getByID(1));

		Author author1 = new Author();
		author1.setDescription("First Author");
		author1.setFirstname("Bradley");
		author1.setLastname("Hardwick");

		Author author2 = new Author();
		author2.setDescription("Second Author");
		author2.setFirstname("John");
		author2.setLastname("Doe");

		ToAdd.addAuthor(author1);
		ToAdd.addAuthor(author2);

		Book NewBook = bookServices.insert(ToAdd);

		return NewBook.getId();
	}

	public void deleteBook(int id) {
		logger.info("------------------------------");
		logger.info("Deleting a book with id " + id + ":");
		logger.info("------------------------------");
		Book ToDelete = bookServices.getByID(id);
		bookServices.delete(ToDelete);

	}

	public void printAllBooks(List<Book> books) {

		logger.info("------------------------------");
		logger.info("Books without Details:");
		logger.info("------------------------------");
		for (Book book : books) {
			logger.info(book.toString());
			logger.info("          ---                 ");
		}
	}

	public void printAllBooksWithAuthors(List<Book> books) {

		logger.info("------------------------------");
		logger.info("Books with details:");
		logger.info("------------------------------");
		for (Book book : books) {
			logger.info(book.toString());

			Set<Author> authors = book.getAuthors();
			if (authors != null) {
				for (Author author : authors) {
					logger.info(author.toString());
				}
			}
			Category category = book.getCategory();
			if (category != null) {
				logger.info(category.toString());
			}
			logger.info("          ---                 ");
		}
	}

	public void printSingleBookWithDetails(Book book) {

		if (book == null) {
			logger.info("------------------------------");
			logger.info("Book is null:");
			logger.info("------------------------------");
			return;
		}
		logger.info("------------------------------");
		logger.info("Book with detail:");
		logger.info("------------------------------");

		logger.info(book.toString());

		Set<Author> authors = book.getAuthors();
		if (authors != null) {
			for (Author author : authors) {
				logger.info(author.toString());
			}
		}
		Category category = book.getCategory();
		if (category != null) {
			logger.info(category.toString());
		}
		logger.info("          ---                 ");
	}
}
