package librarysb.example.service;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import librarysb.example.model.*;
import librarysb.example.Repository.*;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LibraryServiceImpl implements LibraryService {

    private final BooksRepository bookRepo;
    private final MembersRepository memberRepo;
    private final BorrowRepository borrowRepo;
    private final ReturnRepository returnRepo;

    // ----------------- BOOKS -----------------
    @Override
    public List<Books> getAllBooks() {
        return bookRepo.findAll();
    }

    @Override
    public Books addBook(Books book) {
        return bookRepo.save(book);
    }

    // ----------------- MEMBERS -----------------
    @Override
    public List<Members> getAllMembers() {
        return memberRepo.findAll();
    }

    @Override
    public Members addMember(Members member) {
        return memberRepo.save(member);
    }

    // ----------------- BORROW -----------------
    @Override
    public List<Borrow> getAllBorrowed() {
        return borrowRepo.findAll();
    }

    @Override
    public Borrow borrowBook(int memberId, int bookId) {
        Members member = memberRepo.findById(memberId)
                .orElseThrow(() -> new RuntimeException("Member not found"));
        Books book = bookRepo.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        if (book.getQuantity() <= 0) {
            throw new RuntimeException("Book not available");
        }

        // Decrease quantity
        book.setQuantity(book.getQuantity() - 1);
        bookRepo.save(book);

        // Create borrow record
        Borrow borrow = new Borrow();
        borrow.setMember(member);
        borrow.setBook(book);
        borrow.setDateBorrowed(LocalDate.now());

        return borrowRepo.save(borrow);
    }

    // ----------------- RETURN -----------------
    @Override
    public List<Return> getAllReturned() {
        return returnRepo.findAll();
    }

    @Override
    public Return returnBook(int memberId, int bookId) {
        Borrow borrow = borrowRepo.findAll().stream()
                .filter(b -> b.getMember() != null && b.getBook() != null
                        && b.getMember().getId() == memberId
                        && b.getBook().getId() == bookId)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Borrow record not found"));

        Books book = borrow.getBook();

        // Increase quantity
        book.setQuantity(book.getQuantity() + 1);
        bookRepo.save(book);

        // Delete borrow record immediately
        borrowRepo.delete(borrow);

        // Create return record
        Return ret = new Return();
        ret.setMember(borrow.getMember());
        ret.setBook(book);
        ret.setDateReturned(LocalDate.now());

        return returnRepo.save(ret);
    }
}
