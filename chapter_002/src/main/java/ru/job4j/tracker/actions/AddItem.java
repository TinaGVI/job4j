package ru.job4j.tracker.actions;

import ru.job4j.tracker.stogare.Tracker;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.model.Item;

/**
 * Класс добавления заявок.
 *
 * @author TinaGVI
 * @since 11.09.18
 */
public class AddItem extends BaseAction {

    public AddItem(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Создание заявки --------------");
        String name = input.ask("Введите имя заявки :");
        String desc = input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        tracker.add(item);
        System.out.println("------------ Новое Id заявки : " + item.getId());
        System.out.println("------------ Новое имя заявки : " + item.getName());
        System.out.println("------------ Новое описание заявки : " + item.getDescription());
    }
}

