let letters = ""
let symbols = ""

if (lead.value === 0 && last.value === 0 && $('selectedIndex', 0)) {
    alert("There is no input. Please enter a number.")
} else {
    if (!Number.isInteger(lead.value) && !Number.isInteger(last.value)) {
        if (lead.value.includes(letters) || lead.value.includes(symbols)) {
            alert("The input entered is not a number. Please try again.");
        } else {
            if ((lead.value - last.value) < 25 || (last.value - lead.value) < 25) {
                alert("The difference is too big to show on the screen. Please enter a smaller range.");
            } else {
                if ($('selectedIndex', 1)) {
                    tableGeneratorCtoF(Math.trunc(lead.value), Math.trunc(last.value));
                } else {
                    $('selectedIndex', 2);
                    tableGeneratorFtoC(Math.trunc(lead.value), Math.trunc(last.value));
                }
            }

        }
    }
}