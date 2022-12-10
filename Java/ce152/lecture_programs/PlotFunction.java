package lectures_programs;

import javax.swing.*;
import java.awt.*;

// Derived from http://introcs.cs.princeton.edu/java/lectures 
public class PlotFunction extends JComponent {

    public static void main(String[] args) {
        Plot.setScaleX(0.0, Math.PI);
        Plot.setScaleY(-2.0, 2.0);
        JFrame f = new JFrame("Plot function: Math.sin(4*x) + Math.sin(20*x)");
        f.getContentPane().setPreferredSize(new Dimension(Plot.width, Plot.height));
        f.add(new PlotFunction());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }

    public void paintComponent(Graphics g) {
        int N = 1000;
        int[] x = new int[N + 1];
        int[] y = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            double xi = Math.PI * i / N;
            x[i] = Plot.scaleX(xi);
            y[i] = Plot.scaleY(Math.sin(4 * xi) + Math.sin(20 * xi));
        }
        g.drawPolyline(x, y, N);
    }
}
