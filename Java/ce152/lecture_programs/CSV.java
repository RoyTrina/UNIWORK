package lectures_programs;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Scanner;

public class CSV {

    public static final String CSV_FILE_URL = "https://orb.essex.ac.uk/ce/ce152/data/staff.csv";
    public static final String DELIMITER = ",";

    public static void main(String[] args) throws IOException {
        URL url = new URL(CSV_FILE_URL);
        Scanner input = new Scanner(url.openConnection().getInputStream());
        readCSVFile(input);
        // testingFindPhoneNumber(input);
    }

    public static void readCSVFile(Scanner input) {
        while (input.hasNextLine()) {
            readRecord(input.nextLine());
        }
    }

    public static void readRecord(String line) {
        String[] fields = line.split(DELIMITER);
        // This is where you can process the record
        // In this example, we just print it to the console
        System.out.println(Arrays.toString(fields));
    }

}
