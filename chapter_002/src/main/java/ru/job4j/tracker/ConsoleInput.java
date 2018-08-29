package ru.job4j.tracker;

import java.util.Scanner;

/**
 * Запрос в консоль.
 *
 * @author TinaGVI
 * @since 29.08.2018
 */
public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    public String ask(String question) {
        System.out.printf(question);
        return scanner.nextLine();
    }
}