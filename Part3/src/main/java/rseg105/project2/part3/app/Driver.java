package rseg105.project2.part3.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import rseg105.project2.part3.models.Author;
import rseg105.project2.part3.models.Book;
import rseg105.project2.part3.services.BookService;
import rseg105.project2.part3.services.CategoryService;

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

	public long insertBook() {
		logger.info("Inserting a book with the title 'A New Book' by 'John Doe':");
		logger.info("----------------------------------------------------");
		Book NewBook = new Book();
		NewBook.setTitle("A New Book");
		NewBook.setIsbn("123456789");
		NewBook.setPrice((double)50.23);
		NewBook.setCategory(categoryServices.getByID(1));
		
		Author author1 = new Author();
		author1.setDescription("The First one");
		author1.setFirstname("John");
		author1.setLastname("Doe");
		NewBook.addAuthor(author1);
		Book savedBook = bookServices.insertBook(NewBook);
		return savedBook.getId();
	}
	
	public void deleteBook(long id) {
		logger.info("Deleting a book with id of "+ id + ":");
		logger.info("----------------------------------------------------");
		bookServices.deleteBook(bookServices.findByID(id));		
	}
	public void listAllBooks() {
		bookServices.listAllBooks();
	}

	public void listSpecificBookWithDetail(long id) {		
		bookServices.listBook(id);
	}

	
}
