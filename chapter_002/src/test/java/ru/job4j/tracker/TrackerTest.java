package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.actions.model.Item;
import ru.job4j.tracker.actions.stogare.Tracker;

import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
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
        Item item = new Item("test1", "testDescription");
        tracker.add(item);
        assertThat(tracker.findAll()[0], is(item));
    }

    @Test
    public void replaceTest() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription");
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2");
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    @Test
    public void deleteTest() {
        Tracker tracker = new Tracker();
        Item[] items = {
                new Item("item2", "desc2"),
                new Item("item3", "desc3")
        };
        tracker.add(items[0]);
        tracker.add(items[1]);
        tracker.delete(items[1].getId());
        Item[] actual = tracker.findAll();
        items[0].setId(actual[0].getId());
        assertThat(actual, arrayContainingInAnyOrder(items[0]));
    }

    @Test
    public void findAllTest() {
        Tracker tracker = new Tracker();
        Item item = new Item("item4", "desc4");
        tracker.add(item);
        item = new Item("item5", "desc6");
        tracker.add(item);
        Item expected = new Item("item5", "desc6");
        expected.setId(item.getId());
        assertThat(tracker.findAll()[1], is(expected));

    }


    @Test
    public void findByName() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("item20", "desc19"); //item1 == item2
        tracker.add(item1);
        Item item2 = new Item("item20", "desc21");
        tracker.add(item2);
        Item item3 = new Item("item22", "desc23");
        tracker.add(item3);
        Item expected1 = new Item("item20", "desc19");
        expected1.setId(item1.getId());
        Item expected2 = new Item("item20", "desc21");
        expected2.setId(item2.getId());
        Item[] expected = new Item[]{expected1, expected2};
        assertArrayEquals(tracker.findByName("item20"), expected);

    }

    @Test
    public void findById() {
        Tracker tracker = new Tracker();
        Item item = new Item("item12", "desc13");
        tracker.add(item);
        item = new Item("item14", "desc15");
        tracker.add(item);
        Item expected = new Item("item14", "desc15");
        expected.setId(item.getId());
        assertThat(tracker.findById(item.getId()), is(expected));
    }
}
