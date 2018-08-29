package ru.job4j.tracker;

import java.util.Arrays;

/**
 * Класс поиска заявки по имени.
 *
 * @author TinaGVI
 * @since 29.08.2018
 */
public class FindItemsByName implements UserAction {
    private final int find;
    private final String info;

    public FindItemsByName(int key, String info) {
        find = key;
        this.info = info;
    }

    @Override
    public int key() {
        return find;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Поиск заявки по имени --------------");
        String id = input.ask("Введите имя заявки, которую хотите найти:");
        Item[] items = tracker.findByName(id);
        System.out.println("------------ Найдена заявка по id  " + Arrays.toString(items) + " -----------");
    }

    @Override
    public String info() {
        return String.format("%d.%s", key(), this.info);
    }
}
