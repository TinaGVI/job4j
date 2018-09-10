package ru.job4j.tracker.actions;

import ru.job4j.tracker.stogare.Tracker;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.model.Item;

/**
 * Класс добавления заявок.
 *
 * @author TinaGVI
 * @since 29.08.2018
 */
public class AddItem implements UserAction {
    private final int add;
    private final String info;

    public AddItem(int key, String info) {
        add = key;
        this.info = info;
    }

    @Override
    public int key() {
        return add;
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

    @Override
    public String info() {
        return String.format("%d.%s", key(), this.info);
    }
}

