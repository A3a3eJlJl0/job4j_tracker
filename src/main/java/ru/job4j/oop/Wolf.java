package ru.job4j.oop;

public class Wolf {
    public void tryEat(Ball ball) {
        System.out.println("Волк говорит, я тебя съем.");
        ball.tryEat(this);
    }
}
