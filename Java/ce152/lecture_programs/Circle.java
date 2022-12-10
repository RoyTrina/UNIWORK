package lectures_programs;

import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class Circle extends Shape {
    private final double y;
    private final double x;
    public double radius;

    public Circle(double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.radius = r;
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public double perimeter() {
        return Math.PI * 2 * radius;
    }

    @Override
    public String toString() {
        return super.toString() + "[" + radius + "]";
    }


    public Rectangle getBounds() {
        return null;
    }

    public Rectangle2D getBounds2D() {
        return null;
    }


    public boolean contains(double x, double y) {
        return false;
    }


    public boolean contains(Point2D p) {
        return false;
    }


    public boolean intersects(double x, double y, double w, double h) {
        return false;
    }


    public boolean intersects(Rectangle2D r) {
        return false;
    }


    public boolean contains(double x, double y, double w, double h) {
        return false;
    }


    public boolean contains(Rectangle2D r) {
        return false;
    }


    public PathIterator getPathIterator(AffineTransform at) {
        return null;
    }


    public PathIterator getPathIterator(AffineTransform at, double flatness) {
        return null;
    }
}