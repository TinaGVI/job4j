package ru.job4j.tracker.actions.stogare;

import ru.job4j.tracker.actions.model.Item;

import java.util.Arrays;
import java.util.Date;
import java.lang.*;

/**
 * @author TinaGVI
 * @since 10.08.2018
 */
public class Tracker {
    private static int generate;
    /**
     * Массив для хранение заявок.
     */
    private final Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position;

    /**
     * Метод реализаущий добавление заявки в хранилище
     *
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
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
        for (int i = 0; i < position; i++) {
            if (id.equals(items[i].getId())) {
                item.setId(id);
                this.items[i] = item;
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
        for (int i = 0; i < position; i++) {
            if (id.equals(items[i].getId())) {
                System.arraycopy(this.items, i + 1, this.items, i, position - i);
                --position;
                result = true;
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
    public Item[] findAll() {
        if (position == 0) {
            return new Item[]{};
        }
        return Arrays.copyOf(this.items, position);
    }

    /**
     * Mетод получение списка по имени.
     *
     * @param name уникальныйключ.
     * @return список.
     */
    public Item[] findByName(String name) {
        Item[] result = new Item[position];
        int i = 0;
        for (Item item : items) {
            if (item == null) {
                break;
            }
            if (item.getName().equals(name)) {
                result[i++] = item;
            }
        }
        Item[] arr = new Item[i];
        System.arraycopy(result, 0, arr, 0, i);
        return arr;
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