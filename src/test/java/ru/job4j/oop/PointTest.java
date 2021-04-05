package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {
    @Test
    public void whenA000B002Then2() {
        Point a = new Point(0, 0, 0);
        Point b = new Point(0, 0, 2);
        double expected = 2;
        double result = a.distance3d(b);
        Assert.assertEquals(expected, result, 0.001);
    }

    @Test
    public void whenA111B111Then0() {
        Point a = new Point(1, 1, 1);
        Point b = new Point(1, 1, 1);
        double expected = 0;
        double result = a.distance3d(b);
        Assert.assertEquals(expected, result, 0.001);
    }

    @Test
    public void whenA00B02Then2() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        double expected = 2;
        double result = a.distance(b);
        Assert.assertEquals(expected, result, 0.001);
    }

    @Test
    public void whenA11B11Then0() {
        Point a = new Point(1, 1);
        Point b = new Point(1, 1);
        double expected = 0;
        double result = a.distance3d(b);
        Assert.assertEquals(expected, result, 0.001);
    }
}