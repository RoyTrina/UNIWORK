let student = [["Full Name"]["Dynamic Table"]["Intellij Usage"]["Calendar Control"]["Active form"]["Object Database"]];

function clear_form() {
    document.getElementById("student_name").value = "";

    document.getElementById("note1").value = "";
    document.getElementById("note2").value = "";
    document.getElementById("note3").value = "";
    document.getElementById("note4").value = "";
    document.getElementById("note5").value = "";


    $("#mark1").prop('selectedIndex', 0);
    $("#mark2").prop('selectedIndex', 0);
    $("#mark3").prop('selectedIndex', 0);
    $("#mark4").prop('selectedIndex', 0);
    $("#mark5").prop('selectedIndex', 0);

    location.reload();
}


function generate_student_data() {
    let page = window.open();

    let writing = page.document;
    writing.open();

    writing.write("<h2>Student data</h2>");
    writing.write("Student name: " + " " + document.getElementById("student_name").value);
    writing.write("<br>");

    writing.write("<h3>Student marks</h3>");
    writing.write("Dynamic Table: " + document.getElementById("mark1").value);
    writing.write("<br>");
    writing.write("Intellij Usage: " + document.getElementById("mark2").value);
    writing.write("<br>");
    writing.write("Calendar Control: " + document.getElementById("mark3").value);
    writing.write("<br>");
    writing.write("Active form: " + document.getElementById("mark4").value);
    writing.write("<br>");
    writing.write("Object Database: " + document.getElementById("mark5").value);

    writing.write("<h3>Comments</h3>");
    writing.write("Dynamic Table: " + document.getElementById("note1").value);
    writing.write("<br>");
    writing.write("Intellij Usage: " + document.getElementById("note2").value);
    writing.write("<br>");
    writing.write("Calendar Control: " + document.getElementById("note3").value);
    writing.write("<br>");
    writing.write("Active form: " + document.getElementById("note4").value);
    writing.write("<br>");
    writing.write("Object Database: " + document.getElementById("note5").value);

    writing.write("This is what is stored in the array: " + manageStudentData());

    writing.close();
}

function manageStudentData() {
    student[[0]] = document.getElementById("student_name").value;
    student[[1]] = document.getElementById("mark1").value;
    student[[2]] = document.getElementById("mark2").value;
    student[[3]] = document.getElementById("mark3").value;
    student[[4]] = document.getElementById("mark4").value;
    student[[5]] = document.getElementById("mark5").value;

    return student;

}

function generate_Options(id) {
    const id_array = ["mark1", "mark2", "mark3", "mark4", "mark5"];
    const max_mark_array = [];
    const select = document.getElementsByName("select");

    for (let i = 0; i <= id_array.length; i++) {
        max_mark_array.push(document.getElementById("student_data").rows[i].cells.item(1));
    }

    if (document.getElementById("mark1").id === id_array[0]) {
        for (let w = 0; w <= max_mark_array[0]; w++) {
            select.options[select.options.length] = new Option("w", "w");
        }
    } else if (document.getElementById("mark2").id === id_array[1]) {
        for (let w = 0; w <= max_mark_array[0]; w++) {
            select.options[select.options.length] = new Option("w", "w");
        }
    } else if (document.getElementById("mark3").id === id_array[2]) {
        for (let w = 0; w <= max_mark_array[0]; w++) {
            select.options[select.options.length] = new Option("w", "w");
        }
    } else if (document.getElementById("mark4").id === id_array[3]) {
        for (let w = 0; w <= max_mark_array[0]; w++) {
            select.options[select.options.length] = new Option("w", "w");
        }
    } else if (document.getElementById("mark5").id === id_array[4]) {
        for (let w = 0; w <= max_mark_array[0]; w++) {
            select.options[select.options.length] = new Option("w", "w");
        }
    }
}


function marks() {
    const answer = Number(document.getElementById("mark1").value)
        + Number(document.getElementById("mark2").value)
        + Number(document.getElementById("mark3").value)
        + Number(document.getElementById("mark4").value)
        + Number(document.getElementById("mark5").value);

    document.getElementById("answer").innerHTML = "The total marks are: " + answer;

}
