package ru.job4j;


import ru.job4j.actions.MenuTracker;
import ru.job4j.input.Input;
import ru.job4j.input.ConsoleInput;
import ru.job4j.input.ValidateInput;
import ru.job4j.stogare.Tracker;

/**
 * @author TinaGVI
 * @since 11.09.18
 */
public class StartUI {
    /**
     * Получение данных от пользователя.
     */

    private final Input input;
    /**
     *
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

    /**
     *
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);

        int key;
        do {
            menu.show();
            key = input.ask("Выберите пункт меню:", menu.getRange());
            menu.select(key);
        } while (key != 6);
    }


    /**
     * Запускт программы.
     *
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(
                new ValidateInput(
                        new ConsoleInput()
                ),
                new Tracker()
        ).init();
    }
}
