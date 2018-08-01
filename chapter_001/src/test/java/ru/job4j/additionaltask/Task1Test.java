package ru.job4j.additionaltask;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author TinaGVI (mailto:eleonor111@list.ru)
 * @since 27.07.2018
 */
public class Task1Test {
    @Test
    public void whenThirdArrayUnitFromTheFirstAndSecondArray() {
        Task1 task = new Task1();
        int[] first = new int[]{1, 2, 5, 10};
        int[] second = new int[]{3, 4, 7, 9, 12};
        int[] result = task.unite(first, second);
        assertThat(result, is(new int[]{1, 2, 3, 4, 5, 7, 9, 10, 12}));
    }
}
