package librarysb.example.model;

import jakarta.persistence.*;  // For @Entity, @Table, @Id, etc.
import lombok.*;               // For @Getter, @Setter, @NoArgsConstructor, @AllArgsConstructor
import java.time.LocalDate;     // For LocalDate

@Entity
@Table(name = "returns") // or "returns" if "return" conflicts with SQL keyword
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Return {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int returnId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "borrow_id")
    private Borrow borrow;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "member_id")
    private Members member;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id")
    private Books book;

    private LocalDate dateReturned;
}
