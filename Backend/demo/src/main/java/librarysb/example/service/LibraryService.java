package librarysb.example.service;

import librarysb.example.model.*;
import java.util.List;

public interface LibraryService {

    // BOOKS
    List<Books> getAllBooks();
    Books addBook(Books book);

    // MEMBERS
    List<Members> getAllMembers();
    Members addMember(Members member);

    // BORROW
    List<Borrow> getAllBorrowed();
    Borrow borrowBook(int memberId, int bookId);

    // RETURN
    List<Return> getAllReturned();
    Return returnBook(int memberId, int bookId);
}
