package ru.job4j.oop;

public class Triangle {
    private Point a;
    private Point b;
    private Point c;
    private double ab;
    private double ac;
    private double bc;

    public Triangle(Point ap, Point bp, Point cp) {
        this.a = ap;
        this.b = bp;
        this.c = cp;

        this.ab = a.distance(b);
        this.ac = a.distance(c);
        this.bc = b.distance(c);
    }

    public double perimeter() {
        return this.ab + this.ac + this.bc;
    }


    public boolean exist() {
        return (this.ab + this.ac > this.bc) && (this.ab + this.bc > this.ac) && (this.ac + this.bc > this.ab);
    }

    public double area() {
        double result = -1;

        if (this.exist()) {
            double p = this.perimeter() / 2;
            result = Math.sqrt(p * (p - this.ab) * (p - this.ac) * (p - this.bc));
        }
        return result;
    }
}
