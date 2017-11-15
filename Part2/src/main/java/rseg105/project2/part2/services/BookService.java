package rseg105.project2.part2.services;


import java.util.List;

import rseg105.project2.part2.models.*;
public interface BookService {

	  List<Book> getAll();
	  Book getByID(int Id);
	  void delete(Book book);
	  Book insert(Book book);	    
}
