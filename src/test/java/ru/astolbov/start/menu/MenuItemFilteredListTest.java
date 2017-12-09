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
 * Created by alex on 1/10/17.
 */
public class MenuItemFilteredListTest {

    /**
     * Test filtered list.
     */
    @Test
    public void whenFilterListThenListContainFilter() {
        Tracker tracker = new Tracker();
        tracker.addItem(new Item());
        tracker.addItem(new Item());
        tracker.addItem(new Item());
        tracker.getItems().get(0).setName("test1");
        tracker.getItems().get(1).setName("test2");
        tracker.getItems().get(2).setName("other");

        String[] answers = new String[1];
        answers[0] = "test";

        MenuTracker menuTracker = new MenuTracker(tracker, new StubInput(answers), new ConsoleOutput());
        MenuTracker.MenuItemFilteredList menuItemFilteredList = menuTracker.new MenuItemFilteredList();

        ArrayList<String> result = menuItemFilteredList.doCommandMenu();

        assertThat(result.size(), is(2));
    }
}