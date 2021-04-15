package ru.job4j.tracker;

public class CreateAction implements UserAction{
    private final Output out;

    public CreateAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Add new item.";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("=== Create a new Item ====" + System.lineSeparator() + "Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        System.out.println("Добавленная заявка: " + item);
        return true;
    }
}
