package lectures_programs;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Scanner;

// Derived from http://introcs.cs.princeton.edu/java/lectures 
public class PlotCoords extends JComponent {
    static int[][] coords;

    public static void main(String[] a) throws Exception {
        readCoords();
        JFrame f = new JFrame("Plotting coordinates");
        f.getContentPane().setPreferredSize(new Dimension(Plot.width + 20, Plot.height + 40));
        f.add(new PlotCoords());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }

    public static void readCoords() throws Exception {
        Scanner input = new Scanner(new File("data/usa.txt"));
        int n = input.nextInt();
        coords = new int[n][2];
        // set up plot transformation
        double xmin = input.nextDouble();
        double ymin = input.nextDouble();
        double xmax = input.nextDouble();
        double ymax = input.nextDouble();
        Plot.height = (int) (Plot.width * (ymax - ymin) / (xmax - xmin));
        Plot.setScaleX(xmin, xmax);
        Plot.setScaleY(ymin, ymax);
        // fill coordinate array
        for (int i = 0; i < n; i++) {
            coords[i][0] = Plot.scaleX(input.nextDouble());
            coords[i][1] = Plot.scaleY(input.nextDouble());
        }
        input.close();
    }

    public void paintComponent(Graphics g) {
        for (int i = 0; i < coords.length; i++)
            g.fillOval(coords[i][0], coords[i][1], 3, 3);
    }
}
