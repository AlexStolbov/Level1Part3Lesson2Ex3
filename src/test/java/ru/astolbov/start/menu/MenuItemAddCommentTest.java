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
 * Created by alex on 1/5/17.
 */
public class MenuItemAddCommentTest {
    /**
     * Test add comment.
     */
    @Test
    public void whenAddCommentThenItemsHaveComment() {
        Tracker tracker = new Tracker();
        tracker.addItem(new Item());

        String[] answers = new String[2];
        answers[0] = tracker.getItems().get(0).getId();
        answers[1] = "text comment";

        MenuTracker menuTracker = new MenuTracker(tracker, new StubInput(answers), new ConsoleOutput());
        MenuTracker.MenuItemAddComment menuAddComment = menuTracker.new MenuItemAddComment();

        ArrayList<String> result = menuAddComment.doCommandMenu();

        assertThat(result.get(0), is("comment is added"));
    }

    /**
     * Test add comment when id item not exist.
     */
    @Test
    public void whenAddCommentForNotExistItemThenItemNotFound() {
        Tracker tracker = new Tracker();
        tracker.addItem(new Item());

        String[] answers = new String[2];
        answers[0] = "-1";
        answers[1] = "text comment";

        MenuTracker menuTracker = new MenuTracker(tracker, new StubInput(answers), new ConsoleOutput());
        MenuTracker.MenuItemAddComment menuAddComment = menuTracker.new MenuItemAddComment();
        ArrayList<String> result = menuAddComment.doCommandMenu();

        assertThat(result.get(0), is("Item not found"));
    }
}