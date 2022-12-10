package lectures_programs;

import javax.swing.*;
import java.awt.*;

public class Drawing1 extends JComponent {

    public static void main(String[] a) {
        JFrame f = new JFrame("Drawing 1");
        f.setSize(600, 600);
        f.add(new Drawing1());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public void paintComponent(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;
        g.setColor(Color.green);
        g.fillRect(100, 100, 200, 100);
    }

    public static int rnd(int n) {
        return (int) (Math.random() * n);
    }

}
