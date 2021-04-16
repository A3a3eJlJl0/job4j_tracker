package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;

public class StartUITest {
    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        UserAction[] actions = {
                new ReplaceAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new DeleteAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenFindAllNotFound() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        UserAction[] actions = {
                new ShowAllAction(out),
                new ExitAction(out),
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
     "Menu:" + System.lineSeparator() +
            "0. Show all items" + System.lineSeparator() +
            "1. Exit" + System.lineSeparator() +
            "Хранилище еще не содержит заявок" + System.lineSeparator() +
            "Menu:" + System.lineSeparator() +
            "0. Show all items" + System.lineSeparator() +
            "1. Exit" + System.lineSeparator() +
            "=== Exiting... ====" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindAllFound() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = new Item("test");
        Item anotherItem = new Item("another test");
        tracker.add(item);
        tracker.add(anotherItem);
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        UserAction[] actions = {
                new ShowAllAction(out),
                new ExitAction(out),
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu:" + System.lineSeparator() +
                        "0. Show all items" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator() +
                        item.toString() + System.lineSeparator() +
                        anotherItem.toString() + System.lineSeparator() +
                        "Menu:" + System.lineSeparator() +
                        "0. Show all items" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator() +
                        "=== Exiting... ====" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindByNameNotFound() {
        String name = "test";
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Input in = new StubInput(
                new String[] {"0", name, "1"}
        );
        UserAction[] actions = {
                new FindByNameAction(out),
                new ExitAction(out),
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu:" + System.lineSeparator() +
                        "0. Find items by name" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator() +
                        "Заявки с именем: " + name +" не найдены." + System.lineSeparator() +
                        "Menu:" + System.lineSeparator() +
                        "0. Find items by name" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator() +
                        "=== Exiting... ====" + System.lineSeparator()
        ));
    }

    @Test
    public void whenGetByIdNotFound() {
        String id = "5";
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Input in = new StubInput(
                new String[] {"0", id, "1"}
        );
        UserAction[] actions = {
                new GetByIdAction(out),
                new ExitAction(out),
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu:" + System.lineSeparator() +
                        "0. Find item by ID" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator() +
                        "Заявка с введенным id: " + id + " не найдена." + System.lineSeparator() +
                        "Menu:" + System.lineSeparator() +
                        "0. Find item by ID" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator() +
                        "=== Exiting... ====" + System.lineSeparator()
        ));
    }

    @Test
    public void whenGetByIdFound() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = new Item("test");
        tracker.add(item);
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new GetByIdAction(out),
                new ExitAction(out),
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu:" + System.lineSeparator() +
                        "0. Find item by ID" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator() +
                        item.toString() + System.lineSeparator() +
                        "Menu:" + System.lineSeparator() +
                        "0. Find item by ID" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator() +
                        "=== Exiting... ====" + System.lineSeparator()
        ));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu:" + System.lineSeparator() +
                        "0. Exit" + System.lineSeparator() +
                        "=== Exiting... ====" + System.lineSeparator()
        ));
    }
}