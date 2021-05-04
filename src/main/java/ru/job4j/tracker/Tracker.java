package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index == -1 ? null : items.get(index);
    }

    public List<Item> findByName(String key) {
        int counter = 0;
        List<Item> result = new ArrayList<>();

        for (Item item: items) {
            if (item.getName().equals(key)) {
                result.add(item);
            }
        }
        return result;
    }

    public List<Item> findAll() {
        return items;
    }

    public boolean replace(int id, Item item) {
        ArrayList<Item> tst;

        int index = indexOf(id);
        boolean found = index != -1;
        if (found) {
            item.setId(id);
            items.set(index, item);
        }
        return found;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean found = index != -1;
        if (found) {
            items.remove(index);
        }
        return found;
    }

    private int indexOf(int id) {
        for (Item item: items) {
            if (item.getId() == id) {
                return items.indexOf(item);
            }
        }
        return -1;
    }
}