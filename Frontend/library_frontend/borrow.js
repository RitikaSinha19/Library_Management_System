const apiUrl = "http://localhost:8080/library";

function loadMembersDropdown() {
    fetch(`${apiUrl}/members`).then(res => res.json()).then(data => {
        const select = document.getElementById("memberSelect");
        select.innerHTML = '<option value="">Select Member</option>';
        data.forEach(m => {
            const opt = document.createElement("option");
            opt.value = m.id; opt.textContent = m.name;
            select.appendChild(opt);
        });
    });
}

function loadBooksDropdown() {
    fetch(`${apiUrl}/books`).then(res => res.json()).then(data => {
        const select = document.getElementById("bookSelect");
        select.innerHTML = '<option value="">Select Book</option>';
        data.forEach(b => {
            if(b.quantity > 0){
                const opt = document.createElement("option");
                opt.value = b.id; opt.textContent = b.bookName;
                select.appendChild(opt);
            }
        });
    });
}

function loadBorrowed() {
    fetch(`${apiUrl}/borrowed`).then(res => res.json()).then(data => {
        const tbody = document.querySelector("#borrowTable tbody");
        tbody.innerHTML = "";
        data.forEach(b => {
            const tr = document.createElement("tr");
            tr.innerHTML = `<td>${b.borrowId}</td>
                            <td>${b.member.name}</td>
                            <td>${b.book.bookName}</td>
                            <td>${b.dateBorrowed}</td>`;
            tbody.appendChild(tr);
        });
    });
}

document.getElementById("borrowForm").addEventListener("submit", e => {
    e.preventDefault();
    const memberId = parseInt(document.getElementById("memberSelect").value);
    const bookId = parseInt(document.getElementById("bookSelect").value);
    fetch(`${apiUrl}/borrow/${memberId}/${bookId}`, {method:"POST"})
    .then(res => { loadBorrowed(); loadBooksDropdown(); });
});

loadMembersDropdown();
loadBooksDropdown();
loadBorrowed();
