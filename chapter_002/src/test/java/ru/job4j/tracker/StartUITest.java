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

    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
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
        Item item = tracker.add(new Item("test SHOW", "заменили заявку", 45L));
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(this.out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("Меню.").append(nl)
                                .append("Выберети 0 - добавить новую заявку.").append(nl)
                                .append("Выберете 1 - показать все заявки.").append(nl)
                                .append("Выберети 2 - редактировать заявку.").append(nl)
                                .append("Выберети 3 - удалить заявку.").append(nl)
                                .append("Выберети 4 - найти заявку по id.").append(nl)
                                .append("Выберети 5 - найти заявку по имени.").append(nl)
                                .append("Выберети 6 - выйти из меню.").append(nl)
                                .append("Выберети: ").append(nl)
                                .append("------------ Вывод всех заявок --------------").append(nl)
                                .append("ID: " + item.getId() + "; ")
                                .append("Name: " + item.getName() + "; ")
                                .append("Description: " + item.getDescription()).append(nl)
                                .append("Меню.").append(nl)
                                .append("Выберети 0 - добавить новую заявку.").append(nl)
                                .append("Выберете 1 - показать все заявки.").append(nl)
                                .append("Выберети 2 - редактировать заявку.").append(nl)
                                .append("Выберети 3 - удалить заявку.").append(nl)
                                .append("Выберети 4 - найти заявку по id.").append(nl)
                                .append("Выберети 5 - найти заявку по имени.").append(nl)
                                .append("Выберети 6 - выйти из меню.").append(nl)
                                .append("Выберети: ").append(nl)
                                .toString()
                )
        );
    }

    @Test
    public void testDeleteTask() {
        String nl = System.lineSeparator();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test DELETE", "desc", 46L));
        Input input = new StubInput(new String[]{"3", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(this.out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("Меню.").append(nl)
                                .append("Выберети 0 - добавить новую заявку.").append(nl)
                                .append("Выберете 1 - показать все заявки.").append(nl)
                                .append("Выберети 2 - редактировать заявку.").append(nl)
                                .append("Выберети 3 - удалить заявку.").append(nl)
                                .append("Выберети 4 - найти заявку по id.").append(nl)
                                .append("Выберети 5 - найти заявку по имени.").append(nl)
                                .append("Выберети 6 - выйти из меню.").append(nl)
                                .append("Выберети: ").append(nl)
                                .append("------------ Удаление заявки --------------").append(nl)// ферштейн? умочка!
                                .append("------------ Заявка с удалена -----------").append(nl)
                                .append("Меню.").append(nl)
                                .append("Выберети 0 - добавить новую заявку.").append(nl)
                                .append("Выберете 1 - показать все заявки.").append(nl)
                                .append("Выберети 2 - редактировать заявку.").append(nl)
                                .append("Выберети 3 - удалить заявку.").append(nl)
                                .append("Выберети 4 - найти заявку по id.").append(nl)
                                .append("Выберети 5 - найти заявку по имени.").append(nl)
                                .append("Выберети 6 - выйти из меню.").append(nl)
                                .append("Выберети: ").append(nl)
                                .toString()
                )
        );
    }

    @Test
    public void testFindTaskById() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test FIND_BY_ID", "desc", 47L));
        Input input = new StubInput(new String[]{"4", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test FIND_BY_ID"));
    }

    @Test
    public void testFindTasksByName() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("test FIND_BY_NAME", "desc", 48L));
        Input input = new StubInput(new String[]{"5", "test FIND_BY_NAME", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test FIND_BY_NAME"));
    }
}
