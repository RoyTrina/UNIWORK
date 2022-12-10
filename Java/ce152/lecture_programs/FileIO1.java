package lectures_programs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

// File I/O Example with no exception handling 

public class FileIO1 {

    public static void main(String[] args) throws FileNotFoundException {
        String fileName = "data/numbers.txt";
        writeRandomDoubles(fileName, 100);
        double[] numbers = readNumbers(fileName, 100);
        for (Double d : numbers)
            System.out.println(d);
    }

    public static void writeRandomDoubles(String fileName, int n) throws FileNotFoundException {
        PrintWriter output = new PrintWriter(fileName);
        for (int i = 0; i < n; i++)
            output.println(Math.random());
        output.close();
    }

    public static double[] readNumbers(String fileName, int n) throws FileNotFoundException {
        Scanner input = new Scanner(new File(fileName));
        double[] tmp = new double[n];
        int i = 0;
        while (input.hasNextDouble() && i < n)
            tmp[i++] = input.nextDouble();
        input.close();
        return Arrays.copyOf(tmp, i);
    }

}
