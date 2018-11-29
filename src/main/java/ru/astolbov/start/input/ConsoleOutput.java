package ru.astolbov.start.input;

import java.util.List;
import java.util.function.Consumer;

/**
 * Created by alex on 12/26/16.
 */
public class ConsoleOutput {
    /**
     * Show array.
     * @param res - list of string to show
     * @param cons - consumer
     */
    public void toConsole(List<String> res, Consumer<List<String>> cons) {
        if (res.size() > 0) {
            System.out.printf("%s", System.lineSeparator());
            cons.accept(res);
            System.out.printf("%s", System.lineSeparator());
        }
    }
}
