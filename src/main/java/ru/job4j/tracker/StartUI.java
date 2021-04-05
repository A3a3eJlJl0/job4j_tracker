package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        tracker.add(new Item("Test"));
        Item item = tracker.findById(1);
        System.out.println(item.getId());
        System.out.println(item.getName());
        System.out.println(item.getCreated());
    }
}
