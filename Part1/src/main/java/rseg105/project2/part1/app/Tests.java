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

public class Tests {
	public static Logger logger = LoggerFactory.getLogger(Tests.class);

	private GenericXmlApplicationContext ctx;
	private BookDao bookDao;
	private CategoryDao categoryDao;

	public Tests() {
		ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/app-context-annotation.xml");

		ctx.refresh();
		bookDao = ctx.getBean("bookDao", BookDao.class);
		categoryDao = ctx.getBean("categoryDao", CategoryDao.class);

	}

	public void Test_ListAllBooks() {
		this.listAllBooks(bookDao.getAll());
	}

	public void Test_ListAllBooksWithDetail() {

		listAllBooksWithAuthors(bookDao.getAll());

	}

	public void Test_SpecificBookWithDetail() {
		listSingleBookWithDetails(bookDao.getByID(1));
	}
	
	public void Test_InsertNewBook()
	{
		listAllBooksWithAuthors(bookDao.getAll());

		Book ToAdd = new Book();
		ToAdd.setId(1);
		ToAdd.setTitle("A New Book");
		ToAdd.setCategory(categoryDao.getByID(1));

		Author author1 = new Author();
		author1.setDescription("My First");
		author1.setFirstname("Bradley");
		author1.setLastname("Hadly");
		author1.setId(100);

		ToAdd.addAuthor(author1);

		bookDao.save(ToAdd);
		listSingleBookWithDetails(bookDao.getByID(1));

	}
	
	public void Test_DeleteaBook()
	{
		Book ToDelete = bookDao.getByID(1);
		bookDao.delete(ToDelete);
		

	}

	public void listAllBooks(List<Book> books) {

		logger.info("------------------------------");
		logger.info("Books without Details:");
		logger.info("------------------------------");
		for (Book book : books) {
			logger.info(book.toString());
			logger.info("          ---                 ");
		}
	}

	public void listAllBooksWithAuthors(List<Book> books) {

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

	public void listSingleBookWithDetails(Book book) {

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
