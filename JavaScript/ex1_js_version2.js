let start_r;
let end_r;

function conversion(tagID, start_r, end_r) {
    const convert = document.getElementById(tagID);
    const pre = document.createElement("pre");

    convert.appendChild(pre);

    const table = pre.appendChild(document.createElement("table"));
    const table_head = pre.appendChild(document.createElement("thead"));
    let table_row = table_head.appendChild(document.createElement("tr"));
    let table_h = table_row.appendChild(document.createElement("th"));
    table_h.appendChild(document.createTextNode("Celsius"));
    table_h = table_row.appendChild(document.createElement("th"));
    table_h.appendChild(document.createTextNode("Fahrenheit"));

    const table_body = table.appendChild(document.createElement("tbody"));

    //getting the values
    const start_value = $("start_r").data('',);
    start_r = start_value;


    //checking if the start value is empty or not, and then setting the value
    if (start_value == null || start_value === 0) {
        alert("There needs to be an input. Please enter a value. ")
    } else {
        $('start_r').data('', start_r);
    }

    const end_value = $('end_r').data('');
    end_r = end_value;

    if (end_value == null || end_value === 0) {
        end_r.append(0, 'end_r')

    }

    let i;
    for (i = start_r; i < end_r; i++) {
        table_row = table_body.appendChild(document.createElement("tr"));

        if (i % 2 === 0) {
            table_row.setAttribute("class", "even");
        } else {
            table_row.setAttribute("class", "odd");
        }
        let data = table_row.appendChild(document.createElement("td"));
        data.appendChild(document.createTextNode(i));
        data = table_row.appendChild(document.createElement("td"));
        data.appendChild(document.createTextNode(celsius_toFahrenheit(i)));

    }
}

function celsius_toFahrenheit(c) {
    return (c * 9 / 5 + 32)
}
