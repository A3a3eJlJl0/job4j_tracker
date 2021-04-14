package ru.job4j.tracker;

interface MenuHandler {
    void handle(Input input, Tracker tracker);
}

public class StartUI {
    private boolean run;

    public void init(Input input, Tracker tracker) {
        run = true;
        while (run) {
            showMenu();
            getMenuHandler(input.askInt("Select: ")).handle(input, tracker);
        }
    }

    private MenuHandler getMenuHandler(int menuItem) {
        return switch (menuItem) {
            case 0 -> StartUI::add;
            case 1 -> StartUI::showAll;
            case 2 -> StartUI::edit;
            case 3 -> StartUI::delete;
            case 4 -> StartUI::getById;
            case 5 -> StartUI::findByName;
            case 6 -> this::exit;
            default -> StartUI::printError;
        };
    }

    private void showMenu() {
        String[] menu = {
                "Add new Item", "Show all items", "Edit item",
                "Delete item", "Find item by id", "Find items by name",
                "Exit Program"
        };
        System.out.println("Menu:");
        for (int i = 0; i < menu.length; i++) {
            System.out.println(i + ". " + menu[i]);
        }
    }

    public static void add(Input input, Tracker tracker) {
        String name = input.askStr("=== Create a new Item ====" + System.lineSeparator() + "Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        System.out.println("Добавленная заявка: " + item);
    }

    public static void showAll(Input input, Tracker tracker) {
        Item[] items = tracker.findAll();
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            System.out.println("Хранилище еще не содержит заявок");
        }
    }

    public static void edit(Input input, Tracker tracker) {
        int id = input.askInt("=== Edit item ====" + System.lineSeparator() + "Enter id: ");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.println("Заявка изменена успешно.");
        } else {
            System.out.println("Ошибка замены заявки.");
        }
    }

    public static void delete(Input input, Tracker tracker) {
        int id = input.askInt("=== Delete item ====" + System.lineSeparator() + "Enter id: ");
        if (tracker.delete(id)) {
            System.out.println("Заявка удалена успешно.");
        } else {
            System.out.println("Ошибка удаления заявки.");
        }
    }

    public static void getById(Input input, Tracker tracker) {
        int id = input.askInt("=== Find item by id ====" + System.lineSeparator() + "Enter id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("Заявка с введенным id: " + id + " не найдена.");
        }
    }

    public static void findByName(Input input, Tracker tracker) {
        String name = input.askStr("=== Find items by name ====" + System.lineSeparator() + "Enter name: ");
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            System.out.println("Заявки с именем: " + name + " не найдены.");
        }
    }

    private void exit(Input input, Tracker tracker) {
        System.out.println("=== Exiting... ====");
        run = false;
    }

    private static void printError(Input input, Tracker tracker) {
        System.out.println("No such menu item. Try again.");
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}