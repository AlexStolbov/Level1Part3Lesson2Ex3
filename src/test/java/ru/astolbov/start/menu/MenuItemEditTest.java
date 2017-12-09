package ru.astolbov.start.menu;

import org.junit.Test;
import ru.astolbov.models.Item;
import ru.astolbov.start.input.ConsoleOutput;
import ru.astolbov.start.input.StubInput;
import ru.astolbov.start.Tracker;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by alex on 1/6/17.
 */
public class MenuItemEditTest {

    /**
     * Test edit item.
     */
    @Test
    public void whenEditItemThenItemsHaveNewName() {
        Tracker tracker = new Tracker();
        tracker.addItem(new Item());

        String[] answers = new String[2];
        answers[0] = tracker.getItems().get(0).getId();
        answers[1] = "new name";

        MenuTracker menuTracker = new MenuTracker(tracker, new StubInput(answers), new ConsoleOutput());
        MenuTracker.MenuItemEdit menuItemEdit = menuTracker.new MenuItemEdit();
        ArrayList<String> result = menuItemEdit.doCommandMenu();

        assertThat(result.get(0), is("Item is edited"));
    }

    /**
     * Test edit comment.
     */
    @Test
    public void whenEditNoExistItemThenDoNothing() {
        Tracker tracker = new Tracker();

        String[] answers = new String[2];
        answers[0] = "-1";
        answers[1] = "new name";

        MenuTracker menuTracker = new MenuTracker(tracker, new StubInput(answers), new ConsoleOutput());
        MenuTracker.MenuItemEdit menuItemEdit = menuTracker.new MenuItemEdit();
        ArrayList<String> result = menuItemEdit.doCommandMenu();

        assertThat(result.get(0), is("Item not found"));
    }
}