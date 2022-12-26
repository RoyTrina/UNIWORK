package assignment2;

import javax.swing.*;
import java.awt.*;


public class Sudoku extends JFrame {
    private final int GRID_SIZE = 9;
    private final int EMPTY = 0;
    JPanel grid_panel; //panel for displaying grid panels
    JPanel[][] grid_array;
    //array used to store panels in grid
    JTextArea grid_box;
    private final int[][] solution = new int[GRID_SIZE][GRID_SIZE];

    public void initialise() {
        if (grid_panel != null) {
            this.remove(grid_panel);
            grid_panel = null;
        }
        grid_panel = new JPanel(new GridLayout(9, 9));
        grid_array = new JPanel[9][9];
        grid_box = new JTextArea();

        for (int x = 0; x < grid_array.length; x++) {
            for (int y = 0; y < grid_array[x].length; y++) {
                grid_array[x][y] = new JPanel();
                grid_box = new JTextArea();
            }
        }
    }

    public boolean inputValidation(int[][] board) {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int l = 0; l < GRID_SIZE; l++) {
                if (board[i][l] < EMPTY || board[i][l] > GRID_SIZE) {
                    return false;
                }
                for (int k = 0; k < GRID_SIZE; k++) {
                    //more than one appearance in one row
                    if (k != l && board[i][k] == board[i][l] && board[i][l] != EMPTY) {
                        return false;

                    }
                    if (k != i && board[k][l] == board[i][l] && board[i][l] != EMPTY) {
                        return false;
                    }
                }
            }
        }
        return false;
    }
}