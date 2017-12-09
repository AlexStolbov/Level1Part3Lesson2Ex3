package ru.astolbov.start.input;

import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by alex on 12/28/16.
 */
public class ConsoleInputTest {
    /**
     * Test console input.
     */
    @Test
    public void whenAskTestThenGeStringTest() {
        String testString = "SomeText";
        ByteArrayInputStream in = new ByteArrayInputStream(testString.concat(System.lineSeparator()).getBytes());
        System.setIn(in);
        ConsoleInput consoleInput = new ConsoleInput();
        String request = consoleInput.ask("test ask");
        assertThat(request, is(testString));
    }

    /**
     * Test validate console input.
     */
    @Test
    public void whenValidateAskTestThenGeStringTest() {
        String testString = "1";
        int maxMenuKey = 1;
        ByteArrayInputStream in = new ByteArrayInputStream(testString.concat(System.lineSeparator()).getBytes());
        System.setIn(in);
        ConsoleInput consoleInput = new ConsoleInput();
        int request = consoleInput.ask("test ask", maxMenuKey);
        assertThat(request, is(Integer.valueOf(testString)));
    }

    /**
     * Test validate console input with exception.
     */
    @Test
    public void whenValidateAskZeroThenGeException() {
        String testString = "0";
        int maxMenuKey = 1;
        boolean getException = false;
        ByteArrayInputStream in = new ByteArrayInputStream(testString.concat(System.lineSeparator()).getBytes());
        System.setIn(in);
        ConsoleInput consoleInput = new ConsoleInput();
        try {
            int request = consoleInput.ask("0", maxMenuKey);
        } catch (Exception ex) {
            getException = true;
        }
        assertThat(getException, is(true));
    }
}
