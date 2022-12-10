package ResitAss;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by tr17548 on 23/04/2018.
 */
public class Element {
    public static final String CSV_FILE_URL = "https://orb.essex.ac.uk/ce/ce152/data/assign/elements.csv";

    public static void main(String[] args) throws IOException {
        try {
            URL url = new URL(CSV_FILE_URL);
            Scanner input = new Scanner(url.openConnection().getInputStream());
            Scanner elements = new Scanner(new File("https://orb.essex.ac.uk/ce/ce152/data/assign/elements.csv"));
            elements.useDelimiter(", ");
            int n = 0;
            while (elements.hasNext()) {
                String s = elements.next();
                n = n + 1;
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

}
