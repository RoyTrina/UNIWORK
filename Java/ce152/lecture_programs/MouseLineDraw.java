package lectures_programs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class MouseLineDraw extends JComponent {
    List<int[]> points;

    public static void main(String[] a) throws InterruptedException {
        JFrame f = new JFrame("Mouse Line Draw");
        f.getContentPane().setPreferredSize(new Dimension(400, 400));
        MouseLineDraw mouseDraw = new MouseLineDraw();
        f.add(mouseDraw);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }

    private class MouseDrawListener extends MouseAdapter {

        public void mouseClicked(MouseEvent ev) {
            if (ev.getButton() == MouseEvent.BUTTON1) {
                points.add(0, new int[]{ev.getX(), ev.getY()});
            } else if (!points.isEmpty())
                points.remove(0);
            ((Component) ev.getSource()).repaint();
        }
    }

    public MouseLineDraw() {
        points = new ArrayList<>();
        addMouseListener(new MouseDrawListener());
    }

    public void paintComponent(Graphics g) {
        for (int i = 0; i < points.size() - 1; i++) {
            int[] p = points.get(i);
            int[] q = points.get(i + 1);
            g.drawLine(p[0], p[1], q[0], q[1]);
        }
    }

}
