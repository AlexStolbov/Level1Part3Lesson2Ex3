package ru.astolbov.start.input;

import java.util.ArrayList;

/**
 * Created by alex on 12/26/16.
 */
public class ConsoleOutput {
    /**
     * Show array.
     * @param strings - array of string to show
     */
    public void toConsole(ArrayList<String> strings) {
        if (strings.size() > 0) {
            System.out.printf("%s", System.lineSeparator());
            for (String strLine: strings) {
                if (strLine != null) {
                    System.out.print(strLine);
                }
            }
            System.out.printf("%s", System.lineSeparator());
        }
    }
}
