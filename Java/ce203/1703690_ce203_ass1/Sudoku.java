package assignment2;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

import static assignment2.Timer.setTimer;

public class Sudoku extends JFrame {
    JPanel grid_panel;          //panel for displaying grid panels
    JPanel[][] grid_array;      //array used to store panels in grid
    JTextField grid_box;         //textarea for the input

    void initialise(){
        if (grid_panel != null){
            this.remove(grid_panel);
            grid_panel = null;
        }
        grid_panel = new JPanel(new GridLayout(10,10));
        grid_array = new JPanel[10][10];
        grid_box = new JTextField();

        try{
            for (int x = 0; x < grid_array.length; x++) {
                int y;
                for (y = 0; y < grid_array[x].length; y++) {
                    grid_array[x][y] = new JPanel();
                    grid_box = new JTextField();
                }
                grid_array[x][y].addMouseListener((MouseListener) this);
                grid_panel.add(grid_array[x][y]);
                grid_panel.add(grid_box);
            }
            this.add(grid_panel);
        }
        catch(ArrayIndexOutOfBoundsException e){
            e.getStackTrace();
            System.out.println();
        }
    }
    public Sudoku(){
        new Sudoku_layout_setup();
        initialise();
        setTimer();


        addKeyListener(new KeyboardListener(this));


        setSize(new Dimension(400, 400));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args){
        Runnable run = () -> {
            try{
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            }
            catch (Exception useDefault){
                System.out.println();
            }
            Sudoku_layout_setup user_interface = new Sudoku_layout_setup();
            JFrame setup = new JFrame(user_interface.getClass().getSimpleName());
            setup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setup.setLocationByPlatform(true);

            setup.setContentPane(user_interface.getUser_interface());
            setup.pack();
            setup.setSize(300,300);

            setup.setVisible(true);
        };
    }
}