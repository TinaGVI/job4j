package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author TinaGVI (mailto:eleonor111@list.ru)
 * @since 23.07.2018
 */
public class BubbleSortTest {
    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {
        BubbleSort buble = new BubbleSort();
        int[] result = buble.sort(new int[]{1, 5, 4, 2, 3, 1, 7, 8, 0, 5});
        assertThat(result, is(new int[]{0, 1, 1, 2, 3, 4, 5, 5, 7, 8}));
    }

    @Test
    public void whenSortArrayWithFiveElementsThenSortedArray() {
        BubbleSort buble = new BubbleSort();
        int[] result = buble.sort(new int[]{4, 6, 2, 4, 3});
        assertThat(result, is(new int[]{2, 3, 4, 4, 6}));
    }
}