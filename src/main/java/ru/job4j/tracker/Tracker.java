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
        int index = indexOf(id);
        return index == -1 ? null : items[index];
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

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean found = index != -1;
        if (found) {
            item.setId(id);
            items[index] = item;
        }
        return found;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean found = index != -1;
        if (found) {
            System.arraycopy(items, index + 1, items, index, size - index);
            items[size - 1] = null;
            size--;
        }
        return found;
    }

    private int indexOf(int id) {
        for (int i = 0; i < size; i++) {
            if (items[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }
}