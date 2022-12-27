package assignment2;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;


public class Sudoku_layout_setup {
    private JComponent user_interface = null;
    public JPanel grid_panel;

    Sudoku_layout_setup(){
        inituser_interface();
    }

    public JComponent getUser_interface(){
        return user_interface;
    }

    public void inituser_interface(){
        if (getUser_interface() != null && user_interface != null) return;

        user_interface = new JPanel(new BorderLayout(6,6));
        user_interface.setBorder(new TitledBorder(""));

        CardLayout card = new CardLayout();
        JPanel cards = new JPanel(card);
        cards.setBorder(new TitledBorder("Sudoku placeholder"));
        user_interface.add(cards);

        JPanel lineStart = new JPanel(new GridBagLayout());
        lineStart.setBorder(new TitledBorder("Buttons_outside"));
        //this will make sure that the buttons are going to appear on the left
        user_interface.add(lineStart, BorderLayout.LINE_START);

        JPanel buttons = new JPanel(new GridLayout(0, 1, 20,20));
        buttons.setBorder(new TitledBorder("Buttons_inside"));
        lineStart.add(buttons);
        JButton start_game = new JButton("Start game");
        JButton pause = new JButton("Pause game");
        JButton reset = new JButton("Reset");
        buttons.add(start_game);
        buttons.add(pause);
        buttons.add(reset);


        start_game.addActionListener(e -> new Sudoku());

        pause.addActionListener(e -> {

        });

        reset.addActionListener( e -> {

        });

    }
}