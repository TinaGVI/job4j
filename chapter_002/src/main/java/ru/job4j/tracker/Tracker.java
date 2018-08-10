package ru.job4j.tracker;

import java.util.Date;

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
    public void replace(String id, Item item) {
        for (int i = 0; i < position; i++) {
            if (id.equals(items[i].getId())) {
                item.setId(id);
                this.items[i] = item;
                break;
            }
        }
    }

    /**
     * Метод удаление заявок.
     *
     * @param id айди заявки на удаление.
     */
    public void delete(String id) {
        for (int i = 0; i < position; i++) {
            if (id.equals(items[i].getId())) {
                this.items[i] = null;
                break;
            }
        }
    }


    /**
     * Mетод получение списка всех заявок.
     *
     * @return список заявок.
     */
    public Item[] findAll() {
        Item[] result = new Item[position];
        for (int i = 0; i < position; i++) {
            result[i] = items[i];
        }
        return result;
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