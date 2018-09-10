package ru.job4j.tracker.actions;

import ru.job4j.tracker.stogare.Tracker;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.model.Item;

/**
 * Класс поиска заявки по id.
 *
 * @author TinaGVI
 * @since 29.08.2018
 */
public class FindItemById implements UserAction {
    private final int find;
    private final String info;

    public FindItemById(int key, String info) {
        find = key;
        this.info = info;
    }

    @Override
    public int key() {
        return find;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Поиск заявки по id --------------");
        String id = input.ask("Введите id заявки, которую хотите найти:");
        Item item = tracker.findById(id);
        System.out.println("------------ Найдена заявка по id " + item + "  -----------");
    }

    @Override
    public String info() {
        return String.format("%d.%s", key(), this.info);
    }
}
