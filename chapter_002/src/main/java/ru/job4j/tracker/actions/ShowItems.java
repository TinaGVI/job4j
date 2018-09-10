package ru.job4j.tracker.actions;

import ru.job4j.tracker.stogare.Tracker;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.model.Item;

/**
 * Показывает основные поля в консоли.
 *
 * @author TinaGVI
 * @since 29.08.2018
 */
public class ShowItems implements UserAction {

    private final int show;
    private final String info;

    public ShowItems(int key, String info) {
        show = key;
        this.info = info;
    }

    @Override
    public int key() {
        return show;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Вывод всех заявок --------------");
        for (Item item : tracker.findAll()) {
            System.out.println(item);
        }
    }

    @Override
    public String info() {
        return String.format("%d.%s", key(), this.info);
    }
}
