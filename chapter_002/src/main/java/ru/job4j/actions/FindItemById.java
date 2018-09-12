package ru.job4j.actions;

import ru.job4j.input.Input;
import ru.job4j.model.Item;
import ru.job4j.stogare.Tracker;

/**
 * Класс поиска заявки по id.
 *
 * @author TinaGVI
 * @since 29.08.2018
 */
public class FindItemById extends BaseAction {
    public FindItemById(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Поиск заявки по id --------------");
        String id = input.ask("Введите id заявки, которую хотите найти:");
        Item item = tracker.findById(id);
        System.out.println("------------ Найдена заявка по id " + item + "  -----------");
    }
}
