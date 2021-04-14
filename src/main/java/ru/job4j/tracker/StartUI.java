package ru.job4j.tracker;

public class StartUI {
    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            showMenu(actions);
            run = actions[input.askInt("Select: ")].execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions) {
        for (int i = 0; i < actions.length; i++) {
            System.out.println(i + ". " + actions[i].name());
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
            new CreateAction(),
            new ShowAllAction(),
            new ReplaceAction(),
            new DeleteAction(),
            new GetByIdAction(),
            new FindByNameAction(),
            new ExitAction(),
        };
        new StartUI().init(input, tracker, actions);
    }
}