package librarysb.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import librarysb.example.model.Members;

@Repository
public interface MembersRepository extends JpaRepository<Members, Integer> {
}
