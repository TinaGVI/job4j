package ru.job4j.search;

/**
 * Test несколько записей, сортирует по проиоритету.
 *
 * @author TinaGVI
 * @since 08.10.2018
 */

import org.junit.Test;
import ru.job4j.search.PriorityQueue;
import ru.job4j.search.Task;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PriorityQueueTest {
    @Test
    public void whenHigherPriority() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("low_5", 5));
        queue.put(new Task("low_2", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 3));
        queue.put(new Task("middle", 8));
        System.out.println(queue);
        Task result = queue.take();
        assertThat(result.getDesc(), is("urgent"));
        assertThat(queue.take().getDesc(), is("middle"));
        assertThat(queue.take().getDesc(), is("low_5"));
        assertThat(queue.take().getDesc(), is("low_2"));
        assertThat(queue.take().getDesc(), is("middle"));
    }

}