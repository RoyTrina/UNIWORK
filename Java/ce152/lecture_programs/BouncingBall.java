package lectures_programs;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

import static lectures_programs.Ball.BOX_HEIGHT;
import static lectures_programs.Ball.BOX_WIDTH;

public class BouncingBall extends JComponent {
    public static final int REPAINT_INTERVAL = 10;
    public static final int BALL_RADIUS = 20;
    public static final Color BOX_COLOR = Color.BLACK;
    public static final int BOX_MARGIN = 50;
    public final Ball[] ballArray = new Ball[10];

    public static void main(String[] a) throws InterruptedException {
        BouncingBall animation = new BouncingBall();
        JFrame f = new JFrame("Bouncing Ball Animation");
        f.getContentPane().setPreferredSize(
                new Dimension(BOX_WIDTH + 2 * BOX_MARGIN, BOX_HEIGHT + 2 * BOX_MARGIN));
        f.add(animation);
        f.setResizable(false);
        f.pack();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        while (true) {
            Thread.sleep(REPAINT_INTERVAL);
            for (Ball b : animation.ballArray) {
                b.move();
            }
            f.repaint();
        }
    }

    public BouncingBall() {
        Random r = new Random();
        for (int i = 0; i < ballArray.length; i++) {
            Color c = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
            int size = (int) ((1 + r.nextDouble()) * BALL_RADIUS);
            ballArray[i] = new Ball(size, c);
        }
    }

    public void paintComponent(Graphics g) {
        g.setColor(BOX_COLOR);
        g.drawRect(BOX_MARGIN, BOX_MARGIN, BOX_WIDTH, BOX_HEIGHT);
        for (Ball b : ballArray) {
            g.setColor(b.getColor());
            int r = b.getRadius();
            g.fillOval(BOX_MARGIN + (int) b.getX() - r, BOX_MARGIN + (int) b.getY() - r, 2 * r, 2 * r);
        }
    }
}
