package lectures_programs;

public class Rectangle extends Shape {
    public double width, height;

    public Rectangle(double x, double y, double w, double h) {
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
    }

    public Rectangle() {
    }

    @Override
    public double area() {
        return Math.abs(width * height);
    }

    @Override
    public double perimeter() {
        return 2 * (width + height);
    }

    @Override
    public String toString() {
        return super.toString() + "[" + width + "," + height + "]";
    }
}
