package labs.Lab1.shapes;


import java.awt.*;

public abstract class Shape {
    public String name = "shape";
    public final String colour = "black";
    public int height;
    protected int width;

    protected int x;
    protected int y;

    protected Color col;

    public Shape(int height, int width, int x, int y) {
        this.height = height;
        this.width = width;
        this.x = x;
        this.y = y;
    }

    public Shape() {


    }


    public void printName() {
        System.out.println("I am a " + colour + " " + name);
    }


    public abstract void draw();

    public void setColour(Color c) {
        col = c;
    }

}
