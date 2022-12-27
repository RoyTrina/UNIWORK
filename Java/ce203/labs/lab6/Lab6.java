package labs.lab6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Lab6 {
    static final HashMap<String, Integer> marks = new HashMap<>();

    public static void main(String[] args) {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        boolean more = true;
        while (more) {
            System.out.print("Name: ");
            String name = null;
            try {
                name = buf.readLine();
            } catch (Exception e) {
                e.getStackTrace();
            }
            System.out.print("Mark: ");
            int mark = 0;
            try {
                mark = Integer.parseInt(buf.readLine().trim());
            } catch (Exception e) {
                System.out.println("invalid input - using 0");
            }
            marks.put(name, mark);
            System.out.print("More? ");
            try {
                if (buf.readLine().charAt(0) != 'y')
                    more = false;
            } catch (Exception e) {
                e.getStackTrace();
            }
        }
        System.out.println(marks);
    }
}


