package ru.job4j.tracker;

public final class SingleTracker {
    private static Tracker tracker;

    public static Tracker getTracker() {
        if (tracker == null) {
            tracker = new Tracker();
        }
        return tracker;
    }

    public static Item add(Item item) {
        return getTracker().add(item);
    }

    public static Item findById(int id) {
        return getTracker().findById(id);
    }

    public static Item[] findByName(String key) {
        return getTracker().findByName(key);
    }

    public static Item[] findAll() {
        return getTracker().findAll();
    }

    public static boolean replace(int id, Item item) {
       return getTracker().replace(id, item);
    }

    public static boolean delete(int id) {
        return getTracker().delete(id);
    }
}
