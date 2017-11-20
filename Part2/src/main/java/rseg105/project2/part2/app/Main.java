package rseg105.project2.part2.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
	
	public static Logger logger = LoggerFactory.getLogger(Main.class);
	
	public static void main(String[] args) {
		Driver driver = new Driver();
		
		logger.info("Inserting a new book:");
		int newId = driver.insertNewBook();		
		logger.info("Newly entered id is:" +newId);
		logger.info("Getting newly inserted book info:");
		driver.listSpecificBookWithDetail(newId);
		logger.info("Deleting the new book:");		
		driver.deleteBook(newId);
		logger.info("Trying to get info on deleted book:");
		driver.listSpecificBookWithDetail(newId);
		driver.listAllBooksWithDetail();
	
	}
}
