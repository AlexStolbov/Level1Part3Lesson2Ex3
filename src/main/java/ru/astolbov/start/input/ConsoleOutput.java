package ru.astolbov.start.input;

import java.util.ArrayList;
import java.util.function.Consumer;

/**
 * Created by alex on 12/26/16.
 */
public class ConsoleOutput {
    /**
     * Show array.
     * @param strings - array of string to show
     */
    public void toConsole(ArrayList<String> res, Consumer<ArrayList<String>> cons) {
        if (res.size() > 0) {
            System.out.printf("%s", System.lineSeparator());
            cons.accept(res);
            System.out.printf("%s", System.lineSeparator());
        }
    }
}
