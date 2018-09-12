package ru.job4j.tracker.actions;

import ru.job4j.tracker.actions.input.Input;
import ru.job4j.tracker.actions.model.Item;
import ru.job4j.tracker.actions.stogare.Tracker;

import java.util.Arrays;

/**
 * Класс поиска заявки по имени.
 *
 * @author TinaGVI
 * @since 11.09.18
 */
public class FindItemsByName extends BaseAction {
    public FindItemsByName(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Поиск заявки по имени --------------");
        String id = input.ask("Введите имя заявки, которую хотите найти:");
        Item[] items = tracker.findByName(id);
        System.out.println("------------ Найдена заявка по id  " + Arrays.toString(items) + " -----------");
    }
}
