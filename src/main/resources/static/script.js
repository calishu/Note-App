document.addEventListener('DOMContentLoaded', function() {
    const form = document.getElementById("inputForm");
    form.addEventListener("submit", (event) => {
        const datetimeInput = document.getElementById("datetime");
        const datetimeValue = datetimeInput.value;
        const timestamp = new Date(datetimeValue).getTime() / 1000;

        const timestampInput = document.createElement("input");
        timestampInput.type = "hidden";
        timestampInput.name = "timestamp";
        timestampInput.value = timestamp;

        form.appendChild(timestampInput);
        datetimeInput.remove();
    })
});

function editEntry(id, datetime, text) {
    document.getElementById("datetime").value = datetime;
    document.getElementById("inputText").value = text;
    document.getElementById("button").textContent = "Save change";

    let hiddenIdInput = document.getElementById("entryId");
    if (!hiddenIdInput) {
        hiddenIdInput = document.createElement("input");
        hiddenIdInput.type = "hidden";
        hiddenIdInput.id = "entryId";
        hiddenIdInput.name = "entryId";
        
        document.getElementById("inputForm").appendChild(hiddenIdInput);
    }
    hiddenIdInput.value = id;
}

function deleteEntry(id) {
    if (confirm("Do you really want to delete the entry?"))
        fetch(`/delete/${id}`, {
            method: "DELETE"
        }).then(response => {
            if (response.ok) {
                location.reload();
            } else {
                alert("Error while deleting entry");
            }
        })
}

function redirectCSV() {
    window.location.href = "/export";
}