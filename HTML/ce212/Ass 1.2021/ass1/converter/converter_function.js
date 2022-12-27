let lead, last;

function input_checker() {
    const symbols = new RegExp("[!+£$%&*()]");
    const letters = new RegExp("[A-z]");

    lead = document.getElementById("number1").value;
    last = document.getElementById("number2").value;

    try {
        if (lead !== Number.isInteger(lead) && last !== Number.isInteger(last)) {
        } else if (lead.includes(letters) || lead.includes(symbols)) {
            alert("The input entered is not a number. Please try again.");
        } else if ((lead - last) <= 25 || (last - lead) <= 25) {
            alert("The input is too big. Please enter again.");
        }
    } catch (e) {
        console.log("Errors");

    } finally {
        if ($('selectedIndex', 1)) {
            tableGeneratorCtoF('temperature_Table', range(Math.trunc(lead)), range(Math.trunc(last)));
        } else {
            tableGeneratorFtoC('temperature_Table', range(Math.trunc(lead)), range(Math.trunc(last)))
        }
    }
}


function range(number, number2) {
    const array = [100];

    for (let i = number; i <= number2; i++) {
        array.push(i);
    }
    return array;
}


function delete_data() {
    document.getElementById("number1").value = "";
    document.getElementById("number2").value = "";

    $("#temperature_Table").empty();
}


function tableGeneratorCtoF(id, start_off, end) {
    const table_id = document.getElementById("screen1");
    const table = document.getElementById("temperature_Table");

    let table_row = document.createElement("tr");

    const table_header1 = document.createElement("th");
    const table_header2 = document.createElement("th");

    table_header1.setAttribute("th", "Celsius");
    table_header2.setAttribute("th", "Fahrenheit");

    table_id.appendChild(table.appendChild(table_row.appendChild(table_header1)));
    table_id.appendChild(table.appendChild(table_row.appendChild(table_header2)));

    for (let number = start_off; number <= end; number++) {
        table_row = document.createElement("tr");
        table.appendChild(table_row);

        let table_cell = document.createElement("td");
        table_row.appendChild(table_cell);

        table_cell.appendChild(document.createTextNode(number));

        table_cell = document.createElement("td");
        table_row.appendChild(table_cell);

        table_cell.appendChild(document.createTextNode(celsius_To_fahrenheit(start_off, end).toString()));

        if (number % 2 === 0) {
            table_row.setAttribute("class", "even");
        } else {
            table_row.setAttribute("class", "odd");
        }
    }

}

function tableGeneratorFtoC(id, start_off, end) {
    const table_id = document.getElementById("screen1");

    const table = document.getElementById("temperature_Table");

    let table_row = document.createElement("tr");

    const table_header1 = document.createElement("th");
    const table_header2 = document.createElement("th");

    table_header1.setAttribute("th", "Fahrenheit");
    table_header2.setAttribute("th", "Celsius");

    table_id.appendChild(table.appendChild(table_row.appendChild(table_header1)));
    table_id.appendChild(table.appendChild(table_row.appendChild(table_header2)));


    for (let number = start_off; number <= end; number++) {
        table_row = document.createElement("tr");
        table.appendChild(table_row);

        let table_cell = document.createElement("td");
        table_row.appendChild(table_cell);

        table_cell.appendChild(document.createTextNode(number));

        table_cell = document.createElement("td");
        table_row.appendChild(table_cell);

        table_cell.appendChild(document.createTextNode(fahrenheit_To_celsius(start_off, end).toString()));

        if (number % 2 === 1) {
            table_row.setAttribute("class", "odd");
        } else {
            table_row.setAttribute("class", "even");
        }
    }
}

function celsius_To_fahrenheit(number) {
    return number * 9 / 5 + 32;
}


function fahrenheit_To_celsius(number) {
    return number - 32 * 5 / 9;
}


function sortTable() {
    const table = document.getElementById("temperature_Table");
    const numberOfRows = document.getElementById("temperature_Table").rows.length;
    let shouldChange;
    let changing;

    for (let i = 1; i < (numberOfRows - 1); i++) {
        shouldChange = false;
        let row_A = table.rows[i].getElementsByTagName("TD")[0];
        let row_B = table.rows[i + 1].getElementsByTagName("TD")[0];

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