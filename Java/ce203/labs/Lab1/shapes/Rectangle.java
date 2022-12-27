package labs.Lab1.shapes;

public class Rectangle extends Shape {
    protected int height;
    protected int width;
    protected int x;
    protected int y;

    public Rectangle(int height, int width, int x, int y) {
        //super(67, 89, 9, 0);
        this.name = "Rectangle";
        this.height = height;
        this.width = width;
        this.x = x;
        this.y = y;
    }

    public Rectangle() {

    }

    public void draw() {
        System.out.println("This is a rectangle with height " + height + ", " + "width of " + width + " and corners " + x + " and " + y);
    }
}
