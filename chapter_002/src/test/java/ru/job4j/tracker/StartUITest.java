package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author TinaGVI
 * @since 20.08.2018
 */
public class StartUITest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private StringBuilder menu = new StringBuilder();

    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
        String nl = System.lineSeparator();
        menu.append("Меню.").append(nl)
                .append("0. - Создание заявки").append(nl)
                .append("1. - Показать все заявки").append(nl)
                .append("2. - Редактировать заявку").append(nl)
                .append("3. - Удалить заявку").append(nl)
                .append("4. - Найти заявку по id").append(nl)
                .append("5. - Найти заявку по имени").append(nl)
                .append("6. - Выйти из меню").append(nl);
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }

    @Test
    public void whenAddTask() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "ADD", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("ADD"));
    }

    @Test
    public void whenShowTask() {
        String nl = System.lineSeparator();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test SHOW", "заменили заявку"));
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(this.out.toByteArray()),
                is(new StringBuilder()
                        .append(menu)
                        .append("Выберети: ").append(nl)
                        .append("------------ Вывод всех заявок --------------").append(nl)
                        .append("ID: " + item.getId() + "; ")
                        .append("Name: " + item.getName() + "; ")
                        .append("Description: " + item.getDescription()).append(nl)
                        .append(menu)
                        .append("Выберети: ").append(nl)
                        .append("------------ Выход из меню --------------").append(nl)
                        .toString()
                )
        );
    }

    @Test
    public void testDeleteTask() {
        String nl = System.lineSeparator();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test DELETE", "desc"));
        Input input = new StubInput(new String[]{"3", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(this.out.toByteArray()),
                is(new StringBuilder()
                        .append(menu)
                        .append("Выберети: ").append(nl)
                        .append("------------ Удаление заявки --------------").append(nl)// ферштейн? умочка!
                        .append("------------ Заявка с удалена -----------").append(nl)
                        .append(menu)
                        .append("Выберети: ").append(nl)
                        .append("------------ Выход из меню --------------").append(nl)
                        .toString()
                )
        );
    }

    @Test
    public void testFindTaskById() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test FIND_BY_ID", "desc"));
        Input input = new StubInput(new String[]{"4", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test FIND_BY_ID"));
    }

    @Test
    public void testFindTasksByName() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("test FIND_BY_NAME", "desc"));
        Input input = new StubInput(new String[]{"5", "test FIND_BY_NAME", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test FIND_BY_NAME"));
    }
}
