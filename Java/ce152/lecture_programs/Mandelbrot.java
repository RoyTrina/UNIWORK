package lectures_programs;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Scanner;

public class Mandelbrot extends JComponent {

    public final static int N = 800;
    public static BufferedImage im = new BufferedImage(N, N, BufferedImage.TYPE_INT_RGB);
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Please enter cx, cy and size:");
        System.out.println("Try -0.5 0 2 or -0.745 0.095 0.01 for example");
        double cx = input.nextDouble();
        double cy = input.nextDouble();
        double size = input.nextDouble();
        mandelbrot(im, cx, cy, size);
        JFrame f = new JFrame(String.format("Mandelbrot c=(%.3f,%.3f) size=%.3f", cx, cy, size));
        f.getContentPane().setPreferredSize(new Dimension(N, N));
        f.add(new Mandelbrot());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
        f.repaint();
        input.close();
    }

    public void paintComponent(Graphics g) {
        g.drawImage(im, 0, 0, null);
    }

    public static Color mand(Complex z0) {
        Complex z = z0;
        for (int t = 0; t < 255; t++) {
            if (z.abs() > 2.0)
                // return Color.white;
                // for a more dramatic image, replaced by:
                return new Color(t, 255 - t, t);
            z = z.mult(z);
            z = z.add(z0);
        }
        return Color.BLACK;
    }

    public static void mandelbrot(BufferedImage im, double cx, double cy, double size) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                double x0 = cx - size / 2 + size * i / N;
                double y0 = cy - size / 2 + size * j / N;
                Complex z0 = new Complex(x0, y0);
                Color color = mand(z0);
                im.setRGB(i, N - 1 - j, color.getRGB());
            }
        }
    }
}
