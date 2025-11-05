package librarysb.example.Controller;

import librarysb.example.model.Books;
import librarysb.example.model.Members;
import librarysb.example.model.Borrow;
import librarysb.example.model.Return;
import librarysb.example.service.LibraryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class LibraryController {

    private final LibraryService service;

    // ---------- BOOKS ----------
    @GetMapping("/books")
    public List<Books> getBooks() { return service.getAllBooks(); }

    @PostMapping("/books")
    public Books addBook(@RequestBody Books book) { return service.addBook(book); }

    // ---------- MEMBERS ----------
    @GetMapping("/members")
    public List<Members> getMembers() { return service.getAllMembers(); }

    @PostMapping("/members")
    public Members addMember(@RequestBody Members member) { return service.addMember(member); }

    // ---------- BORROW ----------
    @GetMapping("/borrowed")
    public List<Borrow> getBorrowed() { return service.getAllBorrowed(); }

    @PostMapping("/borrow/{memberId}/{bookId}")
    public Borrow borrow(@PathVariable int memberId, @PathVariable int bookId) {
        return service.borrowBook(memberId, bookId);
    }

    // ---------- RETURN ----------
    @GetMapping("/returned")
    public List<Return> getReturned() { return service.getAllReturned(); }

    @PostMapping("/return/{memberId}/{bookId}")
    public Return returnBook(@PathVariable int memberId, @PathVariable int bookId) {
        return service.returnBook(memberId, bookId);
    }
}
