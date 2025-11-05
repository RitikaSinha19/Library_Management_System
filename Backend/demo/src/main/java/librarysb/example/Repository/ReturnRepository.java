package librarysb.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import librarysb.example.model.Return;

@Repository
public interface ReturnRepository extends JpaRepository<Return, Integer> {
}
