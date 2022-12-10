package lectures_programs;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

import static lectures_programs.Ball.BOX_HEIGHT;
import static lectures_programs.Ball.BOX_WIDTH;

public class BouncingBallJPanel extends JPanel {
    public static final int BALL_RADIUS = 20;
    public static final Color BOX_COLOR = Color.BLACK;
    public static final int BOX_MARGIN = 50;
    public final Ball[] ballArray = new Ball[10];

    public BouncingBallJPanel() {
        Random r = new Random();
        for (int i = 0; i < ballArray.length; i++) {
            Color c = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
            int size = (int) ((1 + r.nextDouble()) * BALL_RADIUS);
            ballArray[i] = new Ball(size, c);
        }
    }

    @Override
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
