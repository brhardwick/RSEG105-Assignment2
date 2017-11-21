package rseg105.project2.part1.dao;

import java.util.List;

import rseg105.project2.part1.models.*;

public interface BookDao {

	Book getByID(int Id);

	void delete(Book book);

	Book save(Book book);

	List<Book> getAllWithDetail();

	List<Book> getAllWithoutDetail();
}
