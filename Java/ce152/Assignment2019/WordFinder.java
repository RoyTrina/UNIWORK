package Assignment2019;
//Date of backup: 14/12/2019

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordFinder {
    public static final int N = 10;
    public static char[][] grid = new char[N][N];
    private static final String GRID_FILE = "C:/Users/Trina/Documents/2018-2019/CE152/ce152ass2019/grid.txt";
    private static final String WORD_FILE = "C:/Users/Trina/Documents/2018-2019/CE152/ce152ass2019/words.txt";

    private static void initGrid() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(GRID_FILE));
            List<String> lines = new ArrayList<>();
            char[][] grid = new char[N][N];

            String line;

            while ((line = reader.readLine()) != null) {
                lines.add(line);
                System.out.println("The grid is: " + "\n" + grid);
            }
            reader.close();
        } catch (IOException ni) {
            System.out.println(ni.getMessage());
        }
    }

    private static void printGrid() {
        System.out.println();
    }

    public static void find() {
        Scanner words = new Scanner(WORD_FILE);
    }

    public static void main(String[] args) throws FileNotFoundException {
        ///throw new FileNotFoundException("File cannot be found. PLease try again.");
        initGrid();
        //printGrid();
        //find();
    }
}

