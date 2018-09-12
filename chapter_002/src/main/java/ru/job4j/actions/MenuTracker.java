package ru.job4j.actions;


        import ru.job4j.stogare.Tracker;
        import ru.job4j.input.Input;
        import ru.job4j.model.Item;

        import java.util.ArrayList;
        import java.lang.String;
        import java.util.List;

/**
 * @author TinaGVI
 * @since 11.09.18
 */
public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private List<UserAction> actions = new ArrayList<>();
    private int[] range;

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public int[] getRange() {
        return range;
    }

    {
        fillActions();
        fillRange();
    }

    public int getActionsLength() {
        return this.actions.size();
    }

    /**
     * Метод заполняет массив.
     */
    public void fillActions() {
        this.actions.add(new AddItem(0, " - Создание заявки"));
        this.actions.add(new ShowItems(1, " - Показать все заявки"));
        this.actions.add(new MenuTracker.EditItem(2, " - Редактировать заявку"));
        this.actions.add(new MenuTracker.DeleteItem(3, " - Удалить заявку"));
        this.actions.add(new FindItemById(4, " - Найти заявку по id"));
        this.actions.add(new FindItemsByName(5, " - Найти заявку по имени"));
        this.actions.add(new ExitProgram(6, " - Выйти из меню"));

    }

    public void fillRange() {
        range = new int[getActionsLength()];
        int i = 0;
        for (UserAction act : this.actions) {
            range[i++] = act.key();
        }
    }

    /**
     * Метод в зависимости от указанного ключа, выполняет соотвествующие действие.
     *
     * @param key ключ операции
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    /**
     * Метод выводит на экран меню.
     */
    public void show() {
        System.out.println("Меню.");
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
        System.out.println("Выберети: ");
    }

    /**
     * Класс удаления заявки.
     */
    public class DeleteItem extends BaseAction {
        public DeleteItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Удаление заявки --------------");
            String id = input.ask("Введите id заявки, которую хотите удалить:");
            tracker.delete(id);
            System.out.println("------------ Заявка с удалена -----------");
        }
    }

    /**
     * Класс редактирования заявки.
     */

    public class EditItem extends BaseAction {
        public EditItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Редактирование заявки --------------");
            String id = input.ask("Введите id заявки на редактирование:");
            String name = input.ask("Введите новое имя заявки :");
            String desc = input.ask("Введите новое описание заявки :");
            Item item = new Item(name, desc);
            tracker.replace(id, item);
            System.out.println("------------ Заявка с изменина -----------");
        }
    }

    /**
     * Класс выхода из программы.
     */

    public class ExitProgram extends BaseAction {
        public ExitProgram(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Выход из меню --------------");
        }
    }
}



