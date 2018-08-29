package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

/**
 * @author TinaGVI
 * @since 19.08.2018
 */
public class StartUI {
    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
        List<Integer> range = new ArrayList<>();
        for (int i = 0; i < menu.getActionsLentgh(); i++) {
            range.add(i);
        }
        int key;
        do {
            menu.show();
            key = Integer.valueOf(input.ask("Выберите пункт меню:"));
            menu.select(key);
        } while (key != 6);
    }


    /**
     * Запускт программы.
     *
     * @param args
     */
    public static void main(String[] args) {

        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
