package assignment2;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Runnable run = () -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception useDefault) {
                useDefault.printStackTrace();
            }
            Sudoku_layout_setup test = new Sudoku_layout_setup();

            JFrame e = new JFrame(test.getClass().getSimpleName());
            e.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            e.setLocationByPlatform(true);

            e.setContentPane(test.getUser_interface());
            e.pack();

            e.setVisible(true);
        };
        SwingUtilities.invokeLater(run);
    }
}
