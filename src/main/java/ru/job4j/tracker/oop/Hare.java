package ru.job4j.tracker.oop;

public class Hare {
    public void tryEat(Ball ball) {
        System.out.println("Заяц говорит, я тебя съем.");
        ball.tryEat(this);
    }
}
