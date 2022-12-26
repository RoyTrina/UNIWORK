package assignment2;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseClickListener implements MouseListener {

    private final Sudoku game; // game passed through to allow for game manipulation


    public MouseClickListener(Sudoku game) {
        this.game = game;
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        e.getComponent().setBackground(Color.RED);
    }

    @Override
    public void mousePressed(MouseEvent e) {


    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }


    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


    public Sudoku getGame() {
        return game;
    }

}
