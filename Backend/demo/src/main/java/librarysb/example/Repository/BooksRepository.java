package librarysb.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import librarysb.example.model.Books;

@Repository
public interface BooksRepository extends JpaRepository<Books, Integer> {
}
