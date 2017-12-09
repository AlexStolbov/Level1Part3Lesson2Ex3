package ru.astolbov.start.input;

import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by alex on 1/31/17.
 */
public class ConsoleInputValidateTest {

    /**
     * Test validate input.
     */
    @Test
    public void whenAskIntCharThenReturnInt() {
        String question = "Select menu: ";
        int testMenuKey = 1;
        int invalidMenuKey = 100;
        String testString = "a".concat(System.lineSeparator());
        testString = testString.concat(String.valueOf(invalidMenuKey)).concat(System.lineSeparator());
        testString = testString.concat(String.valueOf(testMenuKey)).concat(System.lineSeparator());
        int maxMenuKey = 3;

        ByteArrayInputStream in = new ByteArrayInputStream(testString.getBytes());
        System.setIn(in);

        ConsoleInputValidate consoleInputValidate = new ConsoleInputValidate();
        int menuKey = consoleInputValidate.ask(question, maxMenuKey);
        assertThat(menuKey, is(testMenuKey));
    }

}