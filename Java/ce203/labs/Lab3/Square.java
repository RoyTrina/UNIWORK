package labs.Lab3;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
     * Created by Owen Daynes on 29/10/2018.
     */
    public abstract class Square implements Shape {

        private Integer sideLength;
        private int posX;
        private int posY;

        public Square(Integer posX, Integer posY, Integer sideLength) {
            this.posX = posX;
            this.posY = posY;
            this.sideLength = sideLength;
        }

    public Square() {
        Square square = new Square() {
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
    }


// --Commented out by Inspection START (08/08/2021 23:35):
//    public Integer getArea() {
//            return this.sideLength * this.sideLength;
//        }
// --Commented out by Inspection STOP (08/08/2021 23:35)

// --Commented out by Inspection START (08/08/2021 23:35):
//        public void draw(Graphics g) {
//            g.setColor(Color.YELLOW);
//            g.fillRect(this.posX, this.posY, this.sideLength, this.sideLength);
//        }
// --Commented out by Inspection STOP (08/08/2021 23:35)

        public static void main (String[] args){
            Square square = new Square() {
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
        }

    }