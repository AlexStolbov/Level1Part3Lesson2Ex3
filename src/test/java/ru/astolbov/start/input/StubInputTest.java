package ru.astolbov.start.input;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by alex on 12/29/16.
 */
public class StubInputTest {

    /**
     * Test.
     */
    @Test
    public void whenAskThenReturnString() {
        String[] answers = new String[2];
        answers[0] = "one";
        answers[1] = "two";
        StubInput stubInput = new StubInput(answers);
        assertThat(stubInput.ask("test"), is(answers[0]));
        assertThat(stubInput.ask("test"), is(answers[1]));
    }
}