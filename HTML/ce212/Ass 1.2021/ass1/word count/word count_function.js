let counter;
let HTMLFile;

const wordSeries = new RegExp("[A-z]");
const word = "hello";

function get_or_MakeDocument() {
    HTMLFile = require("");
}


function make_Table(id) {
    const table_id = document.getElementById("word_Table");
    const table = document.createElement("table");

    let table_row = document.createElement("tr");

    const table_head1 = document.createElement("th");
    const table_head2 = document.createElement("th");

    table_head1.setAttribute("th", "Word");
    table_head2.setAttribute("th", "Frequency");

    table_id.appendChild(table.appendChild(table_row.appendChild(table_head1)));
    table_id.appendChild(table.appendChild(table_row.appendChild(table_head2)));

    for (let number = 0; number <= table.length; number++) {
        table_row = document.createElement("tr");
        table.appendChild(table_row);

        table_cell.appendChild(document.createTextNode(word));

        let table_cell = document.createElement("td");
        table_row.appendChild(table_cell);

        table_cell = document.createElement("td");
        table_row.appendChild(table_cell);

        table_cell.appendChild(document.createTextNode("world"))

        if (number % 2 === 1) {
            table_row.setAttribute("class", "odd");
        } else {
            table_row.setAttribute("class", "even");
        }
    }
}


function clear() {
    document.getElementById("file").value = "";

    $("#word_Table").empty();

}


function countWords() {
    let counter = 0;
}


function getText() {
    pre = document.getElementById("count");
    counter = 0;
    retrieve(w.document.body);
    pre.textContent = "Found " + counter + " text nodes";
}

function retrieve(node) {
    if (node.nodeType === Node.ELEMENT_NODE) {
        for (let l = node.firstChild; l != null; l = l.nextSibling) {
            retrieve(l);
        }
    } else if (node.nodeType === Node.TEXT_NODE) {
        var p = document.createElement("p");
    }
}


function sort_Table_Alphabetically() {
    const table = document.getElementById("word_Table");
    const numberOfRows = document.getElementById("word_Table").rows.length;
    let shouldChange;
    let changing;

    for (let i = 1; i < (numberOfRows - 1); i++) {
        shouldChange = false;
        var row_A = table.rows[i].getElementsByTagName("TD")[0];
        var row_B = table.rows[i + 1].getElementsByTagName("TD")[0];

        if (row_A.innerHTML.toString() > row_B.innerHTML.toString()) {
            shouldChange = true;
            break;
        }

        if (shouldChange) {
            numberOfRows[i].parentNode.insertBefore(numberOfRows[i + 1], numberOfRows[i]);
            changing = true;
        }
    }
}

function sort_Table_frequency() {
    const table = document.getElementById("word_Table");
    const numberOfRows = document.getElementById("word_Table").rows.length;
    let shouldChange;
    let changing;

    changing = true;

    for (let i = 1; i < (numberOfRows - 1); i++) {
        shouldChange = false;
        var row_A = table.rows[i].getElementsByTagName("TD")[0];
        var row_B = table.rows[i + 1].getElementsByTagName("TD")[0];

    }

}
