const apiUrl = "http://localhost:8080/library";

function loadMembers() {
    fetch(`${apiUrl}/members`)
    .then(res => res.json())
    .then(data => {
        const tbody = document.querySelector("#membersTable tbody");
        tbody.innerHTML = "";
        data.forEach(member => {
            const tr = document.createElement("tr");
            tr.innerHTML = `<td>${member.id}</td>
                            <td>${member.name}</td>
                            <td>${member.email}</td>
                            <td>${member.phone}</td>
                            <td>${member.dateOfMembership}</td>
                            <td>${member.endOfMembership}</td>`;
            tbody.appendChild(tr);
        });
    });
}

document.getElementById("addMemberForm").addEventListener("submit", e => {
    e.preventDefault();
    const member = {
        name: document.getElementById("name").value,
        email: document.getElementById("email").value,
        phone: document.getElementById("phone").value,
        dateOfMembership: document.getElementById("dateMembership").value,
        endOfMembership: document.getElementById("endMembership").value
    };
    fetch(`${apiUrl}/members`, {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify(member)
    }).then(res => {
        loadMembers();
        document.getElementById("addMemberForm").reset();
    });
});

loadMembers();
