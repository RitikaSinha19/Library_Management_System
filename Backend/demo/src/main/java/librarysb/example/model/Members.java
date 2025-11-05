package librarysb.example.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "members")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Members {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Name", nullable = false)
    private String name;

    private String email;
    private String phone;
    private LocalDate dateOfMembership;
    private LocalDate endOfMembership;
}
