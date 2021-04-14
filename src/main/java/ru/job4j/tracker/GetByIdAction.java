package ru.job4j.tracker;

public class GetByIdAction implements UserAction{
    @Override
    public String name() {
        return "Find item by ID";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("=== Find item by id ====" + System.lineSeparator() + "Enter id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("Заявка с введенным id: " + id + " не найдена.");
        }
        return true;
    }
}
