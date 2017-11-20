package rseg105.project2.part3.repositories;

import org.springframework.data.repository.CrudRepository;

import rseg105.project2.part3.models.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
  
}
