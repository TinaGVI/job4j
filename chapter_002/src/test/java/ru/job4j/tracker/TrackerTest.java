package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;

/**
 * @author TinaGVI
 * @since 10.08.2018
 */
public class TrackerTest {

    @Test
    public void addTest() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        item = new Item("test7", "testDescription1", 128L);
        tracker.add(item);
        assertThat(tracker.findAll()[1], is(item));
    }

    @Test
    public void replaceTest() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2", 1234L);
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    @Test
    public void deleteTest() {
        Tracker tracker = new Tracker();
        Item item = new Item("item2", "desc2", 13L);
        tracker.add(item);
        item = new Item("item3", "desc3", 14);
        tracker.add(item);
        Item expected = new Item("item3", "desc3", 14);
        tracker.delete(item.getId());
        expected = null;
        assertThat(tracker.findAll()[1], is(expected));
    }

    @Test
    public void findAllTest() {
        Tracker tracker = new Tracker();
        Item item = new Item("item4", "desc4", 15);
        tracker.add(item);
        item = new Item("item5", "desc6", 16);
        tracker.add(item);
        Item expected = new Item("item5", "desc6", 16);
        expected.setId(item.getId());
        assertThat(tracker.findAll()[1], is(expected));

    }


    @Test
    public void findByName() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("item20", "desc19", 25); //item1 == item2
        tracker.add(item1);
        Item item2 = new Item("item20", "desc21", 26);
        tracker.add(item2);
        Item item3 = new Item("item22", "desc23", 27);
        tracker.add(item3);
        Item expected1 = new Item("item20", "desc19", 25);
        expected1.setId(item1.getId());
        Item expected2 = new Item("item20", "desc21", 26);
        expected2.setId(item2.getId());
        Item[] expected = new Item[]{expected1, expected2};
        assertArrayEquals(tracker.findByName("item20"), expected);

    }

    @Test
    public void findById() {
        Tracker tracker = new Tracker();
        Item item = new Item("item12", "desc13", 23);
        tracker.add(item);
        item = new Item("item14", "desc15", 24);
        tracker.add(item);
        Item expected = new Item("item14", "desc15", 24);
        expected.setId(item.getId());
        assertThat(tracker.findById(item.getId()), is(expected));
    }
}
