package ru.astolbov.start.input;

/**
 * Created by alex on 1/26/17.
 */
public class ConsoleInputValidate extends ConsoleInput {

    @Override
    public int ask(String question, int maxMenuKey) {
        int menuKey = 0;
        boolean repeatAsk = true;
        do {
            try {
                menuKey = super.ask(question, maxMenuKey);
                repeatAsk = false;
            } catch (NumberFormatException ex) {
                System.out.println("Please, use digits");
            } catch (ExceptionInvalidMenuKey eimk) {
                System.out.printf("Please, use digits between 1 and %d %s", maxMenuKey, System.lineSeparator());
                repeatAsk = true;
            }
        } while (repeatAsk);
        return  menuKey;
    }
}
