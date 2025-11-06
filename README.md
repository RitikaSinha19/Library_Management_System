The Library Management System is a full-stack web application designed to manage library operations efficiently. It allows administrators to manage books, members, borrowing, and returning of books. The system automatically updates the inventory and maintains records for borrowing and returns.

This project demonstrates Spring Boot for the backend and HTML/CSS/JavaScript for the frontend with a MySQL database.
Features

Book Management: Add, view, and delete books. Automatically decreases quantity when a book is borrowed and increases when returned.
Member Management: Add and view members with membership start and end dates.

Borrow & Return: Track which member borrowed which book and when. Return books to update the inventory and remove from borrowed list.

Automatic Updates: Removes books with 0 quantity and handles borrow-return synchronization.

User-Friendly UI: Pastel-themed interactive frontend with easy navigation between pages (Home, Books, Members, Borrow, Return).
Technology Stack
Backend: Java, Spring Boot, Spring Data JPA
Frontend: HTML, CSS, JavaScript
Database: MySQL
Build Tools: Maven
Version Control: Git/GitHub
