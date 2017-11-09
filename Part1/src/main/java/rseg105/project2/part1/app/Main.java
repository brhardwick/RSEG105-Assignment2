package rseg105.project2.part1.app;

import org.springframework.orm.hibernate4.HibernateTransactionManager;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.context.support.GenericXmlApplicationContext;
import rseg105.*;
import rseg105.project2.part1.dao.BookDao;
import rseg105.project2.part1.dao.CategoryDao;
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
		printAllBooks(bookDao.getAll());
	}
	
	
	private static void printAllBooks(List<Book> books) {
    	
		logger.info("------------------------------");
    	logger.info("Listing contacts without details:");
    	for (Book book: books) {
    		logger.info(book.toString());
    		logger.info("");
    	}
    	
    	
    }  
	
}
