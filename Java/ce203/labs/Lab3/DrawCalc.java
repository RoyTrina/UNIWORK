package labs.Lab3;

import labs.Lab1.shapes.Circle;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class DrawCalc extends JFrame {
    private JPanel panelOne;
    private JPanel panelTwo;

    final Square square;

    final Circle circle;

    JTextField textField;

    public DrawCalc() {
        setTitle("Drawing shapes");
        setSize(800, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        square = new Square(10, 10, 50) {
            @Override
            public Rectangle getBounds() {
                return null;
            }

            @Override
            public Rectangle2D getBounds2D() {
                return null;
            }

            @Override
            public boolean contains(double x, double y) {
                return false;
            }

            @Override
            public boolean contains(Point2D p) {
                return false;
            }

            @Override
            public boolean intersects(double x, double y, double w, double h) {
                return false;
            }

            @Override
            public boolean intersects(Rectangle2D r) {
                return false;
            }

            @Override
            public boolean contains(double x, double y, double w, double h) {
                return false;
            }

            @Override
            public boolean contains(Rectangle2D r) {
                return false;
            }

            @Override
            public PathIterator getPathIterator(AffineTransform at) {
                return null;
            }

            @Override
            public PathIterator getPathIterator(AffineTransform at, double flatness) {
                return null;
            }
        };
        circle = new Circle((this.getWidth() / 2) + 10, 10, 50d);
    }
}
