package lectures_programs;

public class Complex {
    public final double re, im;

    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public Complex(double re) {
        this.re = re;
        this.im = 0.0;
    }

    public Complex conj() {
        return new Complex(re, -im);
    }

    public Complex add(Complex other) {
        return new Complex
                (re + other.re, im + other.im);
    }

    public Complex minus(Complex other) {
        return new Complex
                (re - other.re, im - other.im);
    }

    public Complex mult(Complex other) {
        return new Complex
                (re * other.re - im * other.im,
                        re * other.im + im * other.re);
    }

    public Complex reciprocal() {
        double d = re * re + im * im;
        return new Complex(re / d, -im / d);
    }

    public Complex div(Complex other) {
        return this.mult(other.reciprocal());
    }

    public double abs() {
        return Math.sqrt(re * re + im * im);
    }

    public double arg() {
        return Math.atan2(im, re);
    }

    public String toString() {
        return ("(" + re + " + " + im + "i)");
    }

}
