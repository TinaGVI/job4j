package ru.job4j.tracker.actions.input;

import ru.job4j.exception.MenuOutException;

import java.util.List;
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

    public int ask(String question, List<Integer> range) throws MenuOutException, NumberFormatException {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (!exist) {
            throw new MenuOutException("Выберите правильный пункт меню.");
        }
        return key;
    }
}