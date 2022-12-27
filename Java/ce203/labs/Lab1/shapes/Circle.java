package labs.Lab1.shapes;

public class Circle extends Shape {
    protected final int centreX;
    protected final int centreY;
    protected final double radius;

    public Circle(int centreX, int centreY, double radius) {
        this.name = "circle";
        this.centreX = centreX;
        this.centreY = centreY;
        this.radius = radius;
    }

    public void draw() {
        System.out.println("This is a circle with centre (" + centreX + ", " + centreY + ") and radius " + radius);
    }
}
