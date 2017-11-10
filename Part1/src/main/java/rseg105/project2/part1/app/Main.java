package rseg105.project2.part1.app;

import org.springframework.orm.hibernate4.HibernateTransactionManager;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.context.support.GenericXmlApplicationContext;
import rseg105.*;
import rseg105.project2.part1.dao.BookDao;
import rseg105.project2.part1.dao.CategoryDao;
import rseg105.project2.part1.models.Author;
import rseg105.project2.part1.models.Book;
import rseg105.project2.part1.models.Category;

public class Main {
	private static Logger logger = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/app-context-annotation.xml");

		ctx.refresh();
		CategoryDao categoryDao = ctx.getBean("categoryDao", CategoryDao.class);
		BookDao bookDao = ctx.getBean("bookDao", BookDao.class);
		listAllBooks(bookDao.getAll());
		listAllBooksWithAuthors(bookDao.getAll());
		listSingleBookWithDetails(bookDao.getByID(1));
	}

	private static void listAllBooks(List<Book> books) {

		logger.info("------------------------------");
		logger.info("Books without Details:");
		logger.info("------------------------------");
		for (Book book : books) {
			logger.info(book.toString());
			logger.info("          ---                 ");
		}
	}

	private static void listAllBooksWithAuthors(List<Book> books) {

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

	private static void listSingleBookWithDetails(Book book) {

		if (book == null)
			return;
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
