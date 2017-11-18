package rseg105.project2.part3.services;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.hibernate.annotations.Proxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rseg105.project2.part3.models.*;
import rseg105.project2.part3.repositories.BookRepository;

import java.util.List;

@Service("BookService")
@Repository
@Transactional
public class BookServiceImpl implements BookService {

	private static Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);

	@Autowired
	private BookRepository bookRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Book> findAll() {
		List<Book> books = (List<Book>) bookRepository.findAll();
		return books;
	}

	@Override
	public Book findByID(Long Id) {
		Book book = bookRepository.findOne(Id);
		return book;
	}
	
	@Transactional
	@Override
	public void listSpecificBookWithDetail() {
		printSingleBookWithDetails(this.findByID((long) 1));
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
