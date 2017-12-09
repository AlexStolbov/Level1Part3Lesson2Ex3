package ru.astolbov.start;

import org.junit.Test;
import ru.astolbov.start.input.ConsoleInput;
import ru.astolbov.start.input.StubInput;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by alex on 12/19/16.
 */
public class StartUITest {

    /**
     * Test StartUI to create with default input.
     */
    @Test
    public void whenCreateWithoutInputThenHaveConsoleInput() {
        StartUI startui = new StartUI(null);
        assertThat(startui.getInput() instanceof ConsoleInput, is(true));
    }

    /**
     * Test exit from StartUI.
     */
    @Test
    public void whenMenuExitThenReturnZero() {
        String[] answers = new String[]{"7"};
        StartUI startui = new StartUI(new StubInput(answers));
        assertThat(startui.begin(), is(0));
    }

    /**
     * Test add Item to tracker.
     */
    @Test
    public void whenAddItemThenTrackerHaveMoreOneItemAndExit() {
        String[] answers = new String[4];
        answers[0] = "1";
        answers[1] = "items name";
        answers[2] = "items description";
        answers[3] = "7";
        StartUI startui = new StartUI(new StubInput(answers));
        int exitCode = startui.begin();
        boolean testComplete = true;
        if (exitCode == 0) {
            Tracker tracker = startui.getTracker();
            testComplete = tracker.getItems().size() > 0;
        } else {
            testComplete = false;
        }
        assertThat(testComplete, is(true));
    }

    /**
     * Test add comment.
     */
    @Test
    public void whenAddCommentThenItemHaveItAndExit() {
        String[] answers = new String[4];
        answers[0] = "1";
        answers[1] = "items name";
        answers[2] = "items description";
        answers[3] = "7";
        StartUI startui = new StartUI(new StubInput(answers));
        int exitCode = startui.begin();
        if (exitCode == 0) {
            Tracker tracker = startui.getTracker();
            answers = new String[5];
            answers[0] = "6";
            answers[1] = tracker.getItems().get(0).getId();
            answers[2] = "comment";
            answers[3] = "4";
            answers[4] = "7";

            startui.setInput(new StubInput(answers));
            exitCode = startui.begin();
        }

        assertThat(exitCode, is(0));
    }

    /**
     * Test delete item.
     */
    @Test
    public void whenDeleteItemThenDeleteItAndExit() {
        String[] answers = new String[4];
        answers[0] = "1";
        answers[1] = "items name";
        answers[2] = "items description";
        answers[3] = "7";
        StartUI startui = new StartUI(new StubInput(answers));
        int exitCode = startui.begin();
        if (exitCode == 0) {
            Tracker tracker = startui.getTracker();
            answers = new String[4];
            answers[0] = "3";
            answers[1] = tracker.getItems().get(0).getId();
            answers[2] = "4";
            answers[3] = "7";

            startui.setInput(new StubInput(answers));
            exitCode = startui.begin();
        }

        assertThat(exitCode, is(0));
    }

    /**
     * Test edit item.
     */
    @Test
    public void whenEditItemThenItemHaveNewName() {
        String[] answers = new String[4];
        answers[0] = "1";
        answers[1] = "items name";
        answers[2] = "items description";
        answers[3] = "7";
        StartUI startui = new StartUI(new StubInput(answers));
        int exitCode = startui.begin();
        if (exitCode == 0) {
            Tracker tracker = startui.getTracker();
            answers = new String[5];
            answers[0] = "2";
            answers[1] = tracker.getItems().get(0).getId();
            answers[2] = "new items name";
            answers[3] = "4";
            answers[4] = "7";

            startui.setInput(new StubInput(answers));
            exitCode = startui.begin();
        }

        assertThat(exitCode, is(0));
    }

    /**
     * Test filtered list.
     */
    @Test
    public void whenFilteredListThenItemListFilteredByName() {
        String[] answers = new String[4];
        answers[0] = "1";
        answers[1] = "items name";
        answers[2] = "items description";
        answers[3] = "7";
        StartUI startui = new StartUI(new StubInput(answers));
        int exitCode = startui.begin();
        if (exitCode == 0) {
            Tracker tracker = startui.getTracker();
            answers = new String[3];
            answers[0] = "5";
            answers[1] = "name";
            answers[2] = "7";
            startui.setInput(new StubInput(answers));
            exitCode = startui.begin();
        }

        assertThat(exitCode, is(0));
    }
}
