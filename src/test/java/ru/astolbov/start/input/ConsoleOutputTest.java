package ru.astolbov.start.input;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by alex on 12/30/16.
 */
public class ConsoleOutputTest {

    /**
     * Test output class.
     */
    @Test
    public void whenOutStringThenOutIt() {
        ArrayList<String> testStrings = new ArrayList<>();
        testStrings.add("test output");
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        System.setErr(new PrintStream(out));
        ConsoleOutput consoleOutput = new ConsoleOutput();
        consoleOutput.toConsole(testStrings);
        assertThat(testStrings, is(testStrings));
    }

}