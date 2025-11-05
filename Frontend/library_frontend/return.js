const apiUrl = "http://localhost:8080/library";

function loadBorrowedDropdown() {
    fetch(`${apiUrl}/borrowed`).then(res=>res.json()).then(data=>{
        const select=document.getElementById("borrowSelect");
        select.innerHTML='<option value="">Select Borrow Record</option>';
        data.forEach(b=>{
            const opt=document.createElement("option");
            opt.value=JSON.stringify({memberId:b.member.id, bookId:b.book.id});
            opt.textContent=`Member: ${b.member.name} | Book: ${b.book.bookName}`;
            select.appendChild(opt);
        });
    });
}

function loadReturned() {
    fetch(`${apiUrl}/returned`).then(res=>res.json()).then(data=>{
        const tbody=document.querySelector("#returnTable tbody");
        tbody.innerHTML="";
        data.forEach(r=>{
            const tr=document.createElement("tr");
            tr.innerHTML=`<td>${r.returnId}</td>
                          <td>${r.member.name}</td>
                          <td>${r.book.bookName}</td>
                          <td>${r.dateReturned}</td>`;
            tbody.appendChild(tr);
        });
    });
}

document.getElementById("returnForm").addEventListener("submit",e=>{
    e.preventDefault();
    const selected=JSON.parse(document.getElementById("borrowSelect").value);
    fetch(`${apiUrl}/return/${selected.memberId}/${selected.bookId}`,{method:"POST"})
    .then(res=>{ loadReturned(); loadBorrowedDropdown(); });
});

loadBorrowedDropdown();
loadReturned();
