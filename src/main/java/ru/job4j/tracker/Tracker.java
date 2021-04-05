package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        for (int i = 0; i < size; i++) {
            if (items[i].getId() == id) {
                return items[i];
            }
        }
        return null;
    }

    public Item[] findByName(String key) {
        int counter = 0;
        Item[] result = new Item[size];

        for (int i = 0; i < size; i++) {
            if (items[i].getName().equals(key)) {
                result[counter++] = items[i];
            }
        }
        return Arrays.copyOf(result, counter);
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }
}