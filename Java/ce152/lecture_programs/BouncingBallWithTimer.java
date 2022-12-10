package lectures_programs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static lectures_programs.Ball.BOX_HEIGHT;
import static lectures_programs.Ball.BOX_WIDTH;

public class BouncingBallWithTimer extends JFrame {
    public static final int BOX_MARGIN = 50;
    public BouncingBallJPanel panel;

    public static void main(String[] a) {
        new BouncingBallWithTimer();
    }

    public BouncingBallWithTimer() {
        setTitle("Bouncing Balls using Swing Timer");
        getContentPane().setPreferredSize(new Dimension(BOX_WIDTH + 2 * BOX_MARGIN, BOX_HEIGHT + 2 * BOX_MARGIN));
        setResizable(false);
        panel = new BouncingBallJPanel();
        add(panel);
        Timer timer = new Timer(15, new TimerListener());
        timer.start();
        setVisible(true);
    }

    class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev) {
            for (Ball b : panel.ballArray)
                b.move();
            repaint();
        }
    }
}