package rseg105.project2.part3.repositories;

import rseg105.project2.part3.models.*;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
  
}
