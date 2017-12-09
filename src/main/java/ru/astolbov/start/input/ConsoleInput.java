package ru.astolbov.start.input;


import java.util.Scanner;

/**
 * Created by alex on 12/20/16.
 */
public class ConsoleInput implements Input {

    /**
     * Get users input.
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * Asks a question to the user and receives the response.
     * @param question - a question to the user
     * @return - the input string
     */
    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }

    /**
     * Asks a question to the user and receives the response.
     * Validate input
     * @param question - a question to the user
     * @param maxMenuKey - max of valid value
     * @return - the input string
     */
    public int ask(String question, int maxMenuKey) {
        System.out.print(question);
        int keyMenu = Integer.valueOf(scanner.nextLine());
        if (keyMenu < 1 || keyMenu > maxMenuKey) {
            throw new ExceptionInvalidMenuKey();
        }
        return keyMenu;
    }
}
