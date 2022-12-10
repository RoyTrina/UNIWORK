package lectures_programs;

import javax.swing.*;
import java.awt.*;

public class Drawing2 extends JComponent {

    public static final int SIZE = 600;

    public static void main(String[] a) {
        JFrame f = new JFrame("Drawing 2");
        f.setSize(SIZE, SIZE);
        f.add(new Drawing2());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public void paintComponent(Graphics g) {
        circles((Graphics2D) g);
    }

    public static int rnd(int n) {
        return (int) (Math.random() * n);
    }

    public void circles(Graphics2D g) {
        for (int i = 0; i < 60; i++) {
            g.setColor(new Color(rnd(256), rnd(256), rnd(256)));
            int r = 5 + rnd(60);
            g.fillOval(rnd(SIZE), rnd(SIZE), r, r);
        }

    }
}

