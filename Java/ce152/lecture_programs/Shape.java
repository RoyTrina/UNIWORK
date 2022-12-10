package lectures_programs;

public abstract class Shape {
    public double x;
    public double y;

    public abstract double area();

    public abstract double perimeter();

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "[" + x + "," + y + "]";
    }

    // test code
    public static void main(String[] args) {
        testShapes();
    }

    public static void testShapes() {
        Circle c1 = new Circle(100, 200, 50);
        Circle c2 = new Circle(210, 100, 50);
        Rectangle r1 = new Rectangle(100, 200, 50, 100);
        System.out.println("c1= " + c1);
        System.out.println("c2= " + c2);
        System.out.println("r1= " + r1);
    }

}
