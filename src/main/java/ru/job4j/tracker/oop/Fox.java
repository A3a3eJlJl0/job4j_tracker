package ru.job4j.tracker.oop;

public class Fox {
    public void tryEat(Ball ball) {
        System.out.println("Лиса говорит, я тебя съем.");
        ball.tryEat(this);
    }
}
