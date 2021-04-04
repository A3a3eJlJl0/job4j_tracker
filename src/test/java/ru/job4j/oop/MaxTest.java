package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

public class MaxTest {
    @Test
    public void a3b5Then5() {
        int a = 3;
        int b = 5;
        int expected = 5;
        Assert.assertEquals(expected, Max.max(a, b));
    }

    @Test
    public void a3b5c4Then5() {
        int a = 3;
        int b = 5;
        int c = 4;
        int expected = 5;
        Assert.assertEquals(expected, Max.max(a, b, c));
    }

    @Test
    public void a8b5c4d1Then8() {
        int a = 8;
        int b = 5;
        int c = 4;
        int d = 1;
        int expected = 8;
        Assert.assertEquals(expected, Max.max(a, b, c, d));
    }
}