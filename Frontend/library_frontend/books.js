const apiUrl = "http://localhost:8080/library";

function loadBooks() {
    fetch(`${apiUrl}/books`)
    .then(res => res.json())
    .then(data => {
        const tbody = document.querySelector("#booksTable tbody");
        tbody.innerHTML = "";
        data.forEach(book => {
            const tr = document.createElement("tr");
            tr.innerHTML = `<td>${book.id}</td>
                            <td>${book.bookName}</td>
                            <td>${book.authorName}</td>
                            <td>${book.genre}</td>
                            <td>${book.quantity}</td>`;
            tbody.appendChild(tr);
        });
    });
}

document.getElementById("addBookForm").addEventListener("submit", e => {
    e.preventDefault();
    const book = {
        bookName: document.getElementById("bookName").value,
        authorName: document.getElementById("authorName").value,
        genre: document.getElementById("genre").value,
        quantity: parseInt(document.getElementById("quantity").value)
    };
    fetch(`${apiUrl}/books`, {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify(book)
    }).then(res => {
        loadBooks();
        document.getElementById("addBookForm").reset();
    });
});

loadBooks();
