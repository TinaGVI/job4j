package ru.job4j.tracker;

import java.util.Arrays;

/**
 * @author TinaGVI
 * @since 19.08.2018
 */
public class StartUI {
    /**
     * Константы меню.
     */
    private static final String ADD = "0";
    private static final String SHOW = "1";
    private static final String EDIT = "2";
    private static final String DELETE = "3";
    private static final String FIND_BY_ID = "4";
    private static final String FIND_BY_NAME = "5";
    private static final String EXIT = "6";
    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                //добавление заявки вынесено в отдельный метод.
                this.createItem();
            } else if (SHOW.equals(answer)) {
                this.findAll();

            } else if (EDIT.equals(answer)) {
                this.replace();

            } else if (DELETE.equals(answer)) {
                this.delete();

            } else if (FIND_BY_ID.equals(answer)) {
                this.findById();

            } else if (FIND_BY_NAME.equals(answer)) {
                this.findByName();

            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    /**
     * Метод реализует вывод всех заявок.
     */
    private void findAll() {
        System.out.println("------------ Вывод всех заявок --------------");
        System.out.println(this.tracker.findAll());
    }

    /**
     * Метод реализует редактирование заявки в хранилище.
     */
    private void replace() {
        System.out.println("------------ Редактирование заявки --------------");
        String id = this.input.ask("Введите id заявки, которую хотите изменить:");
        String name = this.input.ask("Введите новое имя заявки :");
        String desc = this.input.ask("Введите новое описание заявки :");
        Item item = new Item(name, desc, 11L);
        this.tracker.replace(id, item);
        System.out.println("------------ Заявка с изменина -----------");
    }

    /**
     * Метод реализует удаление заявки в хранилище.
     */
    private void delete() {
        System.out.println("------------ Удаление заявки --------------");
        String id = this.input.ask("Введите id заявки, которую хотите удалить:");
        this.tracker.delete(id);
        System.out.println("------------ Заявка с удалена -----------");
    }

    /**
     * Метод реализует поиск заявки по id в хранилище.
     */
    private void findById() {
        System.out.println("------------ Поиск заявки по id --------------");
        String id = this.input.ask("Введите id заявки, которую хотите найти:");
        Item item = this.tracker.findById(id);
        System.out.println("------------ Найдена заявка по id " + item + "  -----------");
    }

    /**
     * Метод реализует поиск заявки по имени в хранилище.
     */
    private void findByName() {
        System.out.println("------------ Поиск заявки по имени --------------");
        String id = this.input.ask("Введите имя заявки, которую хотите найти:");
        Item[] items = this.tracker.findByName(id);
        System.out.println("------------ Найдена заявка по id  " + Arrays.toString(items) + " -----------");
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc, 11L);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    /**
     * Метод реализует показ меню.
     */
    private void showMenu() {
        System.out.println("Меню.");
        System.out.println("Выберети 0 - добавить новую заявку.");
        System.out.println("Выберете 1 - показать все заявки.");
        System.out.println("Выберети 2 - редактировать заявку.");
        System.out.println("Выберети 3 - удалить заявку.");
        System.out.println("Выберети 4 - найти заявку по id.");
        System.out.println("Выберети 5 - найти заявку по имени.");
        System.out.println("Выберети 6 - показать все заявки.");
    }

    /**
     * Запускт программы.
     *
     * @param args
     */
    public static void main(String[] args) {

        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
