package lectures_programs;

import java.awt.*;

public class Ball {

    // note that (x,y) will be the centre of the ball,
    // while drawings refer to upper-left corner of the bounding box
    private double x, y, vx, vy; // position and velocity
    private final int radius;
    private final Color color;
    public static final int MAX_BALL_SPEED = 10;

    // dimensions of box in which ball can be moved
    // needed for ball initialisation and ball movement
    public static final int BOX_WIDTH = 600, BOX_HEIGHT = 600;

    // construct ball with random direction starting in box center
    public Ball(int size, Color color) {
        x = BOX_WIDTH / 2;
        y = BOX_HEIGHT / 2;
        vx = (2 * Math.random() - 1) * MAX_BALL_SPEED;
        vy = (2 * Math.random() - 1) * MAX_BALL_SPEED;
        this.radius = size;
        this.color = color;
    }

    // ball with given coordinates and direction
    public Ball(double x, double y, double vx, double vy, int size, Color color) {
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.radius = size;
        this.color = color;
    }

    public void move() {
        x += vx;
        y += vy;
        if (x < radius || x + radius > BOX_WIDTH)
            vx *= -1;
        if (y < radius || y + radius > BOX_HEIGHT)
            vy *= -1;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getVx() {
        return vx;
    }

    public double getVy() {
        return vy;
    }

    public int getRadius() {
        return radius;
    }

    public Color getColor() {
        return color;
    }


    @Override
    public String toString() {
        return "Ball(" + x + "," + y + "," + vx + "," + vy + ")";
    }


    public Ball copy() {
        return new Ball(x, y, vx, vy, radius, color);
    }

}
