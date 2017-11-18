package rseg105.project2.part3.services;


import java.util.List;

import rseg105.project2.part3.models.Book;
public interface BookService {
	List<Book> findAll();
	Book findByID(Long Id);
	void listSpecificBookWithDetail();	    
}
