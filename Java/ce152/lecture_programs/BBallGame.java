package lectures_programs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import static lectures_programs.Ball.BOX_HEIGHT;
import static lectures_programs.Ball.BOX_WIDTH;

public class BBallGame extends JFrame {
    public static final int BOX_MARGIN = 100;
    public static final Color BOX_COLOR = Color.BLACK;
    // max ball radius, see initBallArray
    public static final int BALL_RADIUS = 20;
    public static final int PADDLE_SPEED = 5;
    public static final int PADDLE_WIDTH = 20;
    public static final int PADDLE_HEIGHT = 2;
    public static final int[] BOX_X = {BOX_MARGIN, BOX_MARGIN, BOX_MARGIN + BOX_WIDTH, BOX_MARGIN + BOX_WIDTH};
    public static final int[] BOX_Y = {BOX_MARGIN + BOX_HEIGHT, BOX_MARGIN, BOX_MARGIN, BOX_MARGIN + BOX_HEIGHT};
    public final Ball[] ballArray = new Ball[10];

    public BallPanel panel;
    public int paddleX = BOX_MARGIN + BOX_WIDTH / 2;
    public int paddleY = BOX_MARGIN + BOX_HEIGHT;

    public static void main(String[] a) {
        new BBallGame();
    }

    public BBallGame() {
        setTitle("Bouncing Balls using Swing Timer");
        setSize(BOX_WIDTH + 2 * BOX_MARGIN, BOX_HEIGHT + 3 * BOX_MARGIN);
        setResizable(false);
        initBallArray();
        panel = new BallPanel();
        add(panel);
        Timer timer = new Timer(15, new TimerListener());
        timer.start();
        setVisible(true);
    }

    public void initBallArray() {
        Random r = new java.util.Random();
        for (int i = 0; i < ballArray.length; i++) {
            Color c = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
            int size = (int) (BALL_RADIUS * (1 + r.nextDouble()));
            ballArray[i] = new Ball(size, c);
        }
    }

    public boolean overlapsPaddle(Ball b) {
        // check if centre of ball is inside a paddle-rectangle
        // enlarged by b.getRadius() on all sides
        return b.getX() > paddleX - b.getRadius() && b.getX() < paddleX + PADDLE_WIDTH + b.getRadius()
                && b.getY() > paddleY - b.getRadius() && b.getY() < paddleY + b.getRadius() + PADDLE_HEIGHT;
    }

    class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev) {
            for (Ball b : ballArray) {
                b.move();
                repaint();
            }
        }
    }

    /*
     * class BBall extends Ball{
     *
     * public BBall(int size, Color color) { super(size,color); } }
     *
     * @Override public void move() { x += vx; y += vy; if (x < radius || x +
     * radius > BOX_WIDTH) vx *= -1; if (y < radius || y + radius > BOX_HEIGHT)
     * vy *= -1; } }
     */

    class BallPanel extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            g.setColor(BOX_COLOR);
            g.drawPolyline(BOX_X, BOX_Y, 4);
            for (Ball b : ballArray) {
                g.setColor(b.getColor());
                int r = b.getRadius();
                g.fillOval(BOX_MARGIN + (int) b.getX() - r, BOX_MARGIN + (int) b.getY() - r, 2 * r, 2 * r);
            }
        }
    }
}
