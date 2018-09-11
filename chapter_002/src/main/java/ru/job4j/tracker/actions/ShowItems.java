package ru.job4j.tracker.actions;

import ru.job4j.tracker.stogare.Tracker;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.model.Item;

/**
 * Показывает основные поля в консоли.
 *
 * @author TinaGVI
 * @since 11.09.18
 */
public class ShowItems extends BaseAction {

    public ShowItems(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Вывод всех заявок --------------");
        for (Item item : tracker.findAll()) {
            System.out.println(item);
        }
    }
}
