package rseg105.project2.part1.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
	public static Logger logger = LoggerFactory.getLogger(Main.class);
	
	public static void main(String[] args) {
		logger.info("Starting Assignment 2.1 Application:");
		logger.info("----------------------------------------------------");
		Driver driver = new Driver();
		logger.info("Getting all the books without details:");
		driver.listAllBooks();
		
		logger.info("Getting all the books with details:");
		driver.listAllBooksWithDetails();
		
		logger.info("Inserting a new book:");
		int newId = driver.insertNewBook();
		
		logger.info("Getting the new book with details:");
		driver.listSingleBookWithDetails(newId);
		
		logger.info("Deleting the new book:");
		driver.deleteaBook(newId);
		
		logger.info("Verifying the book is not in database:");
		driver.listSingleBookWithDetails(newId);
	}

}
