package ru.job4j.tracker;

import java.util.Scanner;

interface MenuHandler {
    void handle();
}

public class StartUI {
    private Scanner scanner;
    private Tracker tracker;
    private boolean run;

    public StartUI(Scanner scanner, Tracker tracker) {
        this.scanner = scanner;
        this.tracker = tracker;
    }

    public void run() {
        run = true;
        while (run) {
            showMenu();
            int menuItem = getMenuInput();
            getMenuHandler(menuItem).handle();
        }
    }

    private MenuHandler getMenuHandler(int menuItem) {
        return switch (menuItem) {
            case 0 -> this::add;
            case 1 -> this::showAll;
            case 2 -> this::edit;
            case 3 -> this::delete;
            case 4 -> this::getById;
            case 5 -> this::findByName;
            case 6 -> this::exit;
            default -> this::printError;
        };
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
        System.out.println();
    }

    private int getMenuInput() {
        System.out.println("Select: ");
        return scanner.nextInt();
    }

    private void add() {
        System.out.println("=== Create Item ====");
        System.out.println("Enter name: ");
        Item item = new Item(scanner.nextLine());
        tracker.add(item);
        System.out.print("New item added.");
    }

    private void showAll() {
        System.out.println("=== Founded Items ====");
        Item[] items = tracker.findAll();
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            System.out.println("Not items found.");
        }
    }

    private void edit() {
        System.out.println("=== Edit Item ====");
        System.out.println("Enter Replaced Item ID: ");
        int replacedId = scanner.nextInt();
        System.out.println("Enter New Item Name: ");
        Item item = new Item(scanner.nextLine());
        if (tracker.replace(replacedId, item)) {
            System.out.println("Edit success.");
        } else {
            System.out.println("Edit error. Try again.");
        }
    }

    private void delete() {
        System.out.println("=== Delete Item ====");
        System.out.println("Enter Item For Delete ID: ");
        if (tracker.delete(scanner.nextInt())) {
            System.out.println("Delete success.");
        } else {
            System.out.println("Delete error. Try again.");
        }
    }

    private void getById() {
        System.out.println("=== Getting Item ====");
        System.out.println("Enter Item ID: ");
        Item item = tracker.findById(scanner.nextInt());
        if (item == null) {
            System.out.println("Not items found.");
        } else {
            System.out.println(item);
        }
    }

    private void findByName() {
        System.out.println("=== Finding Items ====");
        System.out.println("Enter Item(s) Name: ");
        Item[] items = tracker.findByName(scanner.nextLine());
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            System.out.println("Not items found.");
        }
    }

    private void exit() {
        System.out.println("=== Exiting... ====");
        run = false;
    }

    private void printError() {
        System.out.println("No such menu item. Try again.");
    }

    public static void main(String[] args) {
        new StartUI(new Scanner(System.in), new Tracker()).run();
    }
}