package librarysb.example.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "books")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Book_name", nullable = false)
    private String bookName;

    @Column(name = "Author_name")
    private String authorName;

    private String genre;

    private int quantity;
}
