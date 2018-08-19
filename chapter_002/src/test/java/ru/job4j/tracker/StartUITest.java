package ru.job4j.tracker;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author TinaGVI
 * @since 19.08.2018
 */
public class StartUITest {

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "ADD", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("ADD"));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test SHOW", "desc", 45L));
        Input input = new StubInput(new String[]{"2", item.getId(), "test SHOW", "заменили заявку", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test SHOW"));
    }

    @Test
    public void testDeleteTask() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test DELETE", "desc", 46L));
        Input input = new StubInput(new String[]{"3", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().length, is(0));
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
