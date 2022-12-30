function conversionScreen(tagId, from, to) {
    const conv = document.getElementById(tagId);

    const pre = document.createElement("pre");

    conv.appendChild(pre);
    for (let i = from; i <= to; i++) {
        pre.appendChild(document.createTextNode(i + " : " + c2f(i)));
        pre.appendChild(document.createElement("br"));
    }
}

function c2f(c) {
    return c * 9 / 5 + 32;
}


function conversionTable(start, end) {
    const table = document.getElementById("table");

    var tr = document.createElement("tr");

    var td = document.createElement("td");

    table.appendChild(tr.appendChild(td));


    for (let i = start; i <= end; i++) {
        tr = document.createElement("tr");
        table.appendChild(tr);

        td = document.createElement("td");
        tr.appendChild(td);
        td.appendChild(document.createTextNode(i))
        td = document.createElement("td");
        tr.appendChild(td);
        td.appendChild(document.createTextNode(c2f(i)))
        if (i % 2 === 1) {
            tr.setAttribute("class", "odd");
        } else {
            tr.setAttribute("class", "even");
        }
    }
}
