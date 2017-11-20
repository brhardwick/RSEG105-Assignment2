package rseg105.project2.part3.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
	public static Logger logger = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		logger.info("Starting Assignment 2 Application:");
		logger.info("----------------------------------------------------");
		Driver driver = new Driver();

		logger.info("Getting all the books:");
		driver.listAllBooks();
		driver.listSpecificBookWithDetail(2);
		Long i = driver.insertBook();
		logger.info("Inserted the book with id of " + i.toString());
		driver.listSpecificBookWithDetail(i);
		driver.deleteBook(i);
		logger.info("Trying to find the book that was deleted:");
		driver.listSpecificBookWithDetail(i);
		return;
	}
}
