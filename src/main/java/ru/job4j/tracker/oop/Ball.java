package ru.job4j.tracker.oop;

public class Ball  {
    public void tryEat(Fox fox) {
        System.out.println("Лиса съела колобка.");
    }

    public void tryEat(Hare hare) {
        System.out.println("Убежал колобок от зайца.");
    }

    public void tryEat(Wolf wolf) {
        System.out.println("Убежал колобок от волка.");
    }
}
