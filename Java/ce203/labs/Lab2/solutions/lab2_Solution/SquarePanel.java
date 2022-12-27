package labs.Lab2.solutions.lab2_Solution;

import javax.swing.*;
import java.awt.*;

class SquarePanel extends JPanel {
    final FilledFrame theApp;


    SquarePanel(FilledFrame app) {
        theApp = app;
    }

    public SquarePanel(JPanel jPanel) {
        theApp = null;
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.green);
        g.fillRect(20, 20, theApp.size, theApp.size);
    }

    public static void main(String[] args){
        SquarePanel newPanle = new SquarePanel(new FilledFrame());
    }
}