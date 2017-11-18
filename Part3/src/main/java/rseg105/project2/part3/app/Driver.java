package rseg105.project2.part3.app;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import rseg105.project2.part3.services.*;
import rseg105.project2.part3.models.*;

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
		printAllBooks(bookServices.findAll());
	}

	public void listSpecificBookWithDetail() {
		
		bookServices.listSpecificBookWithDetail();
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

	public void deleteBook(Book book) {

	}

	public void printSingleBookWithDetails(Book book) {

		if (book == null) {
			logger.info("------------------------------");
			logger.info("Could not find the book");
			logger.info("------------------------------");

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
