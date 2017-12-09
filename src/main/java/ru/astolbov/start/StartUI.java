package ru.astolbov.start;

import ru.astolbov.start.input.ConsoleInput;
import ru.astolbov.start.input.ConsoleInputValidate;
import ru.astolbov.start.input.ConsoleOutput;
import ru.astolbov.start.input.Input;
import ru.astolbov.start.menu.BaseItem;
import ru.astolbov.start.menu.MenuItem;
import ru.astolbov.start.menu.MenuTracker;

import java.util.ArrayList;

/**
 * Created by alex on 12/13/16.
 */
public class               StartUI {

    /**
     * Tracker.
     */
    private Tracker tracker = new Tracker();;

    /**
     * Main menu.
     */
    private MenuTracker menuTracker;

    /**
     input source.
     */
    private Input input;

    /**
     * Print string array on console.
     */
    private ConsoleOutput consoleOutput = new ConsoleOutput();

    /**
     * Constructor.
     * @param inputSet - console or array
     */
    public StartUI(Input inputSet) {
        if (inputSet == null) {
            this.input = new ConsoleInput();
        } else {
            this.input = inputSet;
        }

        menuTracker = new MenuTracker(tracker, input, consoleOutput);

        MenuItem menuExit = new BaseItem("Exit", true) {
            public ArrayList<String> doCommandMenu() {
                ArrayList<String> list = new ArrayList<>();
                list.add("-------- Goodbye! ---------");
                return list;
            }
        };

        menuTracker.addItem(menuExit);
    }

    /**
     * start program.
     * @return - 0
     */
    public int begin() {
        boolean exit;
        do {
            exit = menuTracker.showMenuRequestItem();
        } while (!exit);
        return 0;
    }

    /**
     * Getter input.
     * @return input
     */
    public Input getInput() {
        return input;
    }

    /**
     * Getter tracker.
     * @return tracker
     */
    public Tracker getTracker() {
        return tracker;
    }

    /**
     * Setter input.
     * @param inputSet - input
     */
    public void setInput(Input inputSet) {
        this.input = inputSet;
    }

    /**
     * Main.
     * @param args - line parameters
     */
    public static void main(String[] args) {
        ConsoleInput inputConsole = new ConsoleInputValidate();
        StartUI startui = new StartUI(inputConsole);
        int finishCode = startui.begin();
    }
}
