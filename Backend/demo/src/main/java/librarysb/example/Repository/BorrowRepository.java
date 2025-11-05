package librarysb.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import librarysb.example.model.Borrow;

@Repository
public interface BorrowRepository extends JpaRepository<Borrow, Integer> {
}
