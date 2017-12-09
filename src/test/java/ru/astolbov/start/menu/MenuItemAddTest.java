package ru.astolbov.start.menu;

import org.junit.Test;
import ru.astolbov.start.input.ConsoleOutput;
import ru.astolbov.start.input.StubInput;
import ru.astolbov.start.Tracker;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by alex on 12/30/16.
 */
public class MenuItemAddTest {

    /**
     * Test menu name.
     */
    @Test
    public void whenGetMenuNameThenGetIt() {

        String[] answers = new String[2];
        answers[0] = "item name";
        answers[1] = "descr";

        MenuTracker menuTracker = new MenuTracker(new Tracker(), new StubInput(answers), new ConsoleOutput());
        MenuTracker.MenuItemAdd menuAdd = menuTracker.new MenuItemAdd();

        assertThat(menuAdd.getMenuName(), is("Add new item"));
    }
}