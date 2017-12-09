package ru.astolbov.start.input;

/**
 * Created by alex on 12/20/16.
 */
public interface Input {

    /**
     * Asks a question to the user and receives the response.
     * @param question - a question to the user
     * @return - the input string
     */
    String ask(String question);

    /**
     * Asks a question to the user and receives the response.
     * Validate input
     * @param question - a question to the user
     * @param maxMenuKey - max of valid value
     * @return - the input string
     */
    int ask(String question, int maxMenuKey);
}
