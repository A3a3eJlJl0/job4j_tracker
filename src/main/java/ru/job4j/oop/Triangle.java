package ru.job4j.oop;

public class Triangle {
    private Point a;
    private Point b;
    private Point c;
    private double ab;
    private double ac;
    private double bc;

    public Triangle(Point ap, Point bp, Point cp) {
        a = ap;
        b = bp;
        c = cp;

        ab = a.distance(b);
        ac = a.distance(c);
        bc = b.distance(c);
    }

    public double perimeter() {
        return ab + ac + bc;
    }


    public boolean exist() {
        return (ab + ac > bc) && (ab + bc > ac) && (ac + bc > ab);
    }

    public double area() {
        double result = -1;

        if (exist()) {
            double p = perimeter() / 2;
            result = Math.sqrt(p * (p - ab) * (p - ac) * (p - bc));
        }
        return result;
    }
}
