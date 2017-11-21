package rseg105.project2.part1.app;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import rseg105.project2.part1.dao.BookDao;
import rseg105.project2.part1.dao.CategoryDao;
import rseg105.project2.part1.models.Author;
import rseg105.project2.part1.models.Book;
import rseg105.project2.part1.models.Category;

public class Driver {
	public static Logger logger = LoggerFactory.getLogger(Driver.class);

	private GenericXmlApplicationContext ctx;
	private BookDao bookDao;
	private CategoryDao categoryDao;

	public Driver() {
		ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/app-context-annotation.xml");

		ctx.refresh();
		bookDao = ctx.getBean("bookDao", BookDao.class);
		categoryDao = ctx.getBean("categoryDao", CategoryDao.class);

	}

	public int insertNewBook() {
		Book toAdd = new Book();
		toAdd.setTitle("A Book to Test With");
		toAdd.setCategory(categoryDao.getByID(1));
		toAdd.setIsbn("987654210");
		toAdd.setPrice(50.25);
		
		Author author1 = new Author();
		author1.setDescription("The one doing this assignment");
		author1.setFirstname("Bradley");
		author1.setLastname("Hadly");
		
		Author author2 = new Author();
		author2.setDescription("The one most likely grading this assignment");
		author2.setFirstname("Vitaly");
		author2.setLastname("Yurik");

		toAdd.addAuthor(author1);
		toAdd.addAuthor(author2);

		Book newBook = bookDao.save(toAdd);
		return newBook.getId();

	}

	public void deleteaBook(int id) {
		Book ToDelete = bookDao.getByID(id);
		bookDao.delete(ToDelete);

	}

	public void listAllBooks() {

		List<Book> books = bookDao.getAllWithoutDetail();
		logger.info("------------------------------");
		logger.info("Books without Details:");
		logger.info("------------------------------");
		for (Book book : books) {
			logger.info(book.toString());
			logger.info("          ---                 ");
		}
	}

	public void listAllBooksWithDetails() {

		List<Book> books = bookDao.getAllWithDetail();
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

	public void listSingleBookWithDetails(int id) {

		Book book = bookDao.getByID(id);
		if (book == null)
		{
			logger.info("------------------------------");
			logger.info("Cannot find the book:");
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
