package ru.job4j.tracker.actions.stogare;

import ru.job4j.tracker.actions.model.Item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.lang.*;
import java.util.List;

/**
 * @author TinaGVI
 * @since 10.08.2018
 */
public class Tracker {
    private static int generate;
    /**
     * Массив для хранение заявок.
     */
    private final List<Item> items = new ArrayList<>();

    /**
     * Указатель ячейки для новой заявки.
     */
//    private int position;

    /**
     * Метод реализаущий добавление заявки в хранилище
     *
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items.add(item);
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     *
     * @return Уникальный ключ.
     */
    private String generateId() {
        Date date = new Date();
        return date + "_" + String.valueOf(++generate);
    }

    /**
     * Метод редактирование заявок.
     *
     * @param id   айди заявки на редактирование.
     * @param item отредактированная заявка.
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int i = 0; i < this.items.size(); i++) {
            if (id.equals(items.get(i).getId())) {
                item.setId(id);
                this.items.set(i, item);
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Метод удаление заявок.
     *
     * @param id айди заявки на удаление.
     */
    public boolean delete(String id) {
        boolean result = false;
        for (int i = 0; i < this.items.size(); i++) {
            if (id.equals(items.get(i))) {
                result = items.remove(i) != null;
                break;
            }
        }
        return result;
    }


    /**
     * Mетод получение списка всех заявок.
     *
     * @return список заявок.
     */
    public List<Item> findAll() {
        return this.items;
    }

    /**
     * Mетод получение списка по имени.
     *
     * @param name уникальныйключ.
     * @return список.
     */
    public List<Item> findByName(String name) {
        List<Item> result = new ArrayList<>();
        for (Item item : items) {
            if (item != null && item.getName().equals(name)) {
                result.add(item);
            }
        }
        return result;
    }

    /**
     * Mетод получение заявки по id.
     *
     * @param id айди заявки.
     * @return возврат заявки.
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }
}